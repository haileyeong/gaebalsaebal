package com.devquiz.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.devquiz.biz.model.MemberVO;
import com.devquiz.biz.service.MemberService;

@Controller
@SessionAttributes("member")
//@RequestMapping("/member")
//-to. 예림씨 / 예림씨~왜인지 Requestmapping을 하면 페이지간 이동이 안되어서 우선 주석처리 합니다..!! //하영
public class MemberController {
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("===========> MemberController() 객체 생성");
	}
	
	@Autowired
	public MemberController(MemberService memberService) {
		System.out.println("===========> MemberController(memberService) 객체 생성");
		System.out.println("::: MemberService memberService : " + memberService);
		this.memberService = memberService;
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("====> Map searchConditionMap() 실행");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("아이디", "ID");
		conditionMap.put("이름", "NAME");
		return conditionMap;
	}

	@RequestMapping("/get_member")
	public String getMember(MemberVO vo, Model model) {
		System.out.println(">>> 회원 상세 보여주기");
		System.out.println("vo : " + vo);

		MemberVO member = memberService.getMember(vo);
		int cnt = memberService.getIdCnt(vo);
		System.out.println("member : " + member);
		
		model.addAttribute("member", member);
		model.addAttribute("cnt", cnt);
		
		return "admin/member/getMember";
	}
	
	@RequestMapping("/get_member_list")
	public String getMemberList(MemberVO vo, Model model) {
		System.out.println(">>> 회원 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
		List<MemberVO> memberList = memberService.getMemberList(vo);
		
		model.addAttribute("memberList", memberList); 
		
		return "admin/member/getMemberList";
	}
	
	
	@RequestMapping("/update_memeber")
	public String updateMemeber(@ModelAttribute("member") MemberVO vo) {
		System.out.println(">>> 회원정보 수정");
		System.out.println("vo : " + vo);
		
		memberService.updateMember(vo);
		
		return "redirect:admin/member/getMemberList";
	}
	
	@RequestMapping("/delete_member")
	public String deleteMember(MemberVO vo, SessionStatus sessionStatus) {
		System.out.println(">>> 게시글 삭제");
		System.out.println("vo : " + vo);
		
		memberService.deleteMember(vo);
		sessionStatus.setComplete();
		
		return "redirect:admin/member/getMemberList";
	}
	
}
