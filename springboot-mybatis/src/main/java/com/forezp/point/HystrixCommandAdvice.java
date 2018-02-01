/**
 * 本来准备用来测试断路器在切面的应用，现在暂时无用了2018.2.1
 */
package com.forezp.point;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

//@Component
//@Aspect
public class HystrixCommandAdvice {
	private String groupName;  
    private String commandName;  
//    @Pointcut()
//    public Object runCommand(final ProceedingJoinPoint pjp) {  
//        return wrapWithHystrixCommnad(pjp).execute();  
//    }  
//  
//    private HystrixCommand<Object> wrapWithHystrixCommnad(final ProceedingJoinPoint pjp) {  
//        return new HystrixCommand<Object>(setter()) {  
//            @Override  
//            protected Object run() throws Exception {  
//                try {  
//                    return pjp.proceed();  
//                } catch (Throwable throwable) {  
//                    throw (Exception) throwable;  
//                }  
//            }  
//  
//            @Override  
//            protected Object getFallback() {  
//                return null;  
//            }  
//        };  
//    }  
//    private HystrixCommand.Setter setter() {  
//        return HystrixCommand.Setter  
//                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupName))  
//                .andCommandKey(HystrixCommandKey.Factory.asKey(commandName));  
//    }  
//  
//    public void setGroupName(String groupName) {  
//        this.groupName = groupName;  
//    }  
//  
//    public void setCommandName(String commandName) {  
//        this.commandName = commandName;  
//    }  
}
