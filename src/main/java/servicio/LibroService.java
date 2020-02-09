package servicio;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import modelo.Libro;
import modelo.Libro;
import negocio.GestionarLibro;
@Path("/Libro")
public class LibroService {
	@Inject
	private GestionarLibro gl;
	
	@GET
	@Path("consultar")
	@Produces("application/json")
	public List<Libro> listaLibros(){
		
		
		return gl.listarLibro();
	}
	
	@POST
	@Path("CreaLibro")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta createCuenta(Libro Libro) {
		Respuesta r = new Respuesta();
		try {
			
			gl.guardarLibro(Libro);
			r.setCodigo(0);
			r.setMensaje("OK");
		}catch(Exception e) {
			r.setCodigo(99);
			r.setMensaje("Error al insertar");
		}
		return r;
	}
	
}
