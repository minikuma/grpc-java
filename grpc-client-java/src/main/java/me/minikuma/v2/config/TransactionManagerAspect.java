package me.minikuma.v2.config;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;
import java.util.List;

@Aspect
@RequiredArgsConstructor
public class TransactionManagerAspect {

    private final DataSourceTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvise() {

        TransactionInterceptor interceptor = new TransactionInterceptor();

        List<RollbackRuleAttribute> rollbackRules = Collections.singletonList(new RollbackRuleAttribute(Exception.class));

        RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();
        txAttribute.setRollbackRules(rollbackRules);
        txAttribute.setName("*");
        txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttribute.setTimeout(10);

        MatchAlwaysTransactionAttributeSource attribute = new MatchAlwaysTransactionAttributeSource();
        attribute.setTransactionAttribute(txAttribute);

        interceptor.setTransactionManager(this.transactionManager);
        interceptor.setTransactionAttributeSource(attribute);

        return interceptor;
    }

    @Bean
    public Advisor txAdvisor(TransactionInterceptor txAdvise) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* me.minikuma.v2..*Service.*(..))");
        return new DefaultPointcutAdvisor(pointcut, txAdvise);
    }
}
