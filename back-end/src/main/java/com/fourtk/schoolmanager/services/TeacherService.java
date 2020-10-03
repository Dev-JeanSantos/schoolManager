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

import com.fourtk.schoolmanager.dto.TeacherDTO;
import com.fourtk.schoolmanager.entities.Teacher;
import com.fourtk.schoolmanager.repositories.TeacherRepository;
import com.fourtk.schoolmanager.services.exceptions.DataBaseException;
import com.fourtk.schoolmanager.services.exceptions.ResourcesNotFoundException;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repository;
	
	@Transactional(readOnly = true )
	public Page<TeacherDTO> findAllPager(PageRequest pageRequest){		
		Page<Teacher> list= repository.findAll(pageRequest);
		return list.map(x -> new TeacherDTO(x));
	}
	
	@Transactional(readOnly = true ) 
	public TeacherDTO findById(Long id) {
		
		Optional<Teacher> obj = repository.findById(id);
		Teacher entidade = obj.orElseThrow(() -> new ResourcesNotFoundException("Entity not found"));
		return new TeacherDTO(entidade);		
	}
	
	@Transactional
	public TeacherDTO insert(TeacherDTO dto) {
		
		Teacher entity = new Teacher();
		copyTDOtoEntity(dto, entity);
		entity = repository.save(entity);
		
		return new TeacherDTO(entity);
		
	}
	
	@Transactional
	public TeacherDTO update(Long id, TeacherDTO dto) {
		
		try {
			Teacher entity = repository.getOne(id);
			copyTDOtoEntity(dto, entity);
			entity = repository.save(entity);
			return new TeacherDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourcesNotFoundException("ID not found: " + id);
		}
	}
	
	private void copyTDOtoEntity(TeacherDTO dto, Teacher entity) {
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setDateOfBirth(dto.getDateOfBirth());
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
