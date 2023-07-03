package com.PiACase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PiACase.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "SELECT * FROM BOOK b LEFT JOIN CATEGORY c ON b.CATEGORYID = c.CATEGORYID WHERE b.CATEGORYID = '1'", nativeQuery = true)
	public List<Book> getBookByCategoryId(Long catId);
	
	@Query(value = "SELECT * FROM BOOK b LEFT JOIN WRITER w ON b.CATEGORYID = w.CATEGORYID WHERE b.WRITERID = '1'", nativeQuery = true)
	public List<Book> getBookByWriterId(Long writerId);
}
