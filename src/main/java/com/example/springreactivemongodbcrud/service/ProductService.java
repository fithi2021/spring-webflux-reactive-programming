package com.example.springreactivemongodbcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.example.springreactivemongodbcrud.dto.ProductDto;
import com.example.springreactivemongodbcrud.repo.ProductRepo;
import com.example.springreactivemongodbcrud.utiles.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	public Flux<ProductDto> getProducts(){
		
	return	productRepo.findAll().map(AppUtils::entityToDto);
		
		
	}
	
	public Mono<ProductDto> getproduct(String id){
		
		return productRepo.findById(id).map(AppUtils::entityToDto);
	}
	
	public Flux<ProductDto> getProductInRange(double min, double max){
		
		return productRepo.findBypriceBetween(Range.closed(min,max));
	}
	
	
	public Mono<ProductDto> saveProduct(Mono<ProductDto> productMonoDto){
		return productMonoDto.map(AppUtils::dtoToEntity)
					.flatMap(productRepo::insert)
					.map(AppUtils::entityToDto);
		
		
	}
	
	/*
	 * public Mono<ProductDto> updateProduct(Mono<ProductDto> productMonoDto,String
	 * id){
	 * 
	 * productRepo.findById(id) .flatMap(AppUtils::dtoToEntity) .map()
	 * 
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
	
	
	
	

}
