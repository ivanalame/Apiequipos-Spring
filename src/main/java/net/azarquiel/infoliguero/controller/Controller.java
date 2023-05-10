package net.azarquiel.infoliguero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.azarquiel.infoliguero.model.Equipo;
import net.azarquiel.infoliguero.model.Jugador;
import net.azarquiel.infoliguero.model.Pregunta;
import net.azarquiel.infoliguero.model.Respuesta;
import net.azarquiel.infoliguero.model.Usuario;
import net.azarquiel.infoliguero.repository.EquipoRepository;
import net.azarquiel.infoliguero.repository.JugadorRepository;
import net.azarquiel.infoliguero.repository.PreguntaRepository;
import net.azarquiel.infoliguero.repository.RespuestaRepository;
import net.azarquiel.infoliguero.repository.UsuarioRepository;




/*al poner RestController en vez de Controller,
  ya no tenemos que poner la anotacion ResponseBody*/
@RestController
@CrossOrigin
@EnableAutoConfiguration
public class Controller {
    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;
    private final UsuarioRepository usuarioRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;
    
    @Autowired
    public Controller(EquipoRepository equipoRepository, JugadorRepository jugadorRepository,
			UsuarioRepository usuarioRepository, PreguntaRepository preguntaRepository,
			RespuestaRepository respuestaRepository) {
		super();
		this.equipoRepository = equipoRepository;
		this.jugadorRepository = jugadorRepository;
		this.usuarioRepository = usuarioRepository;
		this.preguntaRepository = preguntaRepository;
		this.respuestaRepository = respuestaRepository;
	}
    

	// Welcome de nuestra api por ejemplo podríamos poner aquí
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String get() {
   	 String cadena = "<h1 style='text-align: center; background-color: #0000c0; color: #C0C0FF;'>Welcome to Infoliguero Api with SpringBoot - IvanJuarez</h1>";
   	 cadena +="<table border='1' style='width: 40%;margin: 0 auto; background-color: #C0C0FF; color:#0000c0;'>";
   	 cadena +="<tr style='background-color: #0000c0; color: #C0C0FF;'><th>Method</th><th>Url</th><th>Description</th></tr>";
   	 cadena +="<tr><td>get </td><td>/equipos</td><td>Lista de equipos</td></tr>";
   	 cadena +="<tr><td>get </td><td>/equipo/{id}</td><td>Equipo</td></tr>";
   	 cadena +="<tr><td>post </td><td>/equipo</td><td>Inserta un equipo</td></tr>";
   	 cadena +="<tr><td>get </td><td>/jugador/{id_equipo}</td><td>sacar lista  de jugadores por id de equipo</td></tr>";
   	 cadena +="<tr><td>get </td><td>/usuario</td><td>sacar usuario by nick and pass</td></tr>";
   	 cadena +="<tr><td>get </td><td>/pregunta/{id}</td><td>sacar pregunta by id</td></tr>";
   	 cadena +="<tr><td>get </td><td>/respuesta/{id_pregunta}</td><td>sacar respuestas by id_pregunta</td></tr>";
    	cadena +="</table>";
   	 return cadena;
    }

    

	// Get lista con todos los equipos
    @RequestMapping(value = "equipos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipos() {
   	 try {
   		 Iterable<Equipo> equipos = equipoRepository.findAll();
   		 return new ResponseEntity<>(equipos, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }

    // Get un equipo indicando el numero de equipo en la url
    @RequestMapping(value = "equipo/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipoAndPlayersById(@PathVariable(value = "id") int id) {
   	 try {
   	  // Find the team with the given ID
         Equipo equipoResponse = equipoRepository.findById(id).orElse(null);

   		 return new ResponseEntity<>(equipoResponse, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
   
    // Get lista jugadores indicando el numero de equipo en la url
    
    @RequestMapping(value = "jugador/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Jugador>> getJugadoresByIdequipo(@PathVariable(value = "id") int id_equipo) {
        try {
            // Find all players that are associated with the given team ID
        	System.out.println(id_equipo);
            List<Jugador> jugadores = jugadorRepository.findByEquipoId(id_equipo);

            return new ResponseEntity<>(jugadores, HttpStatus.OK);

        } catch (Exception ex) {
        	
        	
        	ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
// Get lista respuestas indicando el numero de pregunta en la url
    
    @RequestMapping(value = "respuesta/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Respuesta>> getRespuestasByIdpregunta(@PathVariable(value = "id") int id_pregunta) {
        try {
            // Find all players that are associated with the given team ID
        	System.out.println(id_pregunta);
            List<Respuesta> respuestas = respuestaRepository.findByPreguntaId(id_pregunta);

            return new ResponseEntity<>(respuestas, HttpStatus.OK);

        } catch (Exception ex) {
        	
        	
        	ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
  // Get usuario by nick and pass 
    @RequestMapping(value = "usuario", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsuarioByNickAndPass(
        @RequestParam(value = "nick") String nick,
        @RequestParam(value = "pass") String pass) {
        try {
            // Find the user with the given nick and pass
            Usuario usuarioResponse = usuarioRepository.findByNickAndPass(nick, pass);

            return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
    
    // Get una pregunta indicando el numero de pregunta en la url
    @RequestMapping(value = "pregunta/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getPreguntaById(@PathVariable(value = "id") int id) {
   	 try {
   	  // Find the team with the given ID
         Pregunta preguntaResponse = preguntaRepository.findById(id).orElse(null);

   		 return new ResponseEntity<>(preguntaResponse, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
    
    // Insert un equipo
    @RequestMapping(value = "equipo", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> insertarEquipo(@RequestBody Equipo equipo) {
   	 try {
   		 Equipo equipoResponse = equipoRepository.save(equipo);
   		 return new ResponseEntity<>(equipoResponse, HttpStatus.CREATED);

   	 } catch (Exception e) {
   		 return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
   	 }
    }
    
}

