package net.azarquiel.infoliguero.repository;

import org.springframework.data.repository.CrudRepository;
import net.azarquiel.infoliguero.model.Equipo;
import net.azarquiel.infoliguero.model.Equipobu;
import net.azarquiel.infoliguero.model.Equipofr;
import net.azarquiel.infoliguero.model.Equipoit;
import net.azarquiel.infoliguero.model.Equipop;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
public interface EquipofrRepository extends CrudRepository<Equipofr, Integer>{
}


