package net.azarquiel.infoliguero.repository;

import org.springframework.data.repository.CrudRepository;
import net.azarquiel.infoliguero.model.Jugador;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
public interface JugadorRepository extends CrudRepository<Jugador, Integer>{
}
