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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import genesaret.clasesEntidad.Gmboletin;


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
    
    
    Gmboletin gmBoletin = new Gmboletin();

   
public Gmboletin getGmBoletin() {
		return gmBoletin;
	}
	public void setGmBoletin(Gmboletin gmBoletin) {
		this.gmBoletin = gmBoletin;
	}
public void addEmail(){
	try{
		utx.begin();
		gmBoletin.setFecha(fecha());
		
		try{
	        Query q1 =em.createQuery("SELECT s.idBoletin FROM Gmboletin s WHERE s.email = :email");
	        q1.setParameter("email", gmBoletin.getEmail());
	        if(q1.getSingleResult() == null){
	            System.out.println("Es nulo");
	        }
	        
	        //mensaje de no creacion
	           FacesMessage msg = new FacesMessage("oops! Este Email Ya Existe ");
	           FacesContext.getCurrentInstance().addMessage(null, msg);
	        
	    }catch(NoResultException e){
	            em.persist(gmBoletin);
	            utx.commit();
	            FacesMessage msg = new FacesMessage("Email  Enviado con Exito! ", "Email: " + gmBoletin.getEmail());
	            FacesContext.getCurrentInstance().addMessage(null, msg);

	        
	    }
		
		
	}
	catch (Exception e) {
        FacesMessage msg = new FacesMessage("HA OCURRIDO UN ERROR INESPERADO.. VUELVA A INTENTAR ", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println(e);
    }
	
        
	
	/*
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
            Logger.getLogger(GenemixBoletinControlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al enviar email  :" +ex.getMessage());
        } 
      */  
    }
    public Date fecha()
    {
    java.util.Date dates=new java.util.Date();
    long fechaSis = dates.getTime();
    java.sql.Date d=new java.sql.Date(fechaSis);
    return d;
    }

}
