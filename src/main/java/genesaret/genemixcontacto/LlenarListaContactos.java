package genesaret.genemixcontacto;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import genesaret.clasesEntidad.Gmcontacto;
@ManagedBean(name = "LlenarListaContactos")
@ApplicationScoped
public class LlenarListaContactos {
	 @PersistenceContext(unitName = "genesaret")
	    private EntityManager em;
	     
	      public List<Gmcontacto> ListaContactos(){
	        List<Gmcontacto> contactos = new ArrayList<Gmcontacto>(); //inicializamos la lista de objetos de nuestra clase productos 
	        contactos = em.createQuery("SELECT s FROM Gmcontacto s").getResultList(); //llenamos la lista d eobjetos
	        return contactos;
	    }
}
