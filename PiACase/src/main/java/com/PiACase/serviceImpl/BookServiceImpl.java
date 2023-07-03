package com.PiACase.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.PiACase.dto.BookDTO;
import com.PiACase.dto.BookDTOMapper;
import com.PiACase.entity.Book;
import com.PiACase.repository.BookRepository;
import com.PiACase.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	private final BookDTOMapper mapperComponent;

	@Override
	public List<Book> getAllBook() throws Exception {
		List<Book> bookEntityList = bookRepository.findAll();
		return bookEntityList;
	}

	@Override
	public Book saveBook(BookDTO bookDto) throws Exception {
		Book book = mapperComponent.convertToEntity(bookDto);
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(BookDTO bookDto) throws Exception {
		Book book = mapperComponent.convertToEntity(bookDto);
		return bookRepository.save(book);
	}

	@Override
	public boolean deleteBook(Long bookId){
		Optional<Book> optionalBook = bookRepository.findById(bookId);

		if (optionalBook.isPresent()) {
			bookRepository.deleteById(bookId);
			return true;
		}
		return false;
	}

	@Override
	public Optional<Book> getBookByCategoryId(Long catId) throws Exception {
		Optional<Book> listBook = bookRepository.findById(catId);
		return listBook;
	}

	@Override
	public Optional<Book> getBookByWriterId(Long writerId) throws Exception {
		Optional<Book> listBook = bookRepository.findById(writerId);
		return listBook;
	}
}
