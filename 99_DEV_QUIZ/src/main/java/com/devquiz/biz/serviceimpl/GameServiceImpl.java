package com.devquiz.biz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devquiz.biz.dao.GameDAO;
import com.devquiz.biz.model.GameVO;
import com.devquiz.biz.service.GameService;

@Service("gameService")
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameDAO gameDAO;

	@Override
	public void insertGame(GameVO vo) {
		gameDAO.insertGame(vo);
	}

}
