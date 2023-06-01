package net.azarquiel.infoliguero.model;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity 
public class Jugadorbu implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    private int id;
    private String nombre;
    private int edad;
    private String posicion;
    private int dorsal;
    private String Fecha_Nacimiento;
    private String pais;
    private String foto;
   
    //PREGUNTAR A PACO
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

	public Jugadorbu() {
		super();
	}

	public Jugadorbu(int id, String nombre, int edad, String posicion, int dorsal, String fecha_Nacimiento, String pais,
			String foto, Equipo equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.posicion = posicion;
		this.dorsal = dorsal;
		Fecha_Nacimiento = fecha_Nacimiento;
		this.pais = pais;
		this.foto = foto;
		this.equipo = equipo;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		Fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", posicion=" + posicion + ", dorsal="
				+ dorsal + ", Fecha_Nacimiento=" + Fecha_Nacimiento + ", pais=" + pais + ", foto=" + foto + ", equipo="
				+ equipo + "]";
	}
    
    
}
	
