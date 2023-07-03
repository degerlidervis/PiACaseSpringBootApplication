package com.PiACase.service;

import java.util.List;
import java.util.Optional;

import com.PiACase.dto.WriterDTO;
import com.PiACase.entity.Writer;
 
public interface WriterService {
	
	List<Writer> getAllWriters();

	Writer saveWriter(WriterDTO writerDto);

	Writer updateWriter(WriterDTO writerDto);

	boolean deleteWriter(Long writerId);

	Optional<Writer> getWriterByWriterId(Long writerId);
}
