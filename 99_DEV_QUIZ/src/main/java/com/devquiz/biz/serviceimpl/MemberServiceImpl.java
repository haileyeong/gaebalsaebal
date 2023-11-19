package com.devquiz.biz.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devquiz.biz.dao.MemberDAO;
import com.devquiz.biz.model.BoardVO;
import com.devquiz.biz.model.MemberVO;
import com.devquiz.biz.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired //타입이 일치하는 객체(인스턴스) 주입
	private MemberDAO memberDAO;

	public MemberServiceImpl() {
		System.out.println(">> MemberServiceImpl() 객체 생성");
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return memberDAO.getMember(vo);
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		return memberDAO.getMemberList(vo);
	}
	
	@Override
	public List<MemberVO> getId(MemberVO vo) {
		return memberDAO.getId(vo);
	}

	@Override
	public int getIdCnt(MemberVO vo) {
		return memberDAO.getIdCnt(vo);
	}

}
