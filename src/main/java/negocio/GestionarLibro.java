package negocio;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.LibroDAO;
import modelo.Libro;


@Stateless
public class GestionarLibro {

@Inject
private LibroDAO ldao;

public Libro guardarLibro(Libro libro) {
	ldao.insertarLibro(libro);
	return libro;
	
}
public Libro actualizarLibro(Libro libro) {
	ldao.actualizarLibro(libro);
	
	return libro;
}
public void borrarLibro(int isbn) {
	
	ldao.borrarLibro(isbn);
}
public Libro buscarLibro(int id) {
	return ldao.buscarLibro(id);
}
public List<Libro> listarLibro(){
	try {
		return ldao.listarLibros();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
//public String addCategorias() {
//	libro.addCategorias(new Categoria());
//	return null;
//}
public List<Object[]> librosMasComprados() {
	
	return ldao.librosMasComprados();
}
}
