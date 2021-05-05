package com.ykko.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ykko.interceptor.AuthenticationInterceptor;
import com.ykko.interceptor.ValidationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	private static final Logger logger = LogManager.getLogger(InterceptorConfig.class);
	
	@Autowired
	AuthenticationInterceptor authInterceptor;
	
	@Autowired
	ValidationInterceptor valInterceptor;
	
	public InterceptorConfig() {
		logger.info("*** InterceptorConfig created!");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(authInterceptor).addPathPatterns("/test/**").order(Ordered.HIGHEST_PRECEDENCE);
		registry.addInterceptor(valInterceptor).addPathPatterns("/test/**").order(Ordered.LOWEST_PRECEDENCE);
	}
	
	

}
