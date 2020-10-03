package com.fourtk.schoolmanager.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fourtk.schoolmanager.dto.StudentDTO;
import com.fourtk.schoolmanager.entities.Student;
import com.fourtk.schoolmanager.repositories.StudentRepository;
import com.fourtk.schoolmanager.services.exceptions.DataBaseException;
import com.fourtk.schoolmanager.services.exceptions.ResourcesNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Transactional(readOnly = true )
	public Page<StudentDTO> findAllPager(PageRequest pageRequest){		
		Page<Student> list= repository.findAll(pageRequest);
		return list.map(x -> new StudentDTO(x));
	}
	
	@Transactional(readOnly = true ) 
	public StudentDTO findById(Long id) {
		
		Optional<Student> obj = repository.findById(id);
		Student entidade = obj.orElseThrow(() -> new ResourcesNotFoundException("Entity not found"));
		return new StudentDTO(entidade);		
	}
	
	@Transactional
	public StudentDTO insert(StudentDTO dto) {
		
		Student entity = new Student();
		copyTDOtoEntity(dto, entity);
		entity = repository.save(entity);
		
		return new StudentDTO(entity);
		
	}
	
	@Transactional
	public StudentDTO update(Long id, StudentDTO dto) {
		
		try {
			Student entity = repository.getOne(id);
			copyTDOtoEntity(dto, entity);
			entity = repository.save(entity);
			return new StudentDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourcesNotFoundException("ID not found: " + id);
		}
	}
	
	private void copyTDOtoEntity(StudentDTO dto, Student entity) {
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setNameFather(dto.getNameFather());
		entity.setNameMother(dto.getNameMother());
		entity.setAddress(dto.getAddress());
		entity.setContact(dto.getContact());
		entity.setImgUrl(dto.getImgUrl());
		entity.setGenre(dto.getGenre());
	}

	public void delete(Long id) {
		
		try {
			
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourcesNotFoundException("ID not found " + id); 
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation "); 
		}
		
		
	}
	
}
