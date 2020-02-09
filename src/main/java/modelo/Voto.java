package modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
public class Voto {
	@Id
	@GeneratedValue
	private int votoID;
	@OneToOne
	private Libro libro;
	@OneToOne
	private Usuario usuario;
	public int getVotoID() {
		return votoID;
	}
	public void setVotoID(int votoID) {
		this.votoID = votoID;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Voto [votoID=" + votoID + ", libro=" + libro + ", usuario=" + usuario + "]";
	}
	

}
