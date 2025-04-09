package com.mycom.myapp.product.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.product.dto.ProductDto;
import com.mycom.myapp.product.dto.ProductParamDto;
import com.mycom.myapp.product.dto.ProductResultDto;
import com.mycom.myapp.product.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/list")
	@ResponseBody
	public ProductResultDto listProduct(ProductParamDto paramDto) {
		
		
		if (Strings.isEmpty(paramDto.getSearchWord())) {
	        return productService.getAllProducts(paramDto);
	    } else {
	        return productService.searchProducts(paramDto);
	    }
	}
	
	@GetMapping("/detail/{productId}")
	@ResponseBody
	public ProductDto getProductDetail(@PathVariable int productId) {
	    return productService.getProductById(productId);
	}

}
