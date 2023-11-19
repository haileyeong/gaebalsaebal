package com.devquiz.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devquiz.biz.model.BoardVO;

@Repository
public class BoardDAO {
	//@Autowired
	private SqlSessionTemplate mybatis;
	
	public BoardDAO() {
		System.out.println(">>> BoardDAO() 객체 생성");
	}
	@Autowired
	public BoardDAO(SqlSessionTemplate mybatis) {
		System.out.println(">>> BoardDAO(SqlSessionTemplate) 객체 생성");
		this.mybatis = mybatis;
	}

	
	//작성자 닉네임 조회
	public String getWriter(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 getwriter() 실행");
		return mybatis.selectOne("boardDAO.getWriter", vo);
	}
	
	//카테고리 조회
	public String getCategory(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 getCategory() 실행");
		return mybatis.selectOne("boardDAO.getCategory", vo);
	}
	
	//글입력
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 insertBoard() 실행");
		mybatis.insert("boardDAO.insertBoard", vo);
	}

	//글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 updateBoard() 실행");
		mybatis.update("boardDAO.updateBoard", vo);
	}

	//글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 deleteBoard() 실행");
		mybatis.delete("boardDAO.deleteBoard", vo);
	}

	//게시글 1개 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 getBoard() 실행");
		return mybatis.selectOne("boardDAO.getBoard", vo);
	}

	//커뮤니티 게시글 조회
	public List<BoardVO> getBoardList() {
		System.out.println("===> MyBatis JDBC로 getBoardList() 실행");
		return null;
	}
	
	//커뮤니티 게시글 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 getBoardList() 실행");
		// 검색조건 값이 없을 때 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		String sql = "";
		if ("TITLE".equals(vo.getSearchCondition())) {
			sql = "boardDAO.getBoardList_T";
		} else if ("CONTENT".equals(vo.getSearchCondition())) {
			sql = "boardDAO.getBoardList_C";
		}
		
		return mybatis.selectList(sql, vo.getSearchKeyword());
	}

	//공지사항 게시글 조회
	public List<BoardVO> getNoticeBoardList(BoardVO vo) {
		System.out.println("===> MyBatis JDBC로 getNoticeBoardList() 실행");
		// 검색조건 값이 없을 때 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		String sql = "";
		if ("TITLE".equals(vo.getSearchCondition())) {
			sql = "boardDAO.getNoticeBoardList_T";
		} else if ("CONTENT".equals(vo.getSearchCondition())) {
			sql = "boardDAO.getNoticeBoardList_C";
		}
		
		return mybatis.selectList(sql, vo.getSearchKeyword());
	}
	
	
}
