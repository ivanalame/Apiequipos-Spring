package net.azarquiel.infoliguero.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

 



@Entity 
public class Equipop implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    private int id;
    private String nombre;
    private String imagen;
	
    public Equipop() {
		super();
	}

	public Equipop(int id, String nombre, String imagen) {
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
