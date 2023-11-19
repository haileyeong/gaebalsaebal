package com.devquiz.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devquiz.biz.model.ProductVO;

@Repository
public class ProductDAO {

	// @Autowired
	private SqlSessionTemplate mybatis;

	public ProductDAO() {
		System.out.println(">>> ProductDAO() 객체 생성");
	}

	@Autowired
	public ProductDAO(SqlSessionTemplate mybatis) {
		System.out.println(">>> ProductDAO(SqlSessionTemplate) 객체 생성");
		this.mybatis = mybatis;
	}

	public void insertProduct(ProductVO vo) {
		System.out.println("===> MyBatis JDBC로 insertProduct() 실행");
		mybatis.insert("ProductVO.insertProduct", vo);
	}

	public void updateProduct(ProductVO vo) {
		System.out.println("===> MyBatis JDBC로 updateProduct() 실행");
		mybatis.update("ProductVO.updateProduct", vo);
	}

	public void deleteProduct(ProductVO vo) {
		System.out.println("===> MyBatis JDBC로 deleteProduct() 실행");
		mybatis.delete("ProductVO.deleteProduct", vo);
	}

	public ProductVO getProduct(ProductVO vo) {
		System.out.println("===> MyBatis JDBC로 getProduct() 실행");
		return mybatis.selectOne("ProductVO.getProduct", vo);
	}

	public List<ProductVO> getProductList() {
		System.out.println("===> MyBatis JDBC로 getProductList() 실행");
		return null;
	}

	public List<ProductVO> getProductList(ProductVO vo) {
		System.out.println("===> MyBatis JDBC로 getProductList() 실행");

		if (vo.getProductsearchKeyword() == null) {
			vo.setProductsearchKeyword("");
		}
		String sql = "productDAO.getProductList_N";

		return mybatis.selectList(sql, vo.getProductsearchKeyword());
	}
}
