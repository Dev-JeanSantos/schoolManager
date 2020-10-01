package com.fourtk.schoolmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fourtk.schoolmanager.dto.SchoolDTO;
import com.fourtk.schoolmanager.entities.School;
import com.fourtk.schoolmanager.repositories.SchoolRepository;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolRepository repository;
	
	@Transactional(readOnly = true )
	public List<SchoolDTO> findAll(){
		
		List<School> list= repository.findAll();
		return list.stream().map(x -> new SchoolDTO(x)).collect(Collectors.toList());
	}

}
