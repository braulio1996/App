package servicio;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;




@Path("/cuentas")
public class CuentaService {
	
	@Inject

	
	
	@POST
	@Path("CreaUsuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta createCuenta() {
		Respuesta r = new Respuesta();
		try {
			
		//	gl.guardar(cuenta);
			r.setCodigo(0);
			r.setMensaje("OK");
		}catch(Exception e) {
			r.setCodigo(99);
			r.setMensaje("Error al insertar");
		}
		return r;
	}


}
