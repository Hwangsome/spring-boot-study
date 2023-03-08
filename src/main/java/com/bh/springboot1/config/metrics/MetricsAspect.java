package com.bh.springboot1.config.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricsAspect {

    private final MeterRegistry meterRegistry;

    public MetricsAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Around("@annotation(com.bh.springboot1.anno.CountMetrics)")
    public Object countMetrics(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object result;
        try {
            result = joinPoint.proceed();
            meterRegistry.counter("successful_"+methodName+"_count").increment();
        } catch (Exception ex) {
            meterRegistry.counter("failed_"+methodName+"_count").increment();
            throw ex;
        }
        return result;
    }
}
