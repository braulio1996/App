package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Categoria;




@Stateless
public class CategoriaDAO {
	@Inject
	private EntityManager em;
	
	public void insertarCategoria(Categoria categoria) {
		em.persist(categoria);
			
	}
	public void actualizarCategoria(Categoria categoria) {
		em.merge(categoria);
		
		
	}
	public void borrarCategoria(int isbn) {
		em.remove(buscarCategoria(isbn));
		
}
	public Categoria buscarCategoria(int isbn) {
		em.find(Categoria.class, isbn);
		return null;
}
	public List<Categoria> listarCategorias() {
		try {
			String jpql = "select l from Categoria l";
			Query query = em.createQuery(jpql, Categoria.class);
			List<Categoria> c = query.getResultList();

			return c;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
