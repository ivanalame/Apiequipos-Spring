package net.azarquiel.infoliguero.model;

import java.io.Serializable;

 



@jakarta.persistence.Entity 
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
   @jakarta.persistence.Id
    private int id;
    private String nombre;
    private String imagen;
	
    public Equipo() {
		super();
	}

	public Equipo(int id, String nombre, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}
	
	
}
