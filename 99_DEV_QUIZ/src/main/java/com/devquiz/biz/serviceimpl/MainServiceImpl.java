package com.devquiz.biz.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devquiz.biz.dao.MainDAO;
import com.devquiz.biz.model.CategoryVO;
import com.devquiz.biz.service.MainService;


@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainDAO mainDAO;

	@Override
	public void insertCate(Map<String, Object> paramMap) {
		System.out.println("마이바티스로 isertCate 실행");
		mainDAO.insertCate(paramMap);
		
	}

	@Override
	public void getCate(CategoryVO vo) {	}

	@Override
	public List<CategoryVO> getCateList(CategoryVO vo) {
		return mainDAO.getCateList(vo);
	}


}
