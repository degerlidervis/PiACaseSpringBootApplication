package com.PiACase.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.PiACase.entity.Book;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookDTOMapper {

	private final ModelMapper modelMapper;

	public BookDTOMapper() {
		this.modelMapper = new ModelMapper();
	}

	public Book convertToEntity(BookDTO bookDTO) {
		return modelMapper.map(bookDTO, Book.class);
	}

	public BookDTO convertToDTO(Book book) {
		return modelMapper.map(book, BookDTO.class);
	}

}
