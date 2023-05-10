package net.azarquiel.infoliguero.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity 
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    private int id;
    private String texto;
    private int correcta;         //boolean 
   
    //PREGUNTAR A PACO
    @ManyToOne
    @JoinColumn(name = "id_pregunta")
    private Pregunta pregunta;

	public Respuesta() {
		super();
	}

	public Respuesta(int id, String texto, int correcta, Pregunta pregunta) {
		super();
		this.id = id;
		this.texto = texto;
		this.correcta = correcta;
		this.pregunta = pregunta;
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

	public int getCorrecta() {
		return correcta;
	}

	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", texto=" + texto + ", correcta=" + correcta + ", pregunta=" + pregunta + "]";
	}
    
    
}