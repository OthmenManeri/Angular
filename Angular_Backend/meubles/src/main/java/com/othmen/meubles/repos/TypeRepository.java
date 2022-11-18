package com.othmen.animals.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.othmen.animals.entities.type;

@RepositoryRestResource(path = "type")
@CrossOrigin(origins = "http://localhost:4200/")
@Repository
public interface typeRepository extends JpaRepository<type, Long>{

}