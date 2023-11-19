package com.devquiz.biz.service;

import java.util.List;

import com.devquiz.biz.model.BoardVO;

public interface BoardService {
	//CRUD 기능 구현 메소드 정의
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	String getWriter(BoardVO vo);
	String getCategory(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	List<BoardVO> getNoticeBoardList(BoardVO vo);	
}
