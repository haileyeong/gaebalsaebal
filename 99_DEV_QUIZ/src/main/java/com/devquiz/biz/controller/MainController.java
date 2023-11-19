// {이하영, } categorys, points 등 파생되는 속성을 가진 데이터 관련. // 메소드 윗쪽에 [이름]과 [admin] / [gaebal]로 구분함.

package com.devquiz.biz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devquiz.biz.service.MainService;

/*
 *  MainController에는 
 */
@Controller
public class MainController {
	
	private MainService mainService;
	
	public MainController() {
		System.out.println("@# @# @# devquizMainController() 실행도 잘됨 @# @# @#");
	}
	
	@Autowired
	public MainController(MainService mainService) {
		System.out.println("@# @# @# devquizMainController(devquizMainService) 실행도 잘됨 @# @# @#");
		this.mainService = mainService;
	}

	// ==================== [admin] ====================
	
	@GetMapping("/devquiz_main") // [이하영] [admin] :메인화면으로 이동.
	public String devquizMain() {
		System.out.println("@# @# @# devquizMainController() 실행도 잘됨 @# @# @#");
		return "devquiz_main";
	}
	
	@GetMapping("/go_cate_manage_page") // [이하영] [admin] : 카테고리를 관리 페이지로 이동.
	public String goCateManagePage() {
		System.out.println("@# @# @# 인서트메소드() 실행도 잘됨 @# @# @#");
		return "cate_insert";
	}

	
	@RequestMapping("cate_insert") // [이하영] [admin] : 카테고리 테이블에 데이터를 추가.
	public String cateInsert(@RequestParam("cateType") String cateType,
            				 @RequestParam("cateName") String cateName) {
		
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("cateType", cateType);
		paramMap.put("cateName", cateName);
		
		mainService.insertCate(paramMap);
		
		return "redirect:/devquiz_main"; // 카테고리 목록을 보여주는 페이지로 수정해야함.
	}

	
}
