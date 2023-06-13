package net.azarquiel.infoliguero.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

 



@Entity 
public class Preguntap implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    private int id;
    private String texto;
	public Preguntap() {
		super();
	}
	public Preguntap(int id, String texto) {
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