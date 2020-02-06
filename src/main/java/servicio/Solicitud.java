package servicio;
//se crea la entidad para la solicitu del credito 
//esto no se realizo en la prueba 
public class Solicitud {
	private Double monto;
	private int meses;
	private int numero;
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public int getMeses() {
		return meses;
	}
	public void setMeses(int meses) {
		this.meses = meses;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
