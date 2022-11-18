package com.othmen.animals.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.othmen.animals.entities.type;
import com.othmen.animals.repos.typeRepository;


@Service
public class typeServiceImpl implements typeService {

    @Autowired
    private typeRepository typeRepository;

    @Override
    public List <type> findAll() {
        return typeRepository.findAll();
    }

	@Override
	public type savetype(type g) {
		return typeRepository.save(g);
	}

	@Override
	public type updatetype(type g) {
		return typeRepository.save(g);
	}

	@Override
	public void deletetype(type g) {
		typeRepository.delete(g);
	}

	@Override
	public void deletetypeById(Long idtype) {
		typeRepository.deleteById(idtype);
	}

	@Override
	public type gettype(Long idtype) {
		return typeRepository.findById(idtype).get();
	}

	@Override
	public List<type> getAlltypes() {
		return typeRepository.findAll();
	}

	@Override
	public Page<type> getAlltypesParPage(int page, int size) {
		return typeRepository.findAll(PageRequest.of(page, size));
	}

   
}