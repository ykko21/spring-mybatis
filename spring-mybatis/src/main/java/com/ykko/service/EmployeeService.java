package com.ykko.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ykko.entity.Employee;
import com.ykko.repository.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
		
	public Employee findByEmpNo(int empNo) {
		Employee emp = new Employee();
		SqlSession session = sqlSessionFactory.openSession();
		emp = session.selectOne("employee.findByEmpNo", empNo);
		return emp;
	}
	
	@Transactional
	public void insert(Employee obj) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("employee.insert", obj);
	}
}
