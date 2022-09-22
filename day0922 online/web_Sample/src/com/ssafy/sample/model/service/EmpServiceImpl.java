package com.ssafy.sample.model.service;

import java.util.ArrayList;

import com.ssafy.sample.dto.Emp;
import com.ssafy.sample.model.dao.EmpDAO;
import com.ssafy.sample.model.dao.EmpDAOImpl;

public class EmpServiceImpl implements EmpService {
	
	EmpDAO dao;
	
	public EmpServiceImpl() {
		dao = new EmpDAOImpl();
	}

	@Override
	public ArrayList<Emp> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Emp selectOne(String empid) {
		return dao.selectOne(empid);
	}

	@Override
	public int insert(Emp e) {
		return dao.insert(e);
	}

	@Override
	public int delete(String empid) {
		return dao.delete(empid);
	}

}
