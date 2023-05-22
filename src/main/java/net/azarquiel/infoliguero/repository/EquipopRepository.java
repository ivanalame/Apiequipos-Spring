package net.azarquiel.infoliguero.repository;

import org.springframework.data.repository.CrudRepository;
import net.azarquiel.infoliguero.model.Equipo;
import net.azarquiel.infoliguero.model.Equipop;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
public interface EquipopRepository extends CrudRepository<Equipop, Integer>{
}


