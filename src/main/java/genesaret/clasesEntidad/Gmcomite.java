package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gmcomites database table.
 * 
 */
@Entity
@Table(name="gmcomites")
@NamedQuery(name="Gmcomite.findAll", query="SELECT g FROM Gmcomite g")
public class Gmcomite implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idComite;
	private Date fecha;
	private String miembros;
	private String nombre;
	private String presidente;
	private String secretario;
	private String tesorero;
	private String vicepresidente;
	private String vocal;

	public Gmcomite() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comite")
	public int getIdComite() {
		return this.idComite;
	}

	public void setIdComite(int idComite) {
		this.idComite = idComite;
	}


	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getMiembros() {
		return this.miembros;
	}

	public void setMiembros(String miembros) {
		this.miembros = miembros;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPresidente() {
		return this.presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}


	public String getSecretario() {
		return this.secretario;
	}

	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}


	public String getTesorero() {
		return this.tesorero;
	}

	public void setTesorero(String tesorero) {
		this.tesorero = tesorero;
	}


	public String getVicepresidente() {
		return this.vicepresidente;
	}

	public void setVicepresidente(String vicepresidente) {
		this.vicepresidente = vicepresidente;
	}


	public String getVocal() {
		return this.vocal;
	}

	public void setVocal(String vocal) {
		this.vocal = vocal;
	}

}