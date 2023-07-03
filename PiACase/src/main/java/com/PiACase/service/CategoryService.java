package com.PiACase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.PiACase.dto.CategoryDTO;
import com.PiACase.entity.Category;


public interface CategoryService{
	
	List<Category> getAllCategories();
	
	Page<Category> getAllCategoriesPageable(Integer page, Integer pageSize);
	
	Category saveCategory(CategoryDTO catDto);
	
	Category updateCategory(CategoryDTO catDto);
	
	boolean deleteCategory(Long catId);
	
	Optional<Category> getCategoryByCategoryId(Long catId);

}
