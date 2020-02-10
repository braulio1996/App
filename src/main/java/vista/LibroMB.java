package vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import modelo.Categoria;
import modelo.Libro;
import negocio.GestionarCategoria;
import negocio.GestionarLibro;

@ManagedBean
@ViewScoped
public class LibroMB {
	private Libro libro;
	private BarChartModel barra;
	@Inject
	private GestionarLibro lon;

	@Inject
	private GestionarCategoria con;
	
	private boolean updated;

	private String id;

private List<Libro>libros;

@PostConstruct
public void init()  {
	
		libro= new Libro();
		libro.addCategorias(new Categoria());
		libros=new ArrayList<Libro>();	
}


public BarChartModel getBarra() {
	return barra;
}


public void setBarra(BarChartModel barra) {
	this.barra = barra;
}


public Libro getLibro() {
	return libro;
}


public void setLibro(Libro libro) {
	this.libro = libro;
}


public List<Libro> getLibros() {
	return libros;
}


public void setLibros(List<Libro> libros) {
	this.libros = libros;
}


public String crearLibro() throws SQLException {
	try {
		if(updated) {
			lon.actualizarLibro(libro);
			updated = false;
		} else {
			lon.guardarLibro(this.libro);
		}
		init();	
		return "libro_form";
	}catch (Exception e) {
	}
	
	return "libro_form";
}
public List<Libro> listarLibros(){
	try {	
		libros=lon.listarLibro();
			
	}catch (Exception e) {
		e.printStackTrace();
	}
	return libros;
	
}
public String eliminar(Libro libro) {
	this.libro=libro;
	lon.borrarLibro(libro.getIsbn());

	return "libro_form";
}

public String actualizar() {
	lon.actualizarLibro(this.libro);
	return "libro_form";
}
public String detalle(Libro l) {
	System.out.println(""+l.toString());
	this.libro=l;
	return "book";
}
public Categoria buscarCategoria(int id) {
	
	return con.buscarCategoria(id);
}
public void addCategoria() {
	libro.addCategorias(new Categoria());
	
}

public String redirect(Libro l) {
	return "book?faces-redirect=true&id=" + l.getIsbn()+"&updated=true";
}

public void buscar() {
	if (id != null) {
		libro = lon.buscarLibro(Integer.parseInt(id));
	} else {
		return;
	}
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public boolean isUpdated() {
	return updated;
}


public void setUpdated(boolean updated) {
	this.updated = updated;
}

public void grafica() {
	barra = new BarChartModel();
	for(Object[] obj:lon.librosMasComprados()) {
		
		libro=lon.buscarLibro((int) obj[0]);
		
		ChartSeries serie = new BarChartSeries();
		serie.setLabel(lon.buscarLibro((int) obj[0]).getTitulo());
		serie.set(libro.getTitulo(),(Number) obj[1]);
		System.out.println(libro.getTitulo()+(Number) obj[1]);
		barra.addSeries(serie);
	
	}
		barra.setTitle("Libro mas Comprado");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("lIBROS");
		Axis yAxis=barra.getAxis(AxisType.Y);
	    yAxis.setLabel("Compras");
		yAxis.setMin(1);
  	    yAxis.setMax(50);
		
	}



}
