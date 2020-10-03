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

import com.fourtk.schoolmanager.dto.ClassroomDTO;
import com.fourtk.schoolmanager.entities.Classroom;
import com.fourtk.schoolmanager.repositories.ClassroomRepository;
import com.fourtk.schoolmanager.services.exceptions.DataBaseException;
import com.fourtk.schoolmanager.services.exceptions.ResourcesNotFoundException;

@Service
public class ClassroomService {
	
	@Autowired
	private ClassroomRepository repository;
	
	@Transactional(readOnly = true )
	public Page<ClassroomDTO> findAllPager(PageRequest pageRequest){		
		Page<Classroom> list= repository.findAll(pageRequest);
		return list.map(x -> new ClassroomDTO(x));
	}
	
	@Transactional(readOnly = true ) 
	public ClassroomDTO findById(Long id) {
		
		Optional<Classroom> obj = repository.findById(id);
		Classroom entidade = obj.orElseThrow(() -> new ResourcesNotFoundException("Entity not found"));
		return new ClassroomDTO(entidade);		
	}
	
	@Transactional
	public ClassroomDTO insert(ClassroomDTO dto) {
		
		Classroom entity = new Classroom();
		copyTDOtoEntity(dto, entity);
		entity = repository.save(entity);
		
		return new ClassroomDTO(entity);
		
	}
	
	@Transactional
	public ClassroomDTO update(Long id, ClassroomDTO dto) {
		
		try {
			Classroom entity = repository.getOne(id);
			copyTDOtoEntity(dto, entity);
			entity = repository.save(entity);
			return new ClassroomDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourcesNotFoundException("ID not found: " + id);
		}
	}
	
	private void copyTDOtoEntity(ClassroomDTO dto, Classroom entity) {
		
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
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
