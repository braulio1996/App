package negocio;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.CategoriaDAO;
import modelo.Categoria;



@Stateless
public class GestionarCategoria {

	@Inject
	private CategoriaDAO cdao;
	
	
	
	
	public Categoria guardarCategoria(Categoria categoria) {
		cdao.insertarCategoria(categoria);
		return categoria;
		
	}
	public Categoria actualizarCategoria(Categoria categoria) {
		cdao.actualizarCategoria(categoria);
		
		return categoria;
	}
	public void borrarCategoria(int id) {
		cdao.borrarCategoria(id);
		
	}
	public Categoria buscarCategoria(int id) {
		return cdao.buscarCategoria(id);
	}
	public List<Categoria> listarCategorias() {
		try {
			return cdao.listarCategorias();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	

}
