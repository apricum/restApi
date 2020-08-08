package com.example.bine.aspects;


import com.example.bine.annotations.MDCLogged;
import com.example.bine.annotations.MDCTupleLogged;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
public class MethodMDCLoggingAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(MethodMDCLoggingAspect.class);


    @Around("@annotation(com.example.bine.annotations.MDCLogged)")
    public Object logMDC(ProceedingJoinPoint invocation) throws Throwable{


        Object result = invocation.proceed();
        MethodSignature signature = (MethodSignature) invocation.getSignature();
        Method method = signature.getMethod();
        MDCLogged mdcLogged = method.getAnnotation(MDCLogged.class);
        MDCTupleLogged[] tuplesForLogging = mdcLogged.labelsAndValues();
        StringBuilder stringForLogging = new StringBuilder().append("Logging: ");
        for(MDCTupleLogged tupleForLogging : tuplesForLogging){
            stringForLogging.append(tupleForLogging.label() + ": " + tupleForLogging.value());
        }

//        MDCLogged mdcLogged = method.getAnnotation(MDCLogged.class);
//        String[] putLabels = mdcLogged.putLabels();
//        StringBuilder putLablesSB = new StringBuilder().append("PutLabels: ");
//        String[] removeLabels = mdcLogged.removeLabels();
//        StringBuilder removeLablesSB = new StringBuilder().append("RemoveLabels: ");
//
//        for (String s : putLabels) {
//            putLablesSB.append(s + ", ");
//        }
//        for (String s : removeLabels) {
//            removeLablesSB.append(s + ", ");
//        }
//


       //LOGGER.info("Execution of method {} in {} with args {} ", invocation.getSignature().getName(), invocation.getTarget().getClass().toString(), putLablesSB.toString() + removeLablesSB.toString());
        LOGGER.info("Execution of method {} in {} with args {} ", invocation.getSignature().getName(), invocation.getTarget().getClass().toString(),stringForLogging.toString());

        return result;
    }
}
