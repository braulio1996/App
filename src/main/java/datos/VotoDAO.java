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
		String jpql = "select l from Voto l";
		Query query = em.createQuery(jpql, Voto.class);
		List<Voto> v = query.getResultList();

		return v;
	}

}
