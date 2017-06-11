package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * File: Gmpeticione.java
 * The persistent class for the gmpeticiones database table.
 * 
 */
@Entity
@Table(name="gmpeticiones")
@NamedQuery(name="Gmpeticione.findAll", query="SELECT g FROM Gmpeticione g")
public class Gmpeticione implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int idPet;
	private String amaterno;
	private String apaterno;
	private String clasificacion;
	private String descripcion;
	private Date fecha;
	private String genero;
	private String nombre;
	private String telefono;

	public Gmpeticione() 
	{
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pet")
	public int getIdPet() 
	{
		return this.idPet;
	}

	public void setIdPet(int idPet) 
	{
		this.idPet = idPet;
	}

	public String getAmaterno() 
	{
		return this.amaterno;
	}

	public void setAmaterno(String amaterno) 
	{
		this.amaterno = amaterno;
	}

	public String getApaterno() 
	{
		return this.apaterno;
	}

	public void setApaterno(String apaterno) 
	{
		this.apaterno = apaterno;
	}

	public String getClasificacion() 
	{
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) 
	{
		this.clasificacion = clasificacion;
	}

	public String getDescripcion() 
	{
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	public Date getFecha() 
	{
		return this.fecha;
	}
	
	public void setFecha(Date fecha) 
	{
		this.fecha = fecha;
	}

	public String getGenero() 
	{
		return this.genero;
	}

	public void setGenero(String genero) 
	{
		this.genero = genero;
	}

	public String getNombre() 
	{
		return this.nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
}