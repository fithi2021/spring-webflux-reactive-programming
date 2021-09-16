package com.example.springreactivemongodbcrud.utiles;

import org.springframework.beans.BeanUtils;

import com.example.springreactivemongodbcrud.dto.ProductDto;
import com.example.springreactivemongodbcrud.entity.Product;

public class AppUtils {

	public static ProductDto entityToDto(Product product) {
		
		
		
		ProductDto productDto = new ProductDto();
		//BeanUtils.copyProperties(product, productDto); usi soltanto se l'entity e dto hanno gli attribuiti stessi.
		
		
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setQty(product.getQty());
		
		return productDto;
		
		
			
		
		
	}
	
	
	public static Product dtoToEntity(ProductDto productDto) {
	Product product = new Product();
	//BeanUtils.copyProperties(productDto, product); usi soltanto se l'entity e dto hanno gli attribuiti stessi.
	
	
	product.setId(productDto.getId());
	product.setName(productDto.getName());
	product.setPrice(productDto.getPrice());
	product.setQty(productDto.getQty());
	
	return product;
}
	
}
