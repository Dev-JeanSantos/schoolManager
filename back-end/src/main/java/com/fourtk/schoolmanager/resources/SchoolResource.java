package com.fourtk.schoolmanager.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fourtk.schoolmanager.dto.SchoolDTO;
import com.fourtk.schoolmanager.services.SchoolService;

@RestController
@RequestMapping(value = "/schools")
public class SchoolResource {
	
	@Autowired
	private SchoolService service;	
	
	@GetMapping
	public ResponseEntity<Page<SchoolDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<SchoolDTO> list = service.findAllPager(pageRequest);
		return ResponseEntity.ok().body(list);		
	}	
	
	@GetMapping(value = "{id}")
	public ResponseEntity<SchoolDTO> findById(@PathVariable Long id){
		
		SchoolDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);		
	}	
}
