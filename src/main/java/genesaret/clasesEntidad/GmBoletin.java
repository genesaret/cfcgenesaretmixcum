package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gmBoletin database table.
 * 
 */
@Entity
@NamedQuery(name="GmBoletin.findAll", query="SELECT g FROM GmBoletin g")
public class GmBoletin implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idBoletin;
	private String email;
	private Date fecha;

	public GmBoletin() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_boletin")
	public int getIdBoletin() {
		return this.idBoletin;
	}

	public void setIdBoletin(int idBoletin) {
		this.idBoletin = idBoletin;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}