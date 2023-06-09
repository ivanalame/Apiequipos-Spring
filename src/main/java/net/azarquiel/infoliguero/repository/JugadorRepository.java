package net.azarquiel.infoliguero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.azarquiel.infoliguero.model.Jugador;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Integer>{
	 List<Jugador> findByEquipoId(int id_equipo); 
}
