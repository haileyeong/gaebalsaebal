package com.devquiz.biz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devquiz.biz.model.ProductVO;
import com.devquiz.biz.service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;
	
	@GetMapping("/admin_product")
	public String goAdminProductPage() {
		System.out.println("상품목록");
		return "admin/product/admin_product";
	}

	@GetMapping("/admin_productwrite")
    public String goAdminProductWritePage(Model model) {
        System.out.println("상품등록");
        model.addAttribute("productVO", new ProductVO());
        return "admin/product/admin_productwrite";
    }

//    @PostMapping("/admin_productwrite")
//    public String insertProduct(@ModelAttribute ProductVO productVO) {
//        System.out.println("상품 등록 요청: " + productVO);
//        productService.insertProduct(productVO);
//        return "redirect:/admin_product";
//    }
}
