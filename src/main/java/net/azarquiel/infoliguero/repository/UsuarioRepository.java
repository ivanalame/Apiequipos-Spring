package net.azarquiel.infoliguero.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.azarquiel.infoliguero.model.Usuario;

//con el extends CrudRepository ya podemos hacer todo los insert,delete,update...
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	 Usuario findByNickAndPass(String nick, String pass);
}

