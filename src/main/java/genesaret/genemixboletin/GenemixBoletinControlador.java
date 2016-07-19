package genesaret.genemixboletin;

import java.io.Serializable;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import genesaret.clasesEntidad.GmBoletin;
import genesaret.clasesEntidad.Gmcontacto;
import genesaret.genemixcontacto.GenemixContactoControlador;


@ManagedBean
@RequestScoped
@ViewScoped
public class GenemixBoletinControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "GENESARETPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    
    GmBoletin gmBoletin = new GmBoletin();

    public GmBoletin getGmBoletin() {
        return gmBoletin;
    }

    public void setGmBoletin(GmBoletin gmBoletin) {
        this.gmBoletin = gmBoletin;
    }
public void addEmail(){
        
        try {
        
            utx.begin();
            gmBoletin.setFecha(fecha());
            em.persist(gmBoletin);
            utx.commit();
            
            //addInfo(null, "Comentario enviado con exito!", gmBoletin.getEmail());
            
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Email Enviado  con Exito! ","Gracias!");
            FacesContext.getCurrentInstance().addMessage(null, msg1);
            gmBoletin=null;
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Algo va mal con la transaccion ","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(GenemixContactoControlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al enviar email  :" +ex.getMessage());
        } 
    }
    public Date fecha()
    {
    java.util.Date dates=new java.util.Date();
    long fechaSis = dates.getTime();
    java.sql.Date d=new java.sql.Date(fechaSis);
    return d;
    }

}
