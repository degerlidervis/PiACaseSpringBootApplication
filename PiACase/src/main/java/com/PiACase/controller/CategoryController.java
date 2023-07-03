package com.PiACase.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PiACase.dto.CategoryDTO;
import com.PiACase.dto.CategoryDTOMapper;
import com.PiACase.entity.Category;
import com.PiACase.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;

	private final CategoryDTOMapper categoryDTOMapper;

	@GetMapping("/allCategories")
	ResponseEntity<List<CategoryDTO>> getAllCategoriesPageable(){
		List<Category> categoryList = categoryService.getAllCategories();
		List<CategoryDTO> dtoList = (List<CategoryDTO>) categoryList.stream()
				.map(cat -> categoryDTOMapper.convertToDTO(cat)).collect(Collectors.toList());
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/allCategoriesPageable")
	ResponseEntity<List<CategoryDTO>> getAllCategories(@RequestParam Integer page,@RequestParam Integer pageSize){
		Page<Category> categoryList = categoryService.getAllCategoriesPageable(page, pageSize);
		List<CategoryDTO> dtoList = (List<CategoryDTO>) categoryList.stream()
				.map(cat -> categoryDTOMapper.convertToDTO(cat)).collect(Collectors.toList());
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

	@PostMapping(path = "/saveCategory")
	public ResponseEntity<CategoryDTO> saveCategory(@RequestBody @Valid CategoryDTO catDto){
		Category cat = categoryService.saveCategory(catDto);
		CategoryDTO categoryDTO = categoryDTOMapper.convertToDTO(cat);
		return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);

	}

	@PutMapping("/updateCategory")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO catDto) {
		Category cat = categoryService.saveCategory(catDto);
		CategoryDTO categoryDTO = categoryDTOMapper.convertToDTO(cat);
		return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
	}

	@DeleteMapping("/{catId}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long catId){
		if (categoryService.deleteCategory(catId)) {
			return ResponseEntity.ok("Resource deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
		}
	}

	@GetMapping("/{catId}")
	ResponseEntity<CategoryDTO> getCategoryByCategoryId(@PathVariable Long catId){
		Optional<Category> categoryOptional = categoryService.getCategoryByCategoryId(catId);
		CategoryDTO dto = categoryDTOMapper.convertToDTO(categoryOptional.get());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
