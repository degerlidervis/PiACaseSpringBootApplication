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
import lombok.Data;

@Data
@Entity
@Table(name="WRITER")
@Cache( usage = CacheConcurrencyStrategy.READ_WRITE)
public class Writer{
	 

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "writer_seq_gen", sequenceName = "writer_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "WRITERID")
	private Long writerId;
	
	@Column(name = "NAME")
	private String writerName;
	
	@Column(name = "MIDDLENAME")	
	private String writerMiddleName;
	
	@Column(name = "SURNAME")
	private String writerSurname;
	
	@Column(name="STATUS")
	private String status;
	
	@ManyToMany
	private List<Writer> writers;
	

 
}
