package genesaret.clasesEntidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gmcontacto database table.
 * 
 */
@Entity
@Table(name="gmcontacto")
@NamedQuery(name="Gmcontacto.findAll", query="SELECT g FROM Gmcontacto g")
public class Gmcontacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_contacto")
	private int idContacto;

	private String comentario;

	private String email;

	private String nombre;

	private String telefono;

	public Gmcontacto() {
	}

	public int getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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