package com.ssafy.sample.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.Emp;
import com.ssafy.sample.model.service.EmpService;
import com.ssafy.sample.model.service.EmpServiceImpl;

// FC가 보낸 요청을 받아서 처리
// service에게 요청 처리를 pass
public class EmpController {
	
	EmpService service;
	
	public EmpController() {
		service = new EmpServiceImpl();
	}

	public void selectAll(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Emp> list = service.selectAll();
		req.setAttribute("list", list);
		
		// jsp(화면 담당)로 넘어가야함
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void selectOne(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	public void insertForm(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	public void insert(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	public void delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}
