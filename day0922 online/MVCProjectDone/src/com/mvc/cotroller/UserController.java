package com.mvc.cotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.service.UserService;
import com.mvc.model.service.UserServiceImpl;
import com.mvc.model.vo.User;

public class UserController {
	UserService service;
	
	public UserController() {
		service = new UserServiceImpl();
	}

	public void loginForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		String url = "index.jsp";
		
		//1.param받아오기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//2.service에 넘기기
		User user = new User(id, pass);
		boolean flag = service.check(user);
		
		if(flag) {//로그인 성공
			//세션 얻기
			//세션 안에 user 저장	
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
		}else {//로그인 실패
			url = "loginForm.bod";
		}	
		
		//RequestDispatcher 사용해서 forward
		//혹은 response.sendRedirect(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
		
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		//세션 얻기
		//세션안에 저장했던 값 삭제 or세션 삭제
		//초기화면으로 redirect
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		try {
			// response.sendRedirect("list.bod");
			response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
