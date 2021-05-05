package com.ykko.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ykko.entity.Response;

@Component
public class ValidationInterceptor implements HandlerInterceptor{

	private static final Logger logger = LogManager.getLogger(ValidationInterceptor.class);
	
	public ValidationInterceptor() {
		logger.info("*** ValidationInterceptor created!");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
//		ObjectMapper mapper = new ObjectMapper();
//		Response res = new Response(UUID.randomUUID().toString(), 400, "failure");
//		response.setContentType("application/json");
//		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//		response.getWriter().write(mapper.writeValueAsString(res));
//		return false;
		
		logger.info("preHandle");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion");
		// TODO Auto-generated method stub
	}
}
