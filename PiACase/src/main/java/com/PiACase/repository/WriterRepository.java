package com.PiACase.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PiACase.dto.WriterDTO;
import com.PiACase.entity.Writer;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long>{

}
