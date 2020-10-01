package com.fourtk.schoolmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourtk.schoolmanager.entities.School;
import com.fourtk.schoolmanager.repositories.SchoolRepository;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolRepository repository;
	
	public List<School> findAll(){
		
		return repository.findAll();
		
	}

}
