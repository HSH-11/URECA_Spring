package com.mycom.myapp.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.product.dto.ProductDto;
import com.mycom.myapp.product.dto.ProductParamDto;

@Mapper
public interface ProductDao {
	// 휴대폰 목록
	 List<ProductDto> getProductList(ProductParamDto paramDto);
	 int getProductListTotalCount();
	 
	 // 검색
	 List<ProductDto> searchProducts(ProductParamDto paramDto);
	 int searchProductsCount(ProductParamDto paramDto);
}
