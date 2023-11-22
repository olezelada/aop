package com.fobbing.ole.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    private final Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @Before("execution(* com.fobbing.ole.aop.services.*.*(..))")
    public void beforeServiceMethods(){
        logger.warn("Before executing service methods");
    }

    @After("execution(* com.fobbing.ole.aop.services.*.*(..))")
    public void afterServiceMethods(){
        logger.warn("After executing service methods");
    }

    @Around("execution(* com.fobbing.ole.aop.services.MyService.*(..))")
    public Object aroundServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.warn("Around executing service methods");
        logger.warn("Before method execution: " + joinPoint.getSignature().getName());
        // Lógica antes de la ejecución del método

        Object result = joinPoint.proceed(); // Invocar al método objetivo

        // Lógica después de la ejecución del método
        logger.warn("After method execution: " + joinPoint.getSignature().getName());

        /*logger.error("joinPoint -> ", joinPoint.toString());
        logger.error("getTarget() -> ", joinPoint.getTarget().toString());
        logger.error("getArgs() -> ", joinPoint.getArgs().toString());
        logger.error("getSignature() -> ", joinPoint.getSignature().getDeclaringTypeName());
        logger.error("getKind() -> ", joinPoint.getKind());
        logger.error("getStaticPart() -> ", joinPoint.getStaticPart().getSignature().getName());
        logger.error("getSourceLocation().getFileName -> ", joinPoint.getSourceLocation().getFileName());
        logger.error("getSourceLocation().getLine -> ", joinPoint.getSourceLocation().getLine());*/

        return result;
    }
}
