package com.fourtk.schoolmanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fourtk.schoolmanager.dto.SchoolDTO;
import com.fourtk.schoolmanager.entities.School;
import com.fourtk.schoolmanager.repositories.SchoolRepository;
import com.fourtk.schoolmanager.services.exceptions.ResourcesNotFoundException;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolRepository repository;
	
	@Transactional(readOnly = true )
	public Page<SchoolDTO> findAllPager(PageRequest pageRequest){		
		Page<School> list= repository.findAll(pageRequest);
		return list.map(x -> new SchoolDTO(x));
	}
	
	@Transactional(readOnly = true ) 
	public SchoolDTO findById(Long id) {
		
		Optional<School> obj = repository.findById(id);
		School entidade = obj.orElseThrow(() -> new ResourcesNotFoundException("Entity not found"));
		return new SchoolDTO(entidade);		
	}
	
	@Transactional
	public SchoolDTO insert(SchoolDTO dto) {
		
		School entity = new School();
		copyTDOtoEntity(dto, entity);
		entity = repository.save(entity);
		
		return new SchoolDTO(entity);
		
	}

	private void copyTDOtoEntity(SchoolDTO dto, School entity) {
		
		entity.setInep(dto.getInep());
		entity.setName(dto.getName());
		entity.setAdress(dto.getAdress());
		entity.setContact(dto.getContact());
	}
	
	

}
