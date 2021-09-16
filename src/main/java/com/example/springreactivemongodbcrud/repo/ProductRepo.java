package com.example.springreactivemongodbcrud.repo;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springreactivemongodbcrud.dto.ProductDto;
import com.example.springreactivemongodbcrud.entity.Product;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepo  extends ReactiveMongoRepository<Product, String> {


	Flux<ProductDto> findBypriceBetween(Range<Double> priceRange);
	
	
	

}
