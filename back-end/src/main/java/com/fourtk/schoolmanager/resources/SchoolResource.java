package com.fourtk.schoolmanager.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourtk.schoolmanager.dto.SchoolDTO;
import com.fourtk.schoolmanager.services.SchoolService;

@RestController
@RequestMapping(value = "/schools")
public class SchoolResource {
	
	@Autowired
	private SchoolService service;	
	
	@GetMapping
	public ResponseEntity<List<SchoolDTO>> findAll(){
		List<SchoolDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}	
	
}
