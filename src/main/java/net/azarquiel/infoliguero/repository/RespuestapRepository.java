package net.azarquiel.infoliguero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import net.azarquiel.infoliguero.model.Respuestap;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
@Repository
public interface RespuestapRepository extends CrudRepository<Respuestap, Integer>{
	 List<Respuestap> findByPreguntaId(int id_pregunta); 
}
