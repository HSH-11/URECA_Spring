package com.mycom.myapp.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.product.dao.ProductDao;
import com.mycom.myapp.product.dto.ProductDto;
import com.mycom.myapp.product.dto.ProductParamDto;
import com.mycom.myapp.product.dto.ProductResultDto;

@Service
public class ProductServiceImpl implements ProductService{
	private final ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public ProductResultDto getAllProducts(ProductParamDto paramDto) {
		ProductResultDto productResultDto = new ProductResultDto();
		
		try {
			List<ProductDto> list = productDao.getProductList(paramDto);
			int count = productDao.getProductListTotalCount();
			
			productResultDto.setList(list);
			productResultDto.setCount(count);
			productResultDto.setResult("success");
		}catch(Exception e) {
			e.printStackTrace();
			productResultDto.setResult("fail");
		}
		return productResultDto;
	}

	@Override
	public ProductResultDto searchProducts(ProductParamDto paramDto) {
		ProductResultDto productResultDto = new ProductResultDto();

        try {
            List<ProductDto> list = productDao.searchProducts(paramDto);
            int count = productDao.searchProductsCount(paramDto);

            productResultDto.setList(list);
            productResultDto.setCount(count);
            productResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            productResultDto.setResult("fail");
        }

        return productResultDto;
	}

	@Override
	public ProductDto getProductById(int productId) {
		return productDao.getProductById(productId);
	}
	
	
	
}
