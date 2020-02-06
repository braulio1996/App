package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Tarjeta;




@Stateless
public class TarjetaDAO {
	@Inject
	private EntityManager em;
	
	public void insertarTarjeta(Tarjeta tarjeta) {
		em.persist(tarjeta);
			
	}
	public void actualizarTarjeta(Tarjeta tarjeta) {
		em.merge(tarjeta);
		
		
	}
	public void borrarTarjeta(int idTarjeta) {
		em.remove(buscarTarjeta(idTarjeta));
	
}
	public Tarjeta buscarTarjeta(int idTarjeta) {
		em.find(Tarjeta.class, idTarjeta);
		return null;
}
	public List<Tarjeta> listarTarjetas() {
		String jpql = "select l from Tarjeta l";
		Query query = em.createQuery(jpql, Tarjeta.class);
		List<Tarjeta> v = query.getResultList();

		return v;
	}

}
