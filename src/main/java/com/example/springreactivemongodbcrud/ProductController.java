package com.example.springreactivemongodbcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springreactivemongodbcrud.dto.ProductDto;
import com.example.springreactivemongodbcrud.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Flux<ProductDto> getProducts(){
	
		return productService.getProducts();
		
		
		
		
	}
	
	@GetMapping("/{id}")
	public Mono<ProductDto> getProduct(@PathVariable String id){
	
		return productService.getproduct(id);
		
		
		
	}
	@GetMapping("/product-range")
	public Flux<ProductDto> getProductInRange(@RequestParam("min") double min, @RequestParam("max") double max){
	
		return productService.getProductInRange(min, max);
			
		
	}
	
	@PostMapping
	public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDto){
		return productService.saveProduct(productDto);
		
		
	}
	
	
	

}
