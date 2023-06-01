package net.azarquiel.infoliguero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.azarquiel.infoliguero.model.Jugador;
import net.azarquiel.infoliguero.model.Jugadorbu;
import net.azarquiel.infoliguero.model.Jugadorfr;
import net.azarquiel.infoliguero.model.Jugadorit;
import net.azarquiel.infoliguero.model.Jugadorp;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
@Repository
public interface JugadorfrRepository extends CrudRepository<Jugadorfr, Integer>{
	 List<Jugadorfr> findByEquipoId(int id_equipo); 
}
