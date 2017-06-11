package genesaret.genemixcontacto;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import genesaret.clasesEntidad.Gmcontacto;
/**
 * @author scooter
 *File: LlenarListaContactos.java
 */
@ManagedBean(name = "LlenarListaContactos")
@ApplicationScoped
public class LlenarListaContactos 
{
	@PersistenceContext(unitName = "GENESARETPU")
	private EntityManager em;
	@SuppressWarnings("unchecked")
	
	public List<Gmcontacto> ListaContactos()
	{
		List<Gmcontacto> contactos = new ArrayList<Gmcontacto>(); //inicializamos la lista de objetos de nuestra clase Gmcontacto 
		contactos = em.createQuery("SELECT s FROM Gmcontacto s").getResultList(); //llenamos la lista de objetos
		return contactos;
	}
}
