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
import modelo.Usuario;
import negocio.GestionarUsuario;
@Path("/usuario")
public class UsuarioService {
	@Inject
	private GestionarUsuario gl;
	
	@GET
	@Path("consultar")
	@Produces("application/json")
	public List<Usuario> listaUsuarios(){
		
		
		return gl.listarUsuarios();
	}
	
	@POST
	@Path("CreaUsuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta createCuenta(Usuario usuario) {
		Respuesta r = new Respuesta();
		try {
			
			gl.guardarUsuario(usuario);
			r.setCodigo(0);
			r.setMensaje("OK");
		}catch(Exception e) {
			r.setCodigo(99);
			r.setMensaje("Error al insertar");
		}
		return r;
	}
	
}
