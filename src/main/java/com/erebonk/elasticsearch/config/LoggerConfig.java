package com.erebonk.elasticsearch.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Logger configuration with logstash
 *
 * @author ilya
 * @version 1.0
 */
@Slf4j
@Aspect
@AllArgsConstructor
@Configuration
public class LoggerConfig {

    @AfterReturning(pointcut = "@annotation(com.erebonk.elasticsearch.domain.LoggerStash)")
    public void afterReturning(JoinPoint joinPoint) {
      log.info("Method called: " + joinPoint.getSignature().getName() + "args: "
              + Arrays.toString(joinPoint.getArgs()));
    }

}
