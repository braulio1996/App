package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Voto;




@Stateless
public class VotoDAO {
	@Inject
	private EntityManager em;
	
	public void insertarVoto(Voto voto) {
		em.persist(voto);
			
	}
	public void actualizarVoto(Voto voto) {
		em.merge(voto);
		
		
	}
	public void borrarVoto(int isbn) {
		em.remove(buscarVoto(isbn));
	
}
	public Voto buscarVoto(int isbn) {
		em.find(Voto.class, isbn);
		return null;
}
	public List<Voto> listarVotos() {
		
		try {
		String jpql = "select l from Voto l";
		Query query = em.createQuery(jpql, Voto.class);
		List<Voto> v = query.getResultList();

		return v;
	}catch (Exception e) {
		// TODO: handle exception
	}
		return null;
	}
	
	public List<Object[]> masVotado() {
		try {
			String jpql = "SELECT libro_isbn, COUNT(libro_isbn) AS RecuentoFilas FROM Voto GROUP BY libro_isbn HAVING COUNT(*) > 0 ORDER BY libro_isbn";
			Query query = em.createNativeQuery(jpql);
			List<Object[]> v = query.getResultList();	
			
			return v;
		}catch (Exception e) {
			
		}
		

		return null;
	}

	
}
