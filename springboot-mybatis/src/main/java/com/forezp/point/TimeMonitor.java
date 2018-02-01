package com.forezp.point;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeMonitor {
	@Around("execution(* com.forezp.service.AccountService.*(..))")
    public Object monitorAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("method start time:" + System.currentTimeMillis());
        Object re=new AopHystrixCommand(pjp).execute();
//        Object re = pjp.proceed();
        System.out.println("method end time:" + System.currentTimeMillis());
        return re;
    }
}
