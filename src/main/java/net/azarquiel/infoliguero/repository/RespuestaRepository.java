package net.azarquiel.infoliguero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.azarquiel.infoliguero.model.Jugador;
import net.azarquiel.infoliguero.model.Respuesta;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
@Repository
public interface RespuestaRepository extends CrudRepository<Respuesta, Integer>{
	 List<Respuesta> findByPreguntaId(int id_pregunta); 
}
