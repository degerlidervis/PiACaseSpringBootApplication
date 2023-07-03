package com.PiACase.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.PiACase.dto.CategoryDTO;
import com.PiACase.dto.CategoryDTOMapper;
import com.PiACase.entity.Category;
import com.PiACase.repository.CategoryRepository;
import com.PiACase.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final CategoryDTOMapper mapperComponent;

	@Override
	@Cacheable("categories")
	public List<Category> getAllCategories() { 
		List<Category> list = categoryRepository.findAll();
		return list;
	}
	
	@Override
	@Cacheable("categories")
	public Page<Category> getAllCategoriesPageable(Integer page, Integer pageSize) { 
		Pageable pageable = PageRequest.of(page, pageSize);
		return categoryRepository.findAll(pageable);
		
	}

	@Override
	public Category saveCategory(CategoryDTO catDto) {
		Category catEntity = mapperComponent.convertToEntity(catDto);
		return categoryRepository.save(catEntity);
	}

	@Override
	public Category updateCategory(CategoryDTO catDto) {
		Category catEntity = mapperComponent.convertToEntity(catDto);
		return categoryRepository.save(catEntity);
	}

	@Override
	public boolean deleteCategory(Long catId) {
		Optional<Category> optionalCat = categoryRepository.findById(catId);

		if (optionalCat.isPresent()) {
			categoryRepository.deleteById(catId);
			return true;
		}
		return false;
	}

	@Override
	public Optional<Category> getCategoryByCategoryId(Long catId) {
		return categoryRepository.findById(catId);
		 
	}

}
