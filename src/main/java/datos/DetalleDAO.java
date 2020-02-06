package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Detalle;




@Stateless
public class DetalleDAO {
	@Inject
	private EntityManager em;
	
	public void insertarDetalle(Detalle detalle) {
		em.persist(detalle);
			
	}
	public void actualizarDetalle(Detalle detalle) {
		em.merge(detalle);
		
		
	}
	public void borrarDetalle(int idDetelle) {
		em.remove(buscarDetalle(idDetelle));
	
}
	public Detalle buscarDetalle(int idDetelle) {
		em.find(Detalle.class, idDetelle);
		return null;
}
	public List<Detalle> listarDetalles() {
		String jpql = "select l from Detalle l";
		Query query = em.createQuery(jpql, Detalle.class);
		List<Detalle> v = query.getResultList();

		return v;
	}

}
