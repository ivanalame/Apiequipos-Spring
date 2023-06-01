package net.azarquiel.infoliguero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.azarquiel.infoliguero.model.Jugador;
import net.azarquiel.infoliguero.model.Jugadorit;
import net.azarquiel.infoliguero.model.Jugadorp;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
@Repository
public interface JugadoritRepository extends CrudRepository<Jugadorit, Integer>{
	 List<Jugadorit> findByEquipoId(int id_equipo); 
}
