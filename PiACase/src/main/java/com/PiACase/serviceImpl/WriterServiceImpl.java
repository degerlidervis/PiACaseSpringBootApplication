package com.PiACase.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.PiACase.dto.WriterDTO;
import com.PiACase.dto.WriterDTOMapper;
import com.PiACase.entity.Writer;
import com.PiACase.repository.WriterRepository;
import com.PiACase.service.WriterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WriterServiceImpl implements WriterService{
	
	private final WriterRepository writerRepo;
	private final WriterDTOMapper mapperComponent;
	

	@Override
	@Cacheable("writers")
	public List<Writer> getAllWriters(){
		List<Writer> writerList = writerRepo.findAll();
		return writerList;
	}

	@Override
	public Writer saveWriter(WriterDTO writerDto){
		Writer writer = mapperComponent.convertToEntity(writerDto);
		return writerRepo.save(writer);
	}

	@Override
	public Writer updateWriter(WriterDTO writerDto){
		Writer writer = writerRepo.save(mapperComponent.convertToEntity(writerDto));
		return writer;
	}

	@Override
	public boolean deleteWriter(Long writerId){
		Optional<Writer> writer = writerRepo.findById(writerId); 
		if (writer.isPresent()) {
			writerRepo.deleteById(writerId);
			return true;
		}
		return false;
	}

	@Override
	public Optional<Writer> getWriterByWriterId(Long writerId){
		return writerRepo.findById(writerId);
	}
}
