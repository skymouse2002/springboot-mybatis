package com.forezp;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

public class HystrixConfig extends SpringBootServletInitializer{
	@Bean
	public HystrixMetricsStreamServlet hystrixMetricsStreamServlet(){
	    return new HystrixMetricsStreamServlet();
	}
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
    }
//	@Bean
//	public ServletRegistrationBean registration(HystrixMetricsStreamServlet servlet){
//	    ServletRegistrationBean registrationBean = new ServletRegistrationBean();
//	    registrationBean.setServlet(servlet);
//	    registrationBean.setEnabled(true);//是否启用该registrationBean
//	    registrationBean.addUrlMappings("/hystrix.stream");
//	    return registrationBean;
//	}
}
