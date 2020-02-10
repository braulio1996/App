package modelo;

import java.util.ArrayList;
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
	private String direccion;
	private int rol;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Tarjeta> tarjetas;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Voto> votos;
public void addTarjetas(Tarjeta tarjeta) {
		if(tarjetas==null) {
			tarjetas= new ArrayList<>();
		}tarjetas.add(tarjeta);
	}
	public void addFacturas(Factura factura) {
		if(facturas==null) {
			facturas= new ArrayList<>();
		}
		facturas.add(factura);
	}
	public void addVotos(Voto voto) {
		if(votos==null) {
			votos= new ArrayList<>();
		}
		votos.add(voto);
	}
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}
	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	public List<Voto> getVotos() {
		return votos;
	}
	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	
	
	
}
