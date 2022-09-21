package com.mvc.model.service;

import java.util.ArrayList;

import com.mvc.model.dao.BoardDAO;
import com.mvc.model.dao.BoardDAOImpl;
import com.mvc.model.vo.Board;

// BoardService 인터페이스 안의 메소드를 구현한 객체
// Controller에게서 들어온 요청을 처리하는 객체
// DAO에게 요청을 넘김
public class BoardServiceImpl implements BoardService{
	BoardDAO dao; // Interface type

	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}
	
	@Override
	public ArrayList<Board> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String num) {
		dao.countUp(num); // 해당번호의 글 조회수를 올림
		return dao.selectOne(num);
	}

	@Override
	public void insert(Board b) {
		dao.insert(b);
	}

	@Override
	public void delete(String num) {
		dao.delete(num);
	}

}
