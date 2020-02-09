package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.DetalleDAO;
import modelo.Detalle;


@Stateless
public class GestionarDetalle {
	
	@Inject
	private DetalleDAO vdao;
	
	
	public Detalle guardarDetalle(Detalle detalle) {
		vdao.insertarDetalle(detalle);
		return detalle;
		
	}
	public Detalle actualizarDetalle(Detalle detalle) {
		vdao.actualizarDetalle(detalle);
		
		return detalle;
	}
	public void borrarDetalle(int id) {
		vdao.borrarDetalle(id);
		
	}
	public Detalle buscarDetalle(int id) {
		return vdao.buscarDetalle(id);
	}
	public List<Detalle> listarDetalle() {
		
		return vdao.listarDetalles();
	}

}
