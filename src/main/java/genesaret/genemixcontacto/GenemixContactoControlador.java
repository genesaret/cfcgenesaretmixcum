package genesaret.genemixcontacto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import genesaret.clasesEntidad.Gmcontacto;
@ManagedBean
@RequestScoped
@ViewScoped
public class GenemixContactoControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "genesaret")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    Gmcontacto gmContacto = new Gmcontacto();

    public Gmcontacto getGmContacto() {
        return gmContacto;
    }

    public void setScCarrera(Gmcontacto gmContacto) {
        this.gmContacto = gmContacto;
    }

    
    public void enviarcoment(){
        
        try {
            int id = 1;

            Query id2 = em.createQuery("SELECT MAX(s.idContacto) FROM Gmcontacto s");
            if (id2.getSingleResult() != null) {
                id= ((Integer) id2.getSingleResult()).intValue() + 1;
            }
        
            utx.begin();
            gmContacto.setIdContacto(id);
            em.persist(gmContacto);
            utx.commit();
            
            addInfo(null, "Comentario enviado con exito!", gmContacto.getEmail());
            gmContacto=null;
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Algo va mal con la transaccion ","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(GenemixContactoControlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al enviar  Comentarios  :" +ex.getMessage());
        } 
    }
    
}
