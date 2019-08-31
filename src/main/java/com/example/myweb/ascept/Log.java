package com.example.myweb.ascept;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class Log {
    private static final Logger log = LoggerFactory.getLogger(Log.class);

//    @Before("execution(* com.nowcoder.controller.*Controller.*(..))")
    @Before("execution(* com.example.myweb.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        for (Object arg : joinPoint.getArgs()) {
            sb.append("arg:" + arg.toString() + "|");
        }
        log.info("before method:" + sb.toString());
    }

    @After("execution(* com.example.myweb.controller.*Controller.*(..))")
    public void afterMethod() {
        log.info("after method" + new Date());
    }

}
