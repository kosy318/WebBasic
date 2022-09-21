package com.mvc.contoller;

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

	public void loginForm(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/loginForm.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) {
		String url = "/index.jsp";
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		boolean flag = service.check(new User(id, pass));
		if(flag) {
			HttpSession session = req.getSession();
			session.setAttribute("user", id);
		} else {
			url = "/loginForm.bod";
		}
		
		try {
			resp.sendRedirect(req.getContextPath() + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		
		try {
			resp.sendRedirect(req.getContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
