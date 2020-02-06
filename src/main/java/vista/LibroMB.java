package vista;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import modelo.Categoria;
import modelo.Libro;
import negocio.GestionarCategoria;
import negocio.GestionarLibro;

@ManagedBean
@ViewScoped
public class LibroMB {
	private Libro libro;
	@Inject
	private GestionarLibro lon;

	@Inject
	private GestionarCategoria con;
	
	private boolean updated;

	private String id;

private List<Libro>libros;
private List<Libro>libros2;




@PostConstruct
public void init()  {
	
		libro= new Libro();
		libro.addCategorias(new Categoria());
		libros=lon.listarLibro();
	
		// TODO: handle exception
	
	
}


public Libro getLibro() {
	return libro;
}


public void setLibro(Libro libro) {
	this.libro = libro;
}


public List<Libro> getLibros() {
	return libros;
}


public void setLibros(List<Libro> libros) {
	this.libros = libros;
}




public List<Libro> getLibros2() {
	return libros2;
}


public void setLibros2(List<Libro> libros2) {
	this.libros2 = libros2;
}


public String crearLibro() throws SQLException {
	try {
		if(updated) {
			lon.actualizarLibro(libro);
			updated = false;
		} else {
			lon.guardarLibro(this.libro);
		}
		init();	
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	return null;
}
public List<Libro> listarLibros(){
	
	try {
		
			
		return	libros2=lon.listarLibro();
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	
}
public String eliminar(Libro libro) {
	this.libro=libro;
	lon.borrarLibro(libro.getIsbn());

	return "libro_form";
}

public String actualizar() {
	lon.actualizarLibro(this.libro);
	return "libro_form";
}
public String detalle(Libro l) {
	System.out.println(""+l.toString());
	this.libro=l;
	return "book";
}
public Categoria buscarCategoria(int id) {
	
	return con.buscarCategoria(id);
}
public void addCategoria() {
	libro.addCategorias(new Categoria());
	
}

public String redirect(Libro l) {
	return "book?faces-redirect=true&id=" + l.getIsbn()+"&updated=true";
}

public void buscar() {
	if (id != null) {
		libro = lon.buscarLibro(Integer.parseInt(id));
	} else {
		return;
	}
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public boolean isUpdated() {
	return updated;
}


public void setUpdated(boolean updated) {
	this.updated = updated;
}





}
