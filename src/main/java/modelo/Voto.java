package modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class Voto {
	@Id
	@GeneratedValue
	private int votoID;
	
	public int getVotoID() {
		return votoID;
	}
	public void setVotoID(int votoID) {
		this.votoID = votoID;
	}
	
	
	@Override
	public String toString() {
		return "Voto [votoID=" + votoID + "]";
	}

}
