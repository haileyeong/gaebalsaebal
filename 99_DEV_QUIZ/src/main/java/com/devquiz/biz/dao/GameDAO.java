package com.devquiz.biz.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devquiz.biz.model.GameVO;

@Repository
public class GameDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertGame(GameVO vo) {
		System.out.println("===> MyBatis - insertGame() 실행");
		mybatis.insert("game.insertGame", vo);
	}
	
}
