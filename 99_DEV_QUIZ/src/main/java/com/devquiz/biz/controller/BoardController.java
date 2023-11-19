package com.devquiz.biz.controller;

import java.io.IOException;
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

import com.devquiz.biz.service.BoardService;
import com.devquiz.biz.model.BoardVO;

@Controller
@SessionAttributes("board")
//@RequestMapping("/board")
//-to. 예림씨 / 예림씨~왜인지 Requestmapping을 하면 페이지간 이동이 안되어서 우선 주석처리 합니다..!! //하영
public class BoardController {
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("===========> BoardController() 객체 생성");
	}
	
	@Autowired
	public BoardController(BoardService boardService) {
		System.out.println("===========> BoardController(boardService) 객체 생성");
		System.out.println("::: BoardService boardService : " + boardService);
		this.boardService = boardService;
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("====> Map searchConditionMap() 실행");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	@RequestMapping("/get_board")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("vo : " + vo);

		BoardVO board = boardService.getBoard(vo);
		String nickname = boardService.getWriter(vo);
		String category = boardService.getCategory(vo);
		System.out.println("board : " + board);
		System.out.println("nickname : " + nickname);
		System.out.println("category : " + category);
		
		model.addAttribute("board", board); 
		model.addAttribute("nickname", nickname);
		model.addAttribute("category", category);
		
		return "admin/board/getBoard";
	}
	
	@RequestMapping("/get_notice_board")
	public String getNoticeBoard(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("vo : " + vo);

		BoardVO board = boardService.getBoard(vo);
		System.out.println("board : " + board);
		
		model.addAttribute("board", board); 
		
		return "admin/board/getNoticeBoard";
	}
	
	@RequestMapping("/get_board_list")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		String nickname = boardService.getWriter(vo);
		
		model.addAttribute("nickname", nickname);
		
		model.addAttribute("boardList", boardList); 
		
		return "admin/board/getBoardList";
	}
	
	@RequestMapping("/get_notice_board_list")
	public String getNoticeBoardList(BoardVO vo, Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
		List<BoardVO> NoticeboardList = boardService.getNoticeBoardList(vo);
		
		model.addAttribute("NoticeboardList", NoticeboardList); 
		
		return "admin/board/getNoticeBoardList";
	}
	
	@RequestMapping("/insert_board_view")
	public String insertBoardView() {
		return "admin/board/insertBoard";
	}
	
	@RequestMapping("/insert_board")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : " + vo);
		
		boardService.insertBoard(vo);
		
		return "redirect:admin/board/getNoticeBoardList";
	}
	
	@RequestMapping("/update_board")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println(">>> 게시글 수정");
		System.out.println("vo : " + vo);
		
		boardService.updateBoard(vo);
		
		return "redirect:admin/board/getNoticeBoardList";
	}
	
	@RequestMapping("/delete_board")
	public String deleteBoard(BoardVO vo, SessionStatus sessionStatus) {
		System.out.println(">>> 게시글 삭제");
		System.out.println("vo : " + vo);
		
		boardService.deleteBoard(vo);
		sessionStatus.setComplete();
		
		return "redirect:admin/board/getBoardList";
	}
	
	@RequestMapping("/delete_notice_board")
	public String deleteNoticeBoard(BoardVO vo, SessionStatus sessionStatus) {
		System.out.println(">>> 게시글 삭제");
		System.out.println("vo : " + vo);
		
		boardService.deleteBoard(vo);
		sessionStatus.setComplete();
		
		return "redirect:admin/board/getNoticeBoardList";
	}
	
}
