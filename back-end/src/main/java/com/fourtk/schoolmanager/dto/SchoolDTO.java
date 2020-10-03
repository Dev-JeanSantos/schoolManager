package com.fourtk.schoolmanager.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fourtk.schoolmanager.entities.School;
import com.fourtk.schoolmanager.entities.Student;

public class SchoolDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String inep;
	private String name;
	private String adress;
	private String contact;
	
	
	private List<StudentDTO> students = new ArrayList<>();
	
	
	public SchoolDTO() {
		// TODO Auto-generated constructor stub
	}

	public SchoolDTO(Long id, String inep, String name, String adress, String contact) {
		this.id = id;
		this.inep = inep;
		this.name = name;
		this.adress = adress;
		this.contact = contact;
		
	}
	
	public SchoolDTO(School entity) {
		this.id = entity.getId();
		this.inep = entity.getInep();
		this.name = entity.getName();
		this.adress = entity.getAdress();
		this.contact = entity.getContact();		
	}
	
	public SchoolDTO(School entity, Set<Student> students) {
		
		this(entity);
		students.forEach(stu -> this.students.add(new StudentDTO(stu)));
		
		
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInep() {
		return inep;
	}

	public void setInep(String inep) {
		this.inep = inep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<StudentDTO> getStudents() {
		return students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolDTO other = (SchoolDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
