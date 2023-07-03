package com.PiACase.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class BookDTO {

	private Long bookId;
	private String name;
	private BigDecimal price;
	private List<WriterDTO> writerList;
	private List<CategoryDTO> categoryList;

	public static String BOOK_VALID = "1";

}
