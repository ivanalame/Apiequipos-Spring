package net.azarquiel.infoliguero.model;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
   @Id
    private int id;
    private String nick;
    private String pass;
	
    public Usuario() {
		super();
	}

	public Usuario(int id, String nick, String pass) {
		super();
		this.id = id;
		this.nick = nick;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nick=" + nick + ", pass=" + pass + "]";
	}
    
    
}
	