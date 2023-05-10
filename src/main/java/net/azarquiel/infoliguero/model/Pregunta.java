package net.azarquiel.infoliguero.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

 



@Entity 
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    private int id;
    private String texto;
	public Pregunta() {
		super();
	}
	public Pregunta(int id, String texto) {
		super();
		this.id = id;
		this.texto = texto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", texto=" + texto + "]";
	}
    
    
}