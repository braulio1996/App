package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.FacturaDAO;
import modelo.Factura;


@Stateless
public class GestionarFactura {
	
	@Inject
	private FacturaDAO vdao;
	
	
	public Factura guardarFactura(Factura factura) {
		vdao.insertarFactura(factura);
		return factura;
		
	}
	public Factura actualizarFactura(Factura factura) {
		vdao.actualizarFactura(factura);
		
		return factura;
	}
	public void borrarFactura(int id) {
		vdao.borrarFactura(id);
		
	}
	public Factura buscarFactura(int id) {
		return vdao.buscarFactura(id);
	}
	public List<Factura> listarFactura() {
		
		return vdao.listarFacturas();
	}

}
