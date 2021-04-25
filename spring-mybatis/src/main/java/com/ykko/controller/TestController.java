package com.ykko.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ykko.entity.Employee;
import com.ykko.entity.Request;
import com.ykko.entity.Response;
import com.ykko.service.EmployeeService;

@RestController
@RequestMapping(value="test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	private String template = "Hello, %s!";
	
	@Autowired
	private EmployeeService empService;
	
	public TestController() {
		if(logger.isDebugEnabled()) {
			logger.debug("*** TestController created! ***");
		}
	}
	
	//http://localhost:8080/mybatis/test/g1
	@GetMapping("/g1")
	public Response g1() {
		return new Response("1",200,"g1");
	}
	
	//http://localhost:8080/rest/test/g2?name=ykko
	@GetMapping("/g2")
	public Response g2(@RequestParam(value="name", defaultValue="World") String name) {
		String val = String.format(template, name);			
		return new Response("1",200,val);
	}
	
	//http://localhost:8080/rest/test/employee/7369
	@GetMapping("/employee/{id}")
	public Response getEmployee(@PathVariable int id) {
		logger.debug("id: " + id);
		Employee emp = empService.findByEmpNo(id);
		if(emp != null) {
			return new Response("1",200,emp.getEname());	
		}
		else {
			return new Response("1",404,"No employee");
		}
	}
		
	@PostMapping("/p2")
	public Response p2(@RequestBody String payload) {		
		return new Response("1",200, payload);
	}
	
	
}
