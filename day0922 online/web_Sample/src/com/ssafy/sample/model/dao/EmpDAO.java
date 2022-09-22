package com.ssafy.sample.model.dao;

import java.util.ArrayList;

import com.ssafy.sample.dto.Emp;

public interface EmpDAO {
	
	ArrayList<Emp> selectAll();
	Emp selectOne(String empid);
	int insert(Emp e);
	int delete(String empid);

}
