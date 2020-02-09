package modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Detalle {
@Id
@GeneratedValue
private int idDetalle;
private Double precioUnitario;
private int cantidad;
private Double subTotal;
@ManyToOne
private Libro libros;
public int getIdDetalle() {
	return idDetalle;
}
public void setIdDetalle(int idDetalle) {
	this.idDetalle = idDetalle;
}
public Double getPrecioUnitario() {
	return precioUnitario;
}
public void setPrecioUnitario(Double precioUnitario) {
	this.precioUnitario = precioUnitario;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public Double getSubTotal() {
	return subTotal;
}
public void setSubTotal(Double subTotal) {
	this.subTotal = subTotal;
}
public Libro getLibros() {
	return libros;
}
public void setLibros(Libro libros) {
	this.libros = libros;
}

}
