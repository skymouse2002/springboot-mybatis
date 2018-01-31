package com.forezp.point;

import org.aspectj.lang.ProceedingJoinPoint;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class AopHystrixCommand extends HystrixCommand<ProceedingJoinPoint> {
	
	private final ProceedingJoinPoint point;
	public AopHystrixCommand(ProceedingJoinPoint point){
		//最少配置:指定命令组名(CommandGroup)  
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.point=point;
	}

//	protected AopHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter setter) {
//		super(setter);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	protected ProceedingJoinPoint run() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
