package com.ykko.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ykko.entity.Department;

@Service
public class DepartmentService {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	public Department findByDeptNo(int deptNo) {
		SqlSession session = sqlSessionFactory.openSession();
		Department obj = session.selectOne("department.findByDeptNo", deptNo);
		return obj;
	}
	
	@Transactional
	public void insert(Department obj) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("department.insert", obj);
	}
}
