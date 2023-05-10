package net.azarquiel.infoliguero.repository;

import org.springframework.data.repository.CrudRepository;

import net.azarquiel.infoliguero.model.Pregunta;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
public interface PreguntaRepository extends CrudRepository<Pregunta, Integer>{
}


