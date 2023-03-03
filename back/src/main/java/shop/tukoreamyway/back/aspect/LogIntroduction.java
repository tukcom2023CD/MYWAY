package shop.tukoreamyway.back.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public final class LogIntroduction {

    @Before("execution(* shop.tukoreamyway.back..*Controller.*(..))")
    public void controllerLog(JoinPoint joinPoint) {
        log.info("CONTROLLER : {}", joinPoint.getSignature());
    }

    @Before("execution(* shop.tukoreamyway.back..*Service.*(..))")
    public void serviceLog(JoinPoint joinPoint) {
        log.info("SERVICE : {}", joinPoint.getSignature());
    }

    @Before("execution(* shop.tukoreamyway.back..*Handler.*(..))")
    public void handlerLog(JoinPoint joinPoint) {
        log.info("HANDLER : {}", joinPoint.getSignature());
    }
}
