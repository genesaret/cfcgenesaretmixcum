package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * File: Gmcelula.java
 * The persistent class for the gmcelulas database table.
 * 
 */
@Entity
@Table(name="gmcelulas")
@NamedQuery(name="Gmcelula.findAll", query="SELECT g FROM Gmcelula g")
public class Gmcelula implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int idCelula;
	private String lider;
	private String miembros;
	private String nombre;

	public Gmcelula() 
	{
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_celula")
	public int getIdCelula() 
	{
		return this.idCelula;
	}

	public void setIdCelula(int idCelula) 
	{
		this.idCelula = idCelula;
	}

	public String getLider() 
	{
		return this.lider;
	}

	public void setLider(String lider) 
	{
		this.lider = lider;
	}

	public String getMiembros() 
	{
		return this.miembros;
	}

	public void setMiembros(String miembros) 
	{
		this.miembros = miembros;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
}