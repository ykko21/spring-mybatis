package com.ykko.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.ykko.entity.Employee;

public interface EmployeeMapper {	
	
	Employee findByEmpNo(@Param("empno") int empno);
	
	
}
