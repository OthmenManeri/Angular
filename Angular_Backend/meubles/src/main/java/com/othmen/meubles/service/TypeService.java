package com.othmen.animals.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.othmen.animals.entities.type;


public interface typeService {

    List <type> findAll();
    List<type> getAlltypes();
    Page<type> getAlltypesParPage(int page, int size);
    type savetype(type g);
    type updatetype(type g);
    void deletetype(type g);
     void deletetypeById(Long id);
     type gettype (Long idtype);

}