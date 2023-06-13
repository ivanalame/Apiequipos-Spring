package net.azarquiel.infoliguero.repository;

import org.springframework.data.repository.CrudRepository;

import net.azarquiel.infoliguero.model.Pregunta;
import net.azarquiel.infoliguero.model.Preguntap;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
public interface PreguntapRepository extends CrudRepository<Preguntap, Integer>{
}


