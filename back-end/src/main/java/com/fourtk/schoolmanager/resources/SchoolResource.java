package com.fourtk.schoolmanager.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourtk.schoolmanager.entities.School;

@RestController
@RequestMapping(value = "/schools")
public class SchoolResource {
	@GetMapping
	public ResponseEntity<List<School>> findAll(){
		List<School> list = new ArrayList<>();
		list.add(new School(1L, "2654897", "Escola Municipal Padre Thomas", "Rua Visconde de Maruim, 74 Centro Tanguá-RJ ", "Email: escolapthomas@gmail.com"));
		list.add(new School(2L, "2623894", "Escola Municipal Antonio Duarte", "Rua B Lote 37 Quadra 30, 443 Pinhão Tanguá-RJ ", "Email: escolaaduarte@gmail.com"));
		list.add(new School(3L, "2344434", "Escola Municipal Manoel Novis", "Rua Mario Rios Quadra A, S/N Vila Cortes Tanguá-RJ ", "Email: escolamnovis@gmail.com"));
		list.add(new School(4L, "2656788", "Escola Municipal Fernanda Suellen", "Rua Pereira Dias, 8993 Posse dos Coutinhos Tanguá-RJ ", "Email: escolafsuellen@gmail.com"));
		
		return ResponseEntity.ok().body(list);
	
		
		
		
	}
	
	
	
}
