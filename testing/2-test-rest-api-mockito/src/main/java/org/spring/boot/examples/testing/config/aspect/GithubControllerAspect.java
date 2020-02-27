package org.spring.boot.examples.testing.config.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class GithubControllerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubControllerAspect.class);

    @Before("execution(* org.spring.boot.examples.testing.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {

        LOGGER.debug("Starting {} , using this parameters[{}] ...", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @After(value = "execution(* org.spring.boot.examples.testing.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {

        LOGGER.debug("Execution of {} was ended successfully", joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* org.spring.boot.examples.testing.controller.*.*(..))", returning = "returnObject")
    public void afterRunning(JoinPoint joinPoint, Object returnObject) {

        LOGGER.debug("{} return {}", joinPoint.getSignature().getName(), returnObject);
    }

}
