package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gmvisitantes database table.
 * 
 */
@Entity
@Table(name="gmvisitantes")
@NamedQuery(name="Gmvisitante.findAll", query="SELECT g FROM Gmvisitante g")
public class Gmvisitante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_visitante")
	private int idVisitante;

	private String direcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String genero;

	private String nombre;

	private String telefono;

	public Gmvisitante() {
	}

	public int getIdVisitante() {
		return this.idVisitante;
	}

	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}

	public String getDirecion() {
		return this.direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}