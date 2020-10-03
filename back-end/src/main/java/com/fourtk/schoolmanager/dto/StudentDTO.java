package com.fourtk.schoolmanager.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fourtk.schoolmanager.entities.Student;
import com.fourtk.schoolmanager.entities.enums.Genre;

public class StudentDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private String nameFather;
	private String nameMother;
	private Instant dateOfBirth;
	private String address;
	private String contact;
	private String imgUrl;
	
	private Genre genre;
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(Long id, String name, String cpf, String nameFather, String nameMother, Instant dateOfBirth,
			String address, String contact, String imgUrl, Genre genre) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.nameFather = nameFather;
		this.nameMother = nameMother;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contact = contact;
		this.imgUrl = imgUrl;
		this.genre = genre;
	}



	public StudentDTO(Student entity) {
		
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.nameFather = entity.getNameFather();
		this.nameMother = entity.getNameMother();
		this.dateOfBirth = entity.getDateOfBirth();
		this.address = entity.getAddress();
		this.contact = entity.getContact();
		this.imgUrl = entity.getImgUrl();
		this.genre = entity.getGenre();
		
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNameFather() {
		return nameFather;
	}

	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
	}

	public String getNameMother() {
		return nameMother;
	}

	public void setNameMother(String nameMother) {
		this.nameMother = nameMother;
	}

	public Instant getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
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
		StudentDTO other = (StudentDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
