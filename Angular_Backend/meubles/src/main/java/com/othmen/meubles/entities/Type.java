package com.othmen.animals.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class type {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idtype;
private String nomtype;
private String descriptiontype;
@JsonIgnore
@OneToMany(mappedBy = "type")
private List<animal> animals;
public type() {}
public type(String nomtype, String descriptiontype, List<animal> animals) 
{
super();
this.nomtype = nomtype;
this.descriptiontype = descriptiontype;
this.animals = animals;
}
public Long getIdtype() {
return idtype;
}
public void setIdtype(Long idtype) {
this.idtype = idtype;
}
public String getNomtype() {
return nomtype;
}
public void setNomtype(String nomtype) {
this.nomtype = nomtype;
}
public String getDescriptiontype() {
return descriptiontype;
}
public void setDescriptiontype(String descriptiontype) {
this.descriptiontype = descriptiontype;
}
public List<animal> getAnimals() {
return animals;
}
public void setAnimals(List<animal> animals) {
this.animals = animals;
}
@Override
public String toString() {
	return "type [idtype=" + idtype + ", nomtype=" + nomtype + ", descriptiontype=" + descriptiontype + "]";
}
}