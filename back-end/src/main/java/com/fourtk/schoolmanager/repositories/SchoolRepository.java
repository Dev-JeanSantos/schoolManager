package com.fourtk.schoolmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourtk.schoolmanager.entities.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
