package com.forezp.service;

import java.util.List;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.forezp.SpringbootMybatisApplication;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;


public class GetOrderCommand extends HystrixCommand<List> {
	@Autowired
	OrderService orderService;
	public GetOrderCommand(String name){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(name))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(5000)
                )
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                .withMaxQueueSize(10)   //配置队列大小
                                .withCoreSize(2)    // 配置线程池里的线程数
                )
        );
    }

    @Override
    protected List run() throws Exception {
    	System.out.println("begin Run*********");
        return orderService.getOrderList();
    }

    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = SpringbootMybatisApplication.class)
    @WebAppConfiguration
    public static class UnitTest {
        @Test
        public void testGetOrder(){
        	System.out.println("begin test*********");
            List list=new GetOrderCommand("hystrix-order").execute();
            System.out.println("list size is" +list.size());
            Future<List> future =new GetOrderCommand("hystrix-order").queue();
        }

    }


}
