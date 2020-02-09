package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private int userID;
	private String nombre;
	private String apellido;
	private String email; 
	private String password;
	private int rol;
	public int getUserId() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getUserID() {
		return userID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
