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
import net.azarquiel.infoliguero.model.Equipobu;
import net.azarquiel.infoliguero.model.Equipofr;
import net.azarquiel.infoliguero.model.Equipoit;
import net.azarquiel.infoliguero.model.Equipop;
import net.azarquiel.infoliguero.model.Jugador;
import net.azarquiel.infoliguero.model.Jugadorbu;
import net.azarquiel.infoliguero.model.Jugadorfr;
import net.azarquiel.infoliguero.model.Jugadorit;
import net.azarquiel.infoliguero.model.Jugadorp;
import net.azarquiel.infoliguero.model.Pregunta;
import net.azarquiel.infoliguero.model.Respuesta;
import net.azarquiel.infoliguero.model.Usuario;
import net.azarquiel.infoliguero.repository.EquipoRepository;
import net.azarquiel.infoliguero.repository.EquipobuRepository;
import net.azarquiel.infoliguero.repository.EquipofrRepository;
import net.azarquiel.infoliguero.repository.EquipoitRepository;
import net.azarquiel.infoliguero.repository.EquipopRepository;
import net.azarquiel.infoliguero.repository.JugadorRepository;
import net.azarquiel.infoliguero.repository.JugadorbuRepository;
import net.azarquiel.infoliguero.repository.JugadorfrRepository;
import net.azarquiel.infoliguero.repository.JugadoritRepository;
import net.azarquiel.infoliguero.repository.JugadorpRepository;
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
    private final EquipopRepository equipopRepository;
    private final JugadorpRepository jugadorpRepository;
    private final EquipoitRepository equipoitRepository;
    private final JugadoritRepository jugadoritRepository;
    private final EquipobuRepository equipobuRepository;
    private final JugadorbuRepository jugadorbuRepository;
    private final EquipofrRepository equipofrRepository;
    private final JugadorfrRepository jugadorfrRepository;



	public Controller(EquipoRepository equipoRepository, JugadorRepository jugadorRepository,
			UsuarioRepository usuarioRepository, PreguntaRepository preguntaRepository,
			RespuestaRepository respuestaRepository, EquipopRepository equipopRepository,
			JugadorpRepository jugadorpRepository, EquipoitRepository equipoitRepository,
			JugadoritRepository jugadoritRepository, EquipobuRepository equipobuRepository,
			JugadorbuRepository jugadorbuRepository, EquipofrRepository equipofrRepository,
			JugadorfrRepository jugadorfrRepository) {
		super();
		this.equipoRepository = equipoRepository;
		this.jugadorRepository = jugadorRepository;
		this.usuarioRepository = usuarioRepository;
		this.preguntaRepository = preguntaRepository;
		this.respuestaRepository = respuestaRepository;
		this.equipopRepository = equipopRepository;
		this.jugadorpRepository = jugadorpRepository;
		this.equipoitRepository = equipoitRepository;
		this.jugadoritRepository = jugadoritRepository;
		this.equipobuRepository = equipobuRepository;
		this.jugadorbuRepository = jugadorbuRepository;
		this.equipofrRepository = equipofrRepository;
		this.jugadorfrRepository = jugadorfrRepository;
	}



	// Welcome de nuestra api por ejemplo podríamos poner aquí
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String get() {
   	 String cadena = "<h1 style='text-align: center; background-color: #572364; color: #ffe914 ;'>Bienvenido a  Infoliguero Api with SpringBoot - IvanJuarez</h1>";
   	 cadena +="<table border='1' style='width: 40%;margin: 0 auto; background-color: #572364; color:#ffe914;'>";
   	 cadena +="<tr style='background-color: #572364; color: #ffe914;'><th>Method</th><th>Url</th><th>Description</th></tr>";
   	 cadena +="<tr><td>get </td><td>/equipos</td><td>Lista de equipos</td></tr>";
   	 cadena +="<tr><td>get </td><td>/equiposp</td><td>Lista de equipos de la Premier</td></tr>";
   	 cadena +="<tr><td>get </td><td>/equiposit</td><td>Lista de equipos de la Serie A (liga italiana)</td></tr>";
   	 cadena +="<tr><td>get </td><td>/equiposbu</td><td>Lista de equipos de la Bundesliga (liga alemana)</td></tr>";
   	 cadena +="<tr><td>get </td><td>/equiposfr</td><td>Lista de equipos de la Ligue1 (liga francesa)</td></tr>";
   	 cadena +="<tr><td>get </td><td>/equipo/{id}</td><td>Equipo</td></tr>";
   	cadena +="<tr><td>get </td><td>/equipop/{id}</td><td>Equipo Premier</td></tr>";
   	cadena +="<tr><td>get </td><td>/equipoit/{id}</td><td>Equipo Serie A</td></tr>";
   	cadena +="<tr><td>get </td><td>/equipobu/{id}</td><td>Equipo Bundesliga</td></tr>";
   	cadena +="<tr><td>get </td><td>/equipofr/{id}</td><td>Equipo Ligue1</td></tr>";
   	 cadena +="<tr><td>post </td><td>/equipo</td><td>Inserta un equipo</td></tr>";
   	 cadena +="<tr><td>get </td><td>/jugador/{id_equipo}</td><td>sacar lista  de jugadores por id de equipo</td></tr>";
   	cadena +="<tr><td>get </td><td>/jugadorp/{id_equipo}</td><td>sacar lista  de jugadores por id de equipo Premier</td></tr>";
   	cadena +="<tr><td>get </td><td>/jugadorit/{id_equipo}</td><td>sacar lista  de jugadores por id de equipo Serie A</td></tr>";
   	cadena +="<tr><td>get </td><td>/jugadorbu/{id_equipo}</td><td>sacar lista  de jugadores por id de equipo Bundesliga</td></tr>";
   	cadena +="<tr><td>get </td><td>/jugadorfr/{id_equipo}</td><td>sacar lista  de jugadores por id de equipo Ligue 1</td></tr>";
   	 cadena +="<tr><td>get </td><td>/usuario</td><td>sacar usuario by nick and pass</td></tr>";
   	 cadena +="<tr><td>get </td><td>/pregunta/{id}</td><td>sacar pregunta by id</td></tr>";
   	 cadena +="<tr><td>get </td><td>/respuesta/{id_pregunta}</td><td>sacar respuestas by id_pregunta</td></tr>";
    	cadena +="</table>";
   	 return cadena;
    }

    

	// Get lista con todos los equipos españa
    @RequestMapping(value = "equipos", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipos() {
   	 try {
   		 Iterable<Equipo> equipos = equipoRepository.findAll();
   		 return new ResponseEntity<>(equipos, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }

    // Get un equipo indicando el numero de equipo españa en la url
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
    
 // Get un equipo de la premier indicando el numero de equipo en la url
    @RequestMapping(value = "equipop/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipopremierAndPlayersById(@PathVariable(value = "id") int id) {
   	 try {
   	  // Find the team with the given ID
         Equipop equipoResponse =  equipopRepository.findById(id).orElse(null);

   		 return new ResponseEntity<>(equipoResponse, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
   
    
 // Get un equipo de la Serie A  indicando el numero de equipo en la url
    @RequestMapping(value = "equipoit/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipoItaliaAndPlayersById(@PathVariable(value = "id") int id) {
   	 try {
   	  // Find the team with the given ID
         Equipoit equipoResponse =  equipoitRepository.findById(id).orElse(null);

   		 return new ResponseEntity<>(equipoResponse, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
    
 // Get un equipo de la Bundesliga  indicando el numero de equipo en la url
    @RequestMapping(value = "equipobu/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipoBundesligaAndPlayersById(@PathVariable(value = "id") int id) {
   	 try {
   	  // Find the team with the given ID
         Equipobu equipoResponse =  equipobuRepository.findById(id).orElse(null);

   		 return new ResponseEntity<>(equipoResponse, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
    
 // Get un equipo de la Ligue1  indicando el numero de equipo en la url
    @RequestMapping(value = "equipofr/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipoFranciaAndPlayersById(@PathVariable(value = "id") int id) {
   	 try {
   	  // Find the team with the given ID
         Equipofr equipoResponse =  equipofrRepository.findById(id).orElse(null);

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
    
 // Get lista jugadores indicando el numero de equipo PREMIER en la url
    
    @RequestMapping(value = "jugadorp/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Jugadorp>> getJugadoresPremierByIdequipo(@PathVariable(value = "id") int id_equipo) {
        try {
            // Find all players that are associated with the given team ID
        	System.out.println(id_equipo);
            List<Jugadorp> jugadoresp = jugadorpRepository.findByEquipoId(id_equipo);

            return new ResponseEntity<>(jugadoresp, HttpStatus.OK);

        } catch (Exception ex) {
        	
        	
        	ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
// Get lista jugadores indicando el numero de equipo SERIE A  en la url
    
    @RequestMapping(value = "jugadorit/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Jugadorit>> getJugadoresItaliaByIdequipo(@PathVariable(value = "id") int id_equipo) {
        try {
            // Find all players that are associated with the given team ID
        	System.out.println(id_equipo);
            List<Jugadorit> jugadoresit = jugadoritRepository.findByEquipoId(id_equipo);

            return new ResponseEntity<>(jugadoresit, HttpStatus.OK);

        } catch (Exception ex) {
        	
        	
        	ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
// Get lista jugadores indicando el numero de equipo BUNDESLIGA   en la url
    
    @RequestMapping(value = "jugadorbu/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Jugadorbu>> getJugadoresBundesligaByIdequipo(@PathVariable(value = "id") int id_equipo) {
        try {
            // Find all players that are associated with the given team ID
        	System.out.println(id_equipo);
            List<Jugadorbu> jugadoresbu = jugadorbuRepository.findByEquipoId(id_equipo);

            return new ResponseEntity<>(jugadoresbu, HttpStatus.OK);

        } catch (Exception ex) {
        	
        	
        	ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
// Get lista jugadores indicando el numero de equipo LIGUE 1   en la url
    
    @RequestMapping(value = "jugadorfr/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Jugadorfr>> getJugadoresFranciaByIdequipo(@PathVariable(value = "id") int id_equipo) {
        try {
            // Find all players that are associated with the given team ID
        	System.out.println(id_equipo);
            List<Jugadorfr> jugadoresfr = jugadorfrRepository.findByEquipoId(id_equipo);

            return new ResponseEntity<>(jugadoresfr, HttpStatus.OK);

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
    
 // Get lista con todos los equipos Premier
    @RequestMapping(value = "equiposp", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquiposPremier() {
   	 try {
   		 Iterable<Equipop> equiposp = equipopRepository.findAll();
   		 return new ResponseEntity<>(equiposp, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
    
 // Get lista con todos los equipos Serie A 
    @RequestMapping(value = "equiposit", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquiposItalia() {
   	 try {
   		 Iterable<Equipoit> equiposit = equipoitRepository.findAll();
   		 return new ResponseEntity<>(equiposit, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
    
 // Get lista con todos los equipos Bundesliga
    @RequestMapping(value = "equiposbu", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquiposBundesliga() {
   	 try {
   		 Iterable<Equipobu> equiposbu = equipobuRepository.findAll();
   		 return new ResponseEntity<>(equiposbu, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   	 }

    }
    
    // Get lista con todos los equipos Ligue 1 
    @RequestMapping(value = "equiposfr", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquiposFrancia() {
   	 try {
   		 Iterable<Equipofr> equiposfr = equipofrRepository.findAll();
   		 return new ResponseEntity<>(equiposfr, HttpStatus.OK);

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

