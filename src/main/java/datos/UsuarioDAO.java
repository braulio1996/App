package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Usuario;



@Stateless
public class UsuarioDAO {
	@Inject
	private EntityManager em;
	
	public Usuario insertarUsuario(Usuario usuario) {
		
	 em.persist(usuario);
	return usuario;
		
	}
	public Usuario actualizarUsuario(Usuario usuario) {
		return em.merge(usuario);
		
		
	}
	public void borrarUsuario(int userID) {
		em.remove(buscarUsuario(userID));
	
}
	public Usuario buscarUsuario(int userID) {
	
		return em.find(Usuario.class, userID);
}
	public List<Usuario> listarUsuarios() {
		String jpql = "SELECT l FROM Usuario l";
		Query query = em.createQuery(jpql, Usuario.class);
		List<Usuario> u = query.getResultList();
		return u;
	}
	public Usuario validar(String password) {
		String jpql = "SELECT c FROM Usuario c where c.password = :password";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter("password", password);
		Usuario cuenta= null;
		try {
		cuenta = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
	
		}
		return cuenta;
	}
	public Usuario read(int id) {
		return em.find(Usuario.class, id);
	}
}
