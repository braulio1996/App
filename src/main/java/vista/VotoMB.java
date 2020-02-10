package vista;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Libro;
import modelo.Voto;
import negocio.GestionarLibro;
import negocio.GestionarVoto;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;


@ManagedBean
public class VotoMB {
	private List<Voto>votos;
	private List<Voto>masvotos;
	private Voto voto;
	private Libro libro;
	private BarChartModel barra;
	@Inject
	private GestionarVoto von;
	
	@Inject
	private GestionarLibro l;
	@PostConstruct
	public void init() {
		voto= new Voto();
		libro= new Libro();
		
	}
	
	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}

	public List<Voto> getMasvotos() {
		return masvotos;
	}

	public void setMasvotos(List<Voto> masvotos) {
		this.masvotos = masvotos;
	}

	public List<Voto> getVotos() {
		return votos;
	}
	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	public Voto getVoto() {
		return voto;
	}
	public void setVoto(Voto voto) {
		this.voto = voto;
	}
	public void listar() {
		//votos = von.masVotado();
	}
	public String guardarVoto() {
		von.guardarVoto(voto);
		listar();
		return null;
		
	}
	public String actualizarVoto() {
		von.actualizarVoto(voto);
		listar();
		return null;
	}
	public String borrarVoto(int id) {
		von.borrarVoto(id);
		listar();
		return null;
	}
	
public void masvotos() {
	votos=von.listarVoto();
	grafica();
}
public void grafica() {
	barra = new BarChartModel();
	for(Object[] obj:von.masVotado()) {
		
		libro=l.buscarLibro((int) obj[0]);
		
		ChartSeries serie = new BarChartSeries();
		serie.setLabel(l.buscarLibro((int) obj[0]).getTitulo());
		serie.set(libro.getTitulo(),(Number) obj[1]);
		System.out.println(libro.getTitulo()+(Number) obj[1]);
		barra.addSeries(serie);
	
	}
		barra.setTitle("Libro mas Votado");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("lIBROS");
		Axis yAxis=barra.getAxis(AxisType.Y);
	    yAxis.setLabel("VOTOS");
		yAxis.setMin(1);
  	    yAxis.setMax(50);
		
	}

}
