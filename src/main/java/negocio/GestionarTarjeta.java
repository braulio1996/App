package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.TarjetaDAO;
import modelo.Tarjeta;


@Stateless
public class GestionarTarjeta {
	
	@Inject
	private TarjetaDAO vdao;
	
	
	public Tarjeta guardarTarjeta(Tarjeta tarjeta) {
		vdao.insertarTarjeta(tarjeta);
		return tarjeta;
		
	}
	public Tarjeta actualizarTarjeta(Tarjeta tarjeta) {
		vdao.actualizarTarjeta(tarjeta);
		
		return tarjeta;
	}
	public void borrarTarjeta(int id) {
		vdao.borrarTarjeta(id);
		
	}
	public Tarjeta buscarTarjeta(int id) {
		return vdao.buscarTarjeta(id);
	}
	public List<Tarjeta> listarTarjeta() {
		
		return vdao.listarTarjetas();
	}

}
