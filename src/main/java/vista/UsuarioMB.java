package vista;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.sound.midi.Soundbank;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import modelo.Usuario;
import negocio.GestionarUsuario;

@ManagedBean
public class UsuarioMB {
	
	private Usuario usuario;
	private Usuario usuario2;
	private List<Usuario>usuarios;
	private BarChartModel barra;
	
	@Inject
	private GestionarUsuario uon;
	
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		usuario2 = new Usuario();

		
	}
	
	
	public BarChartModel getBarra() {
		return barra;
	}


	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Usuario getUsuario2() {
		return usuario2;
	}


	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public List<Usuario> listar() {
		
		for (int i = 0; i <uon.listarUsuarios().size(); i++) {
			usuarios = uon.listarUsuarios();	
		}
		return usuarios;
	}
	

public String guardarUsuario() {
	
	uon.guardarUsuario(this.usuario);
	
        return null;
	}
	
public String validar() {
	
	usuario2=uon.validar(usuario.getPassword());
	
	return "index";
}
public String detalle(Usuario us) {
	
	this.usuario=us;
	return "user";
}
public String actualizarUsuario() {
	uon.actualizarUsuario(this.usuario);
	return "user_form";
}

public String borrarUsuario(Usuario u) {
	this.usuario=u;
	uon.borrarUsuario(u.getUserId());
	
	return "user_form";
}
public void grafica() {
	barra = new BarChartModel();
	for(Object[] obj:uon.clientesMasCompran()) {
		
		usuario=uon.buscarUsuario((int) obj[0]);
		
		ChartSeries serie = new BarChartSeries();
		serie.setLabel(uon.buscarUsuario((int) obj[0]).getNombre());
		serie.set(usuario.getNombre(),(Number) obj[1]);
		System.out.println(usuario.getNombre()+(Number) obj[1]);
		barra.addSeries(serie);
	
	}
		barra.setTitle("Usuarios que mas compran");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Usuarios");
		Axis yAxis=barra.getAxis(AxisType.Y);
	    yAxis.setLabel("Compras");
		yAxis.setMin(1);
  	    yAxis.setMax(50);
		
	}
}
