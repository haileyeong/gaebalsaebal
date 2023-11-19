package com.devquiz.biz.service;

import java.util.List;

import com.devquiz.biz.model.ProductVO;

public interface ProductService {
	void insertProduct(ProductVO vo);
	void updateProduct(ProductVO vo);
	void deleteProduct(ProductVO vo);
	ProductVO getProduct(ProductVO vo);
	List<ProductVO> getProductList(ProductVO vo);
}
