package com.devquiz.biz.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devquiz.biz.model.CategoryVO;

@Repository
public class MainDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertCate(Map<String, Object> map) {
		System.out.println("===> MyBatis - insertCate() 실행");
		mybatis.insert("cate.insertCate", map);
	}
	
	public List<CategoryVO> getCateList(CategoryVO vo) {
		return mybatis.selectList("main.getGameCate", vo);
	}
	
}
