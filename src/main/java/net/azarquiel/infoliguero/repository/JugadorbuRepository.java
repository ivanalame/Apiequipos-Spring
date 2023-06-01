package net.azarquiel.infoliguero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.azarquiel.infoliguero.model.Jugador;
import net.azarquiel.infoliguero.model.Jugadorbu;
import net.azarquiel.infoliguero.model.Jugadorit;
import net.azarquiel.infoliguero.model.Jugadorp;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
@Repository
public interface JugadorbuRepository extends CrudRepository<Jugadorbu, Integer>{
	 List<Jugadorbu> findByEquipoId(int id_equipo); 
}
