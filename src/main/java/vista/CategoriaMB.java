package vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Categoria;
import modelo.Libro;
import negocio.GestionarCategoria;
import negocio.GestionarLibro;



@ManagedBean
public class CategoriaMB {
	private int filtro;
	private List<Categoria>categorias;
	private List<Libro>libros;
	private Categoria categoria;
	private Libro libro;
	@Inject
	private GestionarCategoria con;
	
	@Inject
	private GestionarLibro l;
	
	@PostConstruct
	public void init() {
		categoria= new Categoria();
		libro= new Libro();
		categorias = new ArrayList<Categoria>();
		libros = new ArrayList<Libro>();
		
	}
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getFiltro() {
		return filtro;
	}

	public void setFiltro(int filtro) {
		this.filtro = filtro;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String guardarCategoria() {
		con.guardarCategoria(this.categoria);
		return "categoria_form";
		
	}
	public List<Categoria>listar() {
		
			try {
				
			
			categorias=con.listarCategorias();
	
		return categorias;
			}catch (Exception e) {
				// TODO: handle exception
			}
			return categorias;
	}
	public List<Libro>listarLibro() {
		try {
			
			return libros=l.listarLibro();
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public String actualizarCategoria() {
		con.actualizarCategoria(categoria);
		
		return "categoria_form";
	}
	public String borrarCategoria(Categoria c) {
		this.categoria=c;
		con.borrarCategoria(c.getCategoriaID());
		
		return "categoria_form";
	}
	public String detalle(Categoria categoria ) {
		
		this.categoria=categoria;
		return "categoria";
	}
	public String buscarLibro() {
		libro=l.buscarLibro(filtro);
		
		
		return "categoria_form";
	}

}
