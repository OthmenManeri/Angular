package com.othmen.animals.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.othmen.animals.entities.type;
import com.othmen.animals.entities.animal;
public interface AnimalService {
animal saveAnimal(animal a);
animal updateAnimal(animal a);
void deleteAnimal(animal a);
 void deleteAnimalById(Long id);
animal getAnimal(Long id);
List<animal> getAllAnimals();
Page<animal> getAllAnimalsParPage(int page, int size);
List<animal> findByNomAnimal(String nom);
List<animal> findByNomAnimalContains(String nom);
List<animal> findBytype (type type);
List<animal> findBytypeIdtype(Long id);
List<animal> findByOrderByNomAnimalAsc();
List<animal> trierAnimalsNoms();
}