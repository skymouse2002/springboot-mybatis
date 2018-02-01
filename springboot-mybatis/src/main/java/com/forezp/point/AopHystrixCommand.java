package com.forezp.point;

import org.aspectj.lang.ProceedingJoinPoint;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class AopHystrixCommand extends HystrixCommand<Object> {
	
	private final ProceedingJoinPoint point;
	public AopHystrixCommand(ProceedingJoinPoint point){
		//最少配置:指定命令组名(CommandGroup)  
        super(HystrixCommandGroupKey.Factory.asKey("aopGroup"));
        this.point=point;
	}

//	protected AopHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter setter) {
//		super(setter);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	protected Object run() throws Exception {
		// TODO Auto-generated method stub
		try {
			return point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw (Exception) e;
		}
	}
//	@Override  
//    protected Object getFallback() {  
//        return null;  
//    }  

}
