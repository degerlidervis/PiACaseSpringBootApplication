package com.PiACase.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.PiACase.entity.Writer;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WriterDTOMapper {

	private final ModelMapper modelMapper;

	public WriterDTOMapper() {
		this.modelMapper = new ModelMapper();
	}

	public Writer convertToEntity(WriterDTO writerDTO) {
		return modelMapper.map(writerDTO, Writer.class);
	}

	public WriterDTO convertToDTO(Writer writerEntity) {
		return modelMapper.map(writerEntity, WriterDTO.class);
	}

}
