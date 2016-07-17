package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gmmiembros database table.
 * 
 */
@Entity
@Table(name="gmmiembros")
@NamedQuery(name="Gmmiembro.findAll", query="SELECT g FROM Gmmiembro g")
public class Gmmiembro implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idMiembro;
	private String apaterno;
	private String bautizado;
	private String cargo;
	private String colonia;
	private Date fechaNac;
	private String genero;
	private String municipio;
	private String nombre;

	public Gmmiembro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_miembro")
	public int getIdMiembro() {
		return this.idMiembro;
	}

	public void setIdMiembro(int idMiembro) {
		this.idMiembro = idMiembro;
	}


	public String getApaterno() {
		return this.apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}


	public String getBautizado() {
		return this.bautizado;
	}

	public void setBautizado(String bautizado) {
		this.bautizado = bautizado;
	}


	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac")
	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}