package net.azarquiel.infoliguero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.azarquiel.infoliguero.model.Equipo;
import net.azarquiel.infoliguero.model.Jugador;
import net.azarquiel.infoliguero.repository.EquipoRepository;
import net.azarquiel.infoliguero.repository.JugadorRepository;

/*al poner RestController en vez de Controller,
  ya no tenemos que poner la anotacion ResponseBody*/
@RestController
@CrossOrigin
@EnableAutoConfiguration
public class Controller {
    @Autowired
    EquipoRepository equipoRepository;
    JugadorRepository jugadorRepository;

    // Welcome de nuestra api por ejemplo podríamos poner aquí
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String get() {
   	 String cadena = "<h1 style='text-align: center; background-color: #0000c0; color: #C0C0FF;'>Welcome to Infoliguero Api with SpringBoot - IvanJuarez</h1>";
   	 cadena +="<table border='1' style='width: 40%;margin: 0 auto; background-color: #C0C0FF; color:#0000c0;'>";
   	 cadena +="<tr style='background-color: #0000c0; color: #C0C0FF;'><th>Method</th><th>Url</th><th>Description</th></tr>";
   	 cadena +="<tr><td>get </td><td>/equipos</td><td>Lista de equipos</td></tr>";
   	 cadena +="<tr><td>get </td><td>/equipo/{id}</td><td>Equipo</td></tr>";
   	 cadena +="<tr><td>post </td><td>/equipo</td><td>Inserta un equipo</td></tr>";
   	 cadena +="<tr><td>delete </td><td>/linea/{linea}</td><td>Borra linea</td></tr>";
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
   		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   	 }

    }

    // Get un equipo indicando el numero de equipo en la url
    @RequestMapping(value = "equipo/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getEquipoById(@PathVariable(value = "id") int id) {
   	 try {
   		 Equipo equipoResponse = equipoRepository.findById(id).orElse(null);
   		 return new ResponseEntity<>(equipoResponse, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   	 }

    }
    
    // Get un jugador indicando el numero de equipo en la url
    
    @RequestMapping(value = "jugador/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getJugadorByIdequipo(@PathVariable(value = "id") int id) {
   	 try {
   		 Jugador jugadorResponse = jugadorRepository.findById(id).orElse(null);
   		 return new ResponseEntity<>(jugadorResponse, HttpStatus.OK);

   	 } catch (Exception ex) {
   		 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

