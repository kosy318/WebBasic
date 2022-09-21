package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.service.UserService;
import com.mvc.model.service.UserServiceImpl;
import com.mvc.model.vo.User;

// front controller에게서 요청을 넘겨받아 service에게 넘김
// 나중에 리턴되는 데이터를 받아서 jsp로 넘겨줘야함
public class UserController {
	UserService service; // interface type
	
	public UserController() {
		service = new UserServiceImpl();
	}

	public void loginForm(HttpServletRequest request, HttpServletResponse response) {
		// jsp로 화면을 넘기기(forward 방식으로)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		String url = "/index.jsp";
		// 1. Param 받아오기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// 2. 서비스에 넘기기
		boolean flag = service.check(new User(id, pass));
		if(flag) { // 로그인 성공
			// 세션 얻기
			HttpSession session = request.getSession();
			// 세션 안에 user 저장
			session.setAttribute("user", id);
		} else { // 로그인 실패
			// 로그인 화면
			url = "/loginForm.bod";
		}
		
		// Requestdispatcher 사용해서 forward
		// 혹은 response.sendRedircet(); -> request에 뭘 저장해도 소용 x
		try {
			response.sendRedirect(request.getContextPath() + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// 세션 얻기
		HttpSession session = request.getSession();
		
		// 세션 안에 저장했던 값 삭제 or 세션 삭제
		session.removeAttribute("user");
		
		// 초기 화면으로 redirect
		try {
			response.sendRedirect(request.getContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
