package com.PiACase.entity;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORY")
@Cache( usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category{
	
	@Id
	@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq" , initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name= "CATEGORYID", nullable = true)
	private Long categoryId;
	
	@Column(name="CATEGORYNAME", length = 25)
	@Size(min = 1, max = 25 )
	@NotNull(message = "Kategori ismi boş geçilemez")
	private String categoryName;
	
	@Column(name="STATUS", length = 1)
	@Size(min = 0, max = 1, message = "Kategori için statü seçeneği 1 ya da sıfır olmalıdır." )
	private String status;
	 
	
	@ManyToMany(mappedBy = "categories")
	private List<Book> books;
}
