package genesaret.genemixcontacto;

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
import javax.persistence.NoResultException;
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
	
	@PersistenceContext(unitName = "GENESARETPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    
    Gmcontacto gmContacto = new Gmcontacto();

    

    
    public Gmcontacto getGmContacto() {
		return gmContacto;
	}
	public void setGmContacto(Gmcontacto gmContacto) {
		this.gmContacto = gmContacto;
	}
	public void enviarcoment(){
        
        try {
            
        
            utx.begin();
            gmContacto.setFecha(fecha());
            try
			{
				//Validando que el Email no exista
				Query q1 =em.createQuery("SELECT s.idContacto FROM Gmcontacto s WHERE s.email = :email");
				q1.setParameter("email", gmContacto.getEmail());
				if(q1.getResultList() == null)
					{
						System.out.println("Es nulo");
					}
        
				//mensaje de no envio
				FacesMessage msg = new FacesMessage("oops! Este Email Ya Existe ","Try Again");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				gmContacto=null;
			}
			catch(NoResultException e)
				{
				 em.persist(gmContacto);
		            utx.commit();
		            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Comentario enviado con exito! ","Gracias!");
		            FacesContext.getCurrentInstance().addMessage(null, msg1);
				}
            
            //addInfo(null, "Comentario enviado con exito!", gmContacto.getEmail());
            
           
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Algo va mal con la transaccion ","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            Logger.getLogger(GenemixContactoControlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al enviar  Comentarios  :" +ex.getMessage());
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
