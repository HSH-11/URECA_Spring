package com.mycom.myapp.product.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PutMapping("/update/{productId}")
    @ResponseBody
    public Map<String, String> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) {
        Map<String, String> resultMap = new HashMap<>();
        try {
            productService.updateProduct(productDto);
            resultMap.put("result", "success");
        } catch (Exception e) {
            resultMap.put("result", "fail");
        }
        return resultMap;
    }

}
