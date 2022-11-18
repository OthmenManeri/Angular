package com.othmen.animals.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.othmen.animals.entities.type;
import com.othmen.animals.repos.typeRepository;
import com.othmen.animals.service.typeService;

@RestController
@RequestMapping("/api/type")
@CrossOrigin("*")
public class typeRESTController {
	@Autowired
	typeRepository typeRepository;
	@Autowired
	typeService typeService;
	@RequestMapping(method = RequestMethod.GET)
	public List<type> getAlltypes() {
	return typeService.getAlltypes();
	}

	@RequestMapping(method = RequestMethod.POST)
	public type createtype(@RequestBody type type) {
	return typeService.savetype(type);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public type updatetype(@RequestBody type type) {
	return typeService.updatetype(type);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletetype(@PathVariable("id") Long id)
	{
		typeService.deletetypeById(id);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public type getCategorieById(@PathVariable("id") Long id) {
	return typeRepository.findById(id).get();
	}
}
