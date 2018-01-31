package com.forezp.point;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldHystrixCommand extends HystrixCommand<String> {
	private final String name; 
    public HelloWorldHystrixCommand(String name) {   
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));     
        this.name = name; 
    }

	@Override
	protected String run() throws Exception {
		return "Hello " + name; 
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		//每个Command对象只能调用一次,不可以重复调用,  
        //重复调用对应异常信息:This instance can only be executed once. Please instantiate a new instance.  
		HelloWorldHystrixCommand helloWorldCommand = new HelloWorldHystrixCommand("Synchronous-hystrix");  
        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();   
        String result = helloWorldCommand.execute();  
        System.out.println("result=" + result);  
   
        helloWorldCommand = new HelloWorldHystrixCommand("Asynchronous-hystrix");  
        //异步调用,可自由控制获取结果时机,  
        Future<String> future = helloWorldCommand.queue();  
        //get操作不能超过command定义的超时时间,默认:1秒  
        result = future.get(100, TimeUnit.MILLISECONDS);  
        System.out.println("result=" + result);  
        System.out.println("mainThread=" + Thread.currentThread().getName());  
//		String result = new HelloWorldHystrixCommand("HLX").execute();
//		System.out.println(result); 
	}

}
