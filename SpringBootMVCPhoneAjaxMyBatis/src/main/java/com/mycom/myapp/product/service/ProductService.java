package com.mycom.myapp.product.service;

import com.mycom.myapp.product.dto.ProductDto;
import com.mycom.myapp.product.dto.ProductParamDto;
import com.mycom.myapp.product.dto.ProductResultDto;

public interface ProductService {
	ProductResultDto getAllProducts(ProductParamDto paramDto);
    ProductResultDto searchProducts(ProductParamDto paramDto);
    ProductDto getProductById(int productId);
    void updateProduct(ProductDto productDto);
}
