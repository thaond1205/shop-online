package com.shoponline.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoponline.entities.Product;
import com.shoponline.service.impl.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired       
	private ProductService productService;

	@GetMapping()
    public List<Product> getAll(){
        
        return productService.findAll();
    } 
	
	
	@GetMapping("/{id}")
    public Product getID(@PathVariable("id") Integer id){
        
        return productService.findById(id);
    } 
	
	 
	@PostMapping
    public Product create(@RequestBody Product product){
        
        return productService.create(product);
    } 

	
	@PutMapping("/{id}")
    public Product update(@PathVariable("id") String id, @RequestBody Product product){
        
        return productService.update(product);
    } 
	
	@DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){

        productService.delete(id);
    } 
	
	
}
