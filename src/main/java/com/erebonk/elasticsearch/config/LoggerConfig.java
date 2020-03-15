package com.erebonk.elasticsearch.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Logger configuration with logstash
 */
@Slf4j
@Aspect
@AllArgsConstructor
@Configuration
public class LoggerConfig {

    @AfterReturning(value = "@annotation(com.erebonk.elasticsearch.domain.LoggerStash)")
    public void afterReturning(JoinPoint joinPoint) {
      log.info("Method: " + joinPoint.getSignature() + " args: " + Arrays.toString(joinPoint.getArgs()));
    }
}
