package com.example.bine.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MDCLoggingAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(MDCLoggingAspect.class);

    @Around("@annotation(com.example.bine.annotations.MDCLog)")
    public Object time(ProceedingJoinPoint invocation) throws Throwable{

        long start = System.currentTimeMillis();
        Object result = invocation.proceed();
        long stop = System.currentTimeMillis();
        LOGGER.info("Execution of method {} in {} needed {} milliseconds", invocation.getSignature().getName(), invocation.getTarget().getClass().toString(), stop - start);
        return result;
    }
}
