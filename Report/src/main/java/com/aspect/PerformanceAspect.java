package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/23 9:56 AM
 * $Log: PerformanceAspect.java
 */
@Aspect
@Component
public class PerformanceAspect {

  @Pointcut("within(@org.springframework.stereotype.Repository *)")
  public void repositoryClassMethods() {
  }

  @Around("repositoryClassMethods()")
  public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
    final long start = System.nanoTime();
    Object retval = pjp.proceed();
    final long end = System.nanoTime();
    final String methodName = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
    System.out.println("Execution of " + methodName + " took " +
        TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
/*    logger.info("Execution of " + methodName + " took " +
        TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");*/
    return retval;
  }
}
