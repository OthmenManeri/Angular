package com.othmen.animals.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.othmen.animals.entities.type;
import com.othmen.animals.entities.animal;
import com.othmen.animals.service.typeService;
import com.othmen.animals.service.AnimalService;
@Controller
public class AnimalController {
@Autowired
AnimalService animalService;
@Autowired
typeService typeService;


@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<type> types = typeService.findAll();
modelMap.addAttribute("types", types);
modelMap.addAttribute("animal", new animal());
modelMap.addAttribute("mode", "new");
return "formAnimal";
}
@RequestMapping("/saveAnimal")
public String saveAnimal(ModelMap modelMap,@Valid animal animal,
BindingResult bindingResult)
{
	List<type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
System.out.println(animal);
if (bindingResult.hasErrors()) return "formAnimal";
animalService.saveAnimal(animal);
return "redirect:/Listemeubles";
}

@RequestMapping("/showCreatetype")
public String showCreatetype(ModelMap modelMap)
{
modelMap.addAttribute("types", new type());
modelMap.addAttribute("mode", "new");
return "formtype";
}
@RequestMapping("/savetype")
public String savetype(@ModelAttribute("type") type type,ModelMap modelMap) throws ParseException 
{
type savetype = typeService.savetype(type);
return "redirect:/Listetype";
}


@RequestMapping("/Listetype")
public String Listetype(ModelMap modelMap)
{
List <type> types = typeService.findAll();
modelMap.addAttribute("types", types);
return "Listetype";
}

@RequestMapping("/Listemeubles")
public String Listemeubles(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	List<type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
Page<animal> anims = animalService.getAllAnimalsParPage(page, size);
modelMap.addAttribute("animals", anims);
 modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "Listemeubles";
}


@RequestMapping("/supprimerAnimal")
public String supprimerAnimal(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
	animalService.deleteAnimalById(id);
Page<animal> anims = animalService.getAllAnimalsParPage(page, 
size);
modelMap.addAttribute("animals", anims);
modelMap.addAttribute("pages", new int[anims.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "Listemeubles";
}
@RequestMapping("/supprimertype")
public String supprimertype(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
typeService.deletetypeById(id);
List<type> types = typeService.findAll();
modelMap.addAttribute("types", types);
return "Listetype";
}

@RequestMapping("/modifierAnimal")
public String modifierAnimal(@RequestParam("id") Long id,ModelMap modelMap)
{
animal a= animalService.getAnimal(id);
List<type> types = typeService.findAll();
types.remove(a.gettype());
modelMap.addAttribute("types", types);
modelMap.addAttribute("animal", a);
modelMap.addAttribute("mode", "edit");
return "formAnimal";
}
@RequestMapping("/updateAnimal")
public String updateAnimal(@ModelAttribute("animal") animal animal,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateAjout = dateformat.parse(String.valueOf(date));
	 animal.setDateAjout(dateAjout);
	 
	 animalService.updateAnimal(animal);
	 List<animal> anims = animalService.getAllAnimals();
	 modelMap.addAttribute("animals", anims);
	return "Listemeubles";
	}
@RequestMapping("/modifiertype")
public String editertype(@RequestParam("id") Long id,ModelMap modelMap)
{
type g= typeService.gettype(id);
modelMap.addAttribute("types", g);
modelMap.addAttribute("mode", "edit");
return "formtype";
}
@RequestMapping("/updatetype")
public String updatetype(@ModelAttribute("type") type type,ModelMap modelMap) throws ParseException {
	typeService.updatetype(type);
	 List<type> types = typeService.findAll();
	 modelMap.addAttribute("types", types);
	return "Listetype";
	}


@RequestMapping("/search")
public String recherNom(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<type> types = typeService.findAll();
	modelMap.addAttribute("types", types);
List<animal> anims =animalService.findByNomAnimal(nom);
modelMap.addAttribute("animals",anims);
modelMap.addAttribute("mode", "SearchNomP");
return "Listemeubles";
}
@RequestMapping("/searchtype")
public String rechertype(@RequestParam("type") Long type,ModelMap modelMap)
{
type types = new type();
types.setIdtype(type);
List<type> types2 = typeService.findAll();
modelMap.addAttribute("types", types2);
List<animal> anims = animalService.findBytype(types);
modelMap.addAttribute("animals",anims);
modelMap.addAttribute("mode", "Searchtype");
return "Listemeubles";
}
}