package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Factura {
@Id
@GeneratedValue
private int idFactura;
private Date fecha;
private Double iva;
private Double subTotal;
private Double total;
@ManyToOne
private Usuario usuario;
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Detalle> detalles;
public int getIdFactura() {
	return idFactura;
}
public void setIdFactura(int idFactura) {
	this.idFactura = idFactura;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public Double getIva() {
	return iva;
}
public void setIva(Double iva) {
	this.iva = iva;
}
public Double getSubTotal() {
	return subTotal;
}
public void setSubTotal(Double subTotal) {
	this.subTotal = subTotal;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public List<Detalle> getDetalles() {
	return detalles;
}
public void setDetalles(List<Detalle> detalles) {
	this.detalles = detalles;
}
public void addDetalles(Detalle detalle) {
	if(detalles==null) {
		detalles= new ArrayList<>();	
	}
	detalles.add(detalle);
}
}
