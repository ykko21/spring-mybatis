package com.ykko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ykko.entity.Department;
import com.ykko.entity.Employee;

@Service
public class CompositeService {

	@Autowired
	DepartmentService deptService;
	@Autowired
	EmployeeService empService;
	
	@Transactional
	public void insertDeptEmp(Department dept, Employee emp) throws Exception{
		deptService.insert(dept);
		empService.insert(emp);
	}
}
