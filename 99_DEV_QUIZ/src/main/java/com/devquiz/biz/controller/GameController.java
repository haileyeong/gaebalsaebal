// {이하영} 게임 회원 페이지와 게임 관리자 페이지를 위한 컨트롤러. // 메소드 윗쪽에 [admin] 과 [gaebal]로 구분함.

package com.devquiz.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devquiz.biz.model.CategoryVO;
import com.devquiz.biz.model.GameVO;
import com.devquiz.biz.service.GameService;
import com.devquiz.biz.service.MainService;


@Controller
public class GameController {
	private GameService gameService;
	private MainService mainService;

	public GameController() {
		System.out.println("@# @# @# GameController 실행! @# @# @#");
	}
	
	@Autowired
	public GameController(GameService gameService, MainService mainService) {
		System.out.println("@# @# @# GameController(gameService)! @# @# @#");
		this.gameService = gameService;
		this.mainService = mainService; //카테고리 테이블 데이터 사용을 위해 mainService를 주입
	}
	
	// ==================== [geaebal] ====================
	
	@GetMapping("/go_game") // [gaebal] : 게임 실행 메인 화면으로 이동.
	public String goGame(CategoryVO cvo, Model model) {
		List<CategoryVO> quizCate = mainService.getCateList(cvo);
		model.addAttribute("quizCate", quizCate);
		
		return "gaebal/game/game_main";
	}
	
	
	// ==================== [admin] ====================
	
	@GetMapping("/go_game_manage_page") // [admin] : 게임 관리 화면으로 이동.
	public String goGameManage(CategoryVO cvo, Model model) {
		System.out.println("@# @# @# devquizMainController() 실행도 잘됨 @# @# @#");
	
		List<CategoryVO> cateList = mainService.getCateList(cvo);
		model.addAttribute("cate", cateList);
		
		return "admin/game/game_manage";
	}
	
	@RequestMapping("/gameInsert") // [admin] : games 테이블에 데이터 추가.
	public String gameInsert(GameVO vo) {
		gameService.insertGame(vo);
		return "devquiz_main"; //게임 목록을 보여주는 페이지로 수정해야함
	}
	
	
}
