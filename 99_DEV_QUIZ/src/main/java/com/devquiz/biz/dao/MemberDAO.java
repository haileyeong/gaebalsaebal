package com.devquiz.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devquiz.biz.model.BoardVO;
import com.devquiz.biz.model.MemberVO;

@Repository
public class MemberDAO {
	//@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberDAO() {
		System.out.println(">>> MemberDAO() 객체 생성");
	}
	@Autowired
	public MemberDAO(SqlSessionTemplate mybatis) {
		System.out.println(">>> MemberDAO(SqlSessionTemplate) 객체 생성");
		this.mybatis = mybatis;
	}
	
	//아이디로 게시글 내역 조회
	public List<MemberVO> getId(MemberVO vo) {
		System.out.println("===> MyBatis JDBC로 getId() 실행");
		return mybatis.selectList("memberDAO.getId", vo);
	}
	//아이디로 게시글 수 조회
	public int getIdCnt(MemberVO vo) {
		System.out.println("===> MyBatis JDBC로 getIdCnt() 실행");
		return mybatis.selectOne("memberDAO.getIdCnt", vo);
	}

	//회원정보 수정
	public void updateMember(MemberVO vo) {
		System.out.println("===> MyBatis JDBC로 updateMember() 실행");
		mybatis.update("memberDAO.updateMember", vo);
	}

	//회원정보 글삭제
	public void deleteMember(MemberVO vo) {
		System.out.println("===> MyBatis JDBC로 deleteMember() 실행");
		mybatis.update("memberDAO.deleteMember", vo);
	}

	//회원정보  1개 조회
	public MemberVO getMember(MemberVO vo) {
		System.out.println("===> MyBatis JDBC로 getMember() 실행");
		return mybatis.selectOne("memberDAO.getMember", vo);
	}

	//회원정보 조회
	public List<MemberVO> getMemberList() {
		System.out.println("===> MyBatis JDBC로 getMemberList() 실행");
		return null;
	}
	
	//회원정보 조회
	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("===> MyBatis JDBC로 getMemberList() 실행");
		// 검색조건 값이 없을 때 기본값 설정
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("ID");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		String sql = "";
		if ("ID".equals(vo.getSearchCondition())) {
			sql = "memberDAO.getMemberList_I";
		} else if ("NAME".equals(vo.getSearchCondition())) {
			sql = "memberDAO.getMemberList_N";
		}
		
		return mybatis.selectList(sql, vo.getSearchKeyword());
	}
	
}
