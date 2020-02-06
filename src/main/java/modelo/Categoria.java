package modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
public class Categoria {
	@Id
	@GeneratedValue
	private int CategoriaID;
	private String nombre;
	private String descripcion;
	
	
	public int getCategoriaID() {
		return CategoriaID;
	}
	public void setCategoriaID(int categoriaID) {
		CategoriaID = categoriaID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}		
}
