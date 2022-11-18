package com.othmen.Animals;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.othmen.animals.entities.type;
import com.othmen.animals.entities.animal;
import com.othmen.animals.repos.AnimalRepository;
import com.othmen.animals.service.AnimalService;
@SpringBootTest
class AnimalsApplicationTests {
@Autowired
private AnimalRepository AnimalRepository;

@Autowired
private AnimalService AnimalService;

@Test
public void testCreateAnimal() {
animal Anim = new animal("Tiger",new Date());
AnimalRepository.save(Anim);
}
@Test
public void testFindAnimal()
{
animal a = AnimalRepository.findById(1L).get(); 
System.out.println(a);
}
@Test
public void testUpdateAnimal()
{
animal p = AnimalRepository.findById(1L).get();
p.setNomAnimal("lion");
AnimalRepository.save(p);
}
@Test
public void testDeleteAnimal()
{
	AnimalRepository.deleteById(1L);;
}
 
@Test
public void testListerTousAnimals()
{
List<animal> anims = AnimalRepository.findAll();
for (animal a : anims)
{
System.out.println(a);
}
}
@Test
public void testFindByNomAnimalContains()
{
Page<animal> anims = AnimalService.getAllAnimalsParPage(0,2);
System.out.println(anims.getSize());
System.out.println(anims.getTotalElements());
System.out.println(anims.getTotalPages());
anims.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (animal p : prods.getContent()
{
System.out.println(p);
} */
}
@Test
public void testFindByNomAnimal()
{
List<animal> anims = AnimalRepository.findByNomAnimal("Tiger");
for (animal a : anims)
{
System.out.println(a);
}
}
@Test
public void findByNomAnimalContains()
{
List<animal> anims=AnimalRepository.findByNomAnimalContains("T");
for (animal a : anims)
{
System.out.println(a);
} }
/*@Test
public void testfindByNomPrix()
{
List<animal> anims = animalRepository.findByNomPrix("iphone X", 1000.0);
for (animal a : anims)
{
System.out.println(a);
}
}*/

@Test
public void testfindBytype()
{
type type = new type();
type.setIdtype(1L);
List<animal> anims = AnimalRepository.findBytype(type);
for (animal a : anims)
{
System.out.println(a);
}
}
@Test
public void findBytypeIdtype()
{
List<animal> anims = AnimalRepository.findBytypeIdtype(1L);
for (animal a : anims)
{
System.out.println(a);
}
 }
@Test
public void testfindByOrderByNomAnimalAsc()
{
List<animal> anims = AnimalRepository.findByOrderByNomAnimalAsc();
for (animal a : anims)
{
System.out.println(a);
}
}
@Test
public void testTrierAnimalsNoms()
{
List<animal> anims = AnimalRepository.trierAnimalsNoms();
for (animal a : anims)
{
System.out.println(anims);
}
}
}
