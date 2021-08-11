package com.shoponline.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoponline.entities.Category;
import com.shoponline.service.impl.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping()
	public List<Category> getAll() {

		return categoryService.findAll();
	}

}
