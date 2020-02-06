package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Libro {
	@Id
	@GeneratedValue
	private int isbn;
	private String titulo;
	private String autor; 
	private String anio;
	private String editorial;
	private Double precio;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Categoria> categorias;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Voto>votos;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public List<Voto> getVotos() {
		return votos;
	}
	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public void addCategorias(Categoria categoria) {
		if(categorias==null) {
			categorias= new ArrayList<>();
			
		}
		categorias.add(categoria);
	}
		public void addVotos(Voto voto) {
			if(votos==null) {
				votos= new ArrayList<>();
				
			}
			votos.add(voto);
	}
		@Override
		public String toString() {
			return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", editorial="
					+ editorial + ", precio=" + precio + "]";
		}
	
}
