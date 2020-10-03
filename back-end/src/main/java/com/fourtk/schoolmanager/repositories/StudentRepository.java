package com.fourtk.schoolmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourtk.schoolmanager.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
