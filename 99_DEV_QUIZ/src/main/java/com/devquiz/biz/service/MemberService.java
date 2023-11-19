package com.devquiz.biz.service;

import java.util.List;

import com.devquiz.biz.model.MemberVO;

public interface MemberService {
	//CRUD 기능 구현 메소드 정의
	void updateMember(MemberVO vo);
	void deleteMember(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	List<MemberVO> getMemberList(MemberVO vo);
	List<MemberVO> getId(MemberVO vo);
	int getIdCnt(MemberVO vo);
}
