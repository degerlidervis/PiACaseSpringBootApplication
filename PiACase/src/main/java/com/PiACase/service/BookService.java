package com.PiACase.service;

import java.util.List;
import java.util.Optional;

import com.PiACase.dto.BookDTO;
import com.PiACase.entity.Book;

public interface BookService {
	
	List<Book> getAllBook() throws Exception;

	Book saveBook(BookDTO bookDto) throws Exception;

	Book updateBook(BookDTO bookDto) throws Exception;

	boolean deleteBook(Long bookId) throws Exception;

	Optional<Book> getBookByCategoryId(Long catId) throws Exception;

	Optional<Book> getBookByWriterId(Long writerId) throws Exception;
}
