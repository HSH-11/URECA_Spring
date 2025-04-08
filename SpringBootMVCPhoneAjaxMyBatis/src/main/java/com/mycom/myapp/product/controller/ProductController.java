package com.mycom.myapp.product.controller;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	    if (paramDto.getLimit() == null) paramDto.setLimit(10);
	    if (paramDto.getOffset() == null) paramDto.setOffset(0);
	    if (paramDto.getSearchWord() == null) paramDto.setSearchWord("");
	    
	    System.out.println(paramDto.getSearchWord());

	    return Strings.isEmpty(paramDto.getSearchWord())
	            ? productService.getAllProducts(paramDto)
	            : productService.searchProducts(paramDto);
	}
}
