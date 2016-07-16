package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gmtesoreria database table.
 * 
 */
@Entity
@Table(name="gmtesoreria")
@NamedQuery(name="Gmtesoreria.findAll", query="SELECT g FROM Gmtesoreria g")
public class Gmtesoreria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tesor")
	private int idTesor;

	private String amaterno;

	private String apaterno;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nombre;

	private String tesoreria;

	private String total;

	@Column(name="total_entradas")
	private String totalEntradas;

	@Column(name="total_salidas")
	private String totalSalidas;

	public Gmtesoreria() {
	}

	public int getIdTesor() {
		return this.idTesor;
	}

	public void setIdTesor(int idTesor) {
		this.idTesor = idTesor;
	}

	public String getAmaterno() {
		return this.amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getApaterno() {
		return this.apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTesoreria() {
		return this.tesoreria;
	}

	public void setTesoreria(String tesoreria) {
		this.tesoreria = tesoreria;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getTotalEntradas() {
		return this.totalEntradas;
	}

	public void setTotalEntradas(String totalEntradas) {
		this.totalEntradas = totalEntradas;
	}

	public String getTotalSalidas() {
		return this.totalSalidas;
	}

	public void setTotalSalidas(String totalSalidas) {
		this.totalSalidas = totalSalidas;
	}

}