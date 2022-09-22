package com.ssafy.sample.model.service;

import java.util.ArrayList;

import com.ssafy.sample.dto.Emp;

// for controller
public interface EmpService {
	
	ArrayList<Emp> selectAll();
	Emp selectOne(String empid);
	int insert(Emp e);
	int delete(String empid);

}
