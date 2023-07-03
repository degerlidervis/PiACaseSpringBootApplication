package com.PiACase.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "BOOK")
@Entity
public class Book{
 
	@Id
	@SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "BOOKID")
	private Long bookId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "BOOKWRITER",
            joinColumns = @JoinColumn(name = "bookId", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "writerId")
    )
    private List<Writer> writers;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "BOOKCATEGORY",
            joinColumns = { @JoinColumn(name = "bookId") }, 
            inverseJoinColumns = { @JoinColumn(name = "categoryId")} 
    )
    private List<Category> categories;
 
}
