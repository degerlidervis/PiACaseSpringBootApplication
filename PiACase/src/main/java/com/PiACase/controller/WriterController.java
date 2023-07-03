package com.PiACase.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.PiACase.dto.WriterDTO;
import com.PiACase.dto.WriterDTOMapper;
import com.PiACase.entity.Writer;
import com.PiACase.service.WriterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/writerapi")
@RequiredArgsConstructor
public class WriterController {
	
	private final WriterService writerService;
	private final WriterDTOMapper writerDtoMapper;

	@GetMapping("/ 	")
	public ResponseEntity<List<WriterDTO>> getAllWriters(){
		List<Writer> writerEntities = writerService.getAllWriters();
		List<WriterDTO> writerDtos = writerEntities.stream().map(writer -> writerDtoMapper.convertToDTO(writer)).collect(Collectors.toList());
		return new ResponseEntity<>((List<WriterDTO>) writerDtos, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<WriterDTO> saveWriter(@RequestBody WriterDTO writerDto){
		Writer writerEntity = writerService.saveWriter(writerDto);
		WriterDTO writerDtos = writerDtoMapper.convertToDTO(writerEntity);
		return new ResponseEntity<>(writerDtos, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<WriterDTO> updateWriter(@RequestBody WriterDTO writerDto){
		Writer writerEntity = writerService.saveWriter(writerDto);
		WriterDTO writerDtos = writerDtoMapper.convertToDTO(writerEntity);
		return new ResponseEntity<>(writerDtos, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteWriter(@RequestBody Long writerId){
		if (writerService.deleteWriter(writerId)) {
            return ResponseEntity.ok("Resource deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
        } 
	}

	@GetMapping("/{writerId}")
	public ResponseEntity<WriterDTO> getWriterByWriterId(@PathVariable Long writerId){
		Optional<Writer> writerOptional = writerService.getWriterByWriterId(writerId);
		WriterDTO writerDTO = writerDtoMapper.convertToDTO(writerOptional.get());
		return new ResponseEntity<>(writerDTO, HttpStatus.OK);
	}

}
