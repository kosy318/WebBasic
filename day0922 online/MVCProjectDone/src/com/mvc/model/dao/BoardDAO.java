package com.mvc.model.dao;

import java.util.ArrayList;

import com.mvc.model.vo.Board;

//Service를 위한 인터페이스
public interface BoardDAO {
	ArrayList<Board> selectAll();//모든 레코드 검색
	Board selectOne(String num);//해당 번호의 레코드 검색
	void insert(Board b);//새 레코드 추가
	int countUp(String num);
	int delete(String num);
}
