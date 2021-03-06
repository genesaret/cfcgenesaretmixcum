package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * 	File: Gmiglesia.java
 * The persistent class for the gmiglesia database table.
 * 
 */
@Entity
@Table(name="gmiglesia")
@NamedQuery(name="Gmiglesia.findAll", query="SELECT g FROM Gmiglesia g")
public class Gmiglesia implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int idiglesia;
	private String colonia;
	private String direccion;
	private Date fecha;
	private String miembros;
	private String municipio;
	private String nombre;
	private String pastor;
	private String telefono;

	public Gmiglesia() 
	{
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdiglesia() 
	{
		return this.idiglesia;
	}

	public void setIdiglesia(int idiglesia) 
	{
		this.idiglesia = idiglesia;
	}

	public String getColonia() 
	{
		return this.colonia;
	}

	public void setColonia(String colonia) 
	{
		this.colonia = colonia;
	}

	public String getDireccion() 
	{
		return this.direccion;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
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

	public String getMiembros() 
	{
		return this.miembros;
	}

	public void setMiembros(String miembros) 
	{
		this.miembros = miembros;
	}

	public String getMunicipio() 
	{
		return this.municipio;
	}

	public void setMunicipio(String municipio) 
	{
		this.municipio = municipio;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getPastor() 
	{
		return this.pastor;
	}

	public void setPastor(String pastor) 
	{
		this.pastor = pastor;
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