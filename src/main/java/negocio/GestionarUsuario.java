package negocio;



import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.UsuarioDAO;
import modelo.Usuario;


@Stateless
public class GestionarUsuario {

	@Inject
	private UsuarioDAO udao;
	
	
	
	

public Usuario guardarUsuario(Usuario usuario) {
	udao.insertarUsuario(usuario);
	return usuario;
	
}
public Usuario actualizarUsuario(Usuario usuario) {
	if(udao.read(usuario.getUserId())==null) {
		System.out.println("Noexite Uusuario=================================================================");
		return null;
	}else {
		return udao.actualizarUsuario(usuario);
	}
}
public void borrarUsuario(int id) {
	udao.borrarUsuario(id);
	
}
public Usuario buscarUsuario(int id) {
	return udao.buscarUsuario(id);
}

public List<Usuario>listarUsuarios(){
	return udao.listarUsuarios();
	
}
public Usuario validar(String password) {
	return udao.validar(password);
	
}


}
