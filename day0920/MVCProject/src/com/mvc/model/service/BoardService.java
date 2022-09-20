package com.mvc.model.service;

import java.util.ArrayList;

import com.mvc.model.vo.Board;

// Controller를 위한 인터페이스
public interface BoardService {
	ArrayList<Board> selectAll(); // 모든 레코드 검색
	Board selectOne(String num); // 해당 번호의 레코드 검색
	void insert(Board b); // 새 레코드 추가
}
