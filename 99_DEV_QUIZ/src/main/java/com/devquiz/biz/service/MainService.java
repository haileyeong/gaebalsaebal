package com.devquiz.biz.service;

import java.util.List;
import java.util.Map;



import com.devquiz.biz.model.CategoryVO;

public interface MainService {

	void insertCate(Map<String, Object> paramMap);
	void getCate(CategoryVO vo);
	List<CategoryVO> getCateList(CategoryVO vo);
	
}
