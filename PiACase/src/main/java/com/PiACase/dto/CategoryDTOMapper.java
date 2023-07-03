package com.PiACase.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.PiACase.entity.Category;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryDTOMapper {

	private final ModelMapper modelMapper;

	public CategoryDTOMapper() {
		this.modelMapper = new ModelMapper();
	}

	public Category convertToEntity(CategoryDTO catDTO) {
		if(catDTO==null) {
			return null;
		}
		return modelMapper.map(catDTO, Category.class);
	}

	public CategoryDTO convertToDTO(Category catEntity) {
		if(catEntity==null) {
			return null;
		}
		return modelMapper.map(catEntity, CategoryDTO.class);
	}

}
