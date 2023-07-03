package com.PiACase.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PiACase.dto.BookDTO;
import com.PiACase.dto.BookDTOMapper;
import com.PiACase.entity.Book;
import com.PiACase.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bookapi")
@RequiredArgsConstructor
public class BookController{
	
	private final BookService bookService;
	private final BookDTOMapper bookDtoMapper;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<BookDTO>> getAllBookList() throws Exception{
		List<Book> listEntity = bookService.getAllBook();
		List<BookDTO> listDtos = listEntity.stream().map(entity -> bookDtoMapper.convertToDTO(entity)).collect(Collectors.toList());
		return new ResponseEntity<>(listDtos, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO dto) throws Exception{
		Book bookEntity = bookService.saveBook(dto);
		return new ResponseEntity<>(bookDtoMapper.convertToDTO(bookEntity), HttpStatus.CREATED);
	}
	
	@PutMapping(path ="/{bookId}")
	public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO dto) throws Exception{
		Book bookEntity = bookService.saveBook(dto);
		return new ResponseEntity<>(bookDtoMapper.convertToDTO(bookEntity), HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Long bookId) throws Exception{
		if (bookService.deleteBook(bookId)) {
            return ResponseEntity.ok("Resource deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
        } 
	}
	
	@GetMapping(path="/getBookByCategoryId/{catId}")
	public ResponseEntity<BookDTO> getBookByCategoryId(@PathVariable Long catId) throws Exception{
		Optional<Book> bookEntity = bookService.getBookByCategoryId(catId);
		BookDTO dto = bookDtoMapper.convertToDTO(bookEntity.get());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(path="/getBookByWriterId/{writerId}")
	public ResponseEntity<BookDTO> getBookByWriterId(@PathVariable Long writerId) throws Exception{
		Optional<Book> bookOptionals = bookService.getBookByWriterId(writerId);
		BookDTO dto = bookDtoMapper.convertToDTO(bookOptionals.get());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
