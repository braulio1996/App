package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Factura;




@Stateless
public class FacturaDAO {
	@Inject
	private EntityManager em;
	
	public void insertarFactura(Factura factura) {
		em.persist(factura);
			
	}
	public void actualizarFactura(Factura factura) {
		em.merge(factura);
		
		
	}
	public void borrarFactura(int idFactura) {
		em.remove(buscarFactura(idFactura));
	
}
	public Factura buscarFactura(int idFactura) {
		em.find(Factura.class, idFactura);
		return null;
}
	public List<Factura> listarFacturas() {
		String jpql = "select l from Factura l";
		Query query = em.createQuery(jpql, Factura.class);
		List<Factura> v = query.getResultList();

		return v;
	}

}
