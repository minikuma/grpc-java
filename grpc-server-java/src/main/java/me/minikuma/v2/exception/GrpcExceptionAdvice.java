package me.minikuma.v2.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

import java.util.NoSuchElementException;

@GrpcAdvice
public class GrpcExceptionAdvice {

    @GrpcExceptionHandler
    public Status handlerInvalidArgument(IllegalArgumentException e) {
        return Status.INVALID_ARGUMENT.withDescription("잘못된 요청입니다.").withCause(e);
    }

    @GrpcExceptionHandler
    public StatusRuntimeException handlerResourceNotFountException(NoSuchElementException e) {
        Status status = Status.NOT_FOUND.withDescription("상품 정보 미 존재");
        return status.asRuntimeException();
    }
}
