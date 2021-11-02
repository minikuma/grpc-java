package me.minikuma.v2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@ActiveProfiles("local")
@SpringBootTest
public class BeanListTest {
    @Autowired
    DefaultListableBeanFactory bf;

    @Test
    void getBeans() {
        for (String name : bf.getBeanDefinitionNames()) {
            log.info(name + " \t " +  bf.getBean(name).getClass().getName());
        }
    }
}
