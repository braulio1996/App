package servicio;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Path("/pagos")
public class PagosService {
	
	@Inject
	//private GestionarPagos gl;
	
	
	
//	@GET
//	@Path("consultar")
//	@Produces("application/json")
//	public List<Cuenta> getCuentas(){
//		
//		
//		return gl.getCuentas();
//	}
	
	
	@POST
	@Path("CrearPagos")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta movimientos(){
		Respuesta r = new Respuesta();
		try {
			//gl.nuevoPago(t.getNumeroPago());
			r.setCodigo(1);
			r.setMensaje("ok");
		} catch (Exception e) {
			r.setCodigo(0);
			r.setMensaje("error");
			
		}
		return r;
		
	}


}
