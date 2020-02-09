package datos;


import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Categoria;
import modelo.Libro;



@Stateless
public class LibroDAO {
	@Inject
	@PersistenceContext
	private EntityManager em;
	
	public void insertarLibro(Libro libro) {
		em.persist(libro);
			
	}
	public void actualizarLibro(Libro libro) {
		em.merge(libro);
		
		
	}
	
	public void borrarLibro(int isbn) {
		em.remove(buscarLibro(isbn));
	
}
	public Libro buscarLibro(int isbn) {
		
		return em.find(Libro.class, isbn);
}
	public List<Libro> listarLibros() throws SQLException {
		try {
			String jpql = "select l from Libro l JOIN FETCH l.categorias ";
			Query query = em.createQuery(jpql, Libro.class);
			Libro libro= (Libro) query.getSingleResult();
			
			List<Libro> libroz = query.getResultList();
			
			List<Categoria> categorias = new ArrayList<Categoria>();
			for(Categoria categoria:libro.getCategorias()) {
				categorias.add(categoria);
			}
			return libroz;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		

		
		
		
	}
	
		
	
	

}
