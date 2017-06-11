package genesaret.genemixboletin;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import genesaret.clasesEntidad.Gmboletin;
/**
 * @author scooter
 *
 *File: GenemixBoletinControlador.java
 *This class takes care on new user subscriptions 
 */
@ManagedBean
@RequestScoped
@Stateful
@ViewScoped
public class GenemixBoletinControlador implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "GENESARETPU")
	private EntityManager em;
	@Resource
    private javax.transaction.UserTransaction utx;
	
    Gmboletin gmBoletin = new Gmboletin();
    
    //GETTER AND SETTER
    public Gmboletin getGmBoletin() 
    {
    	return gmBoletin;
	}
    
	public void setGmBoletin(Gmboletin gmBoletin) 
	{
		this.gmBoletin = gmBoletin;
	}
	
	/**
	 * insert a new user mail to GeneMix Database
	 */
	public void addEmail()
	{
		try
		{
			utx.begin();
			gmBoletin.setFecha(fecha());
			try
			{
				//verify whether the user mail is already logged in DB
				Query q1 =em.createQuery("SELECT s.idBoletin FROM Gmboletin s WHERE s.email = :email");
				q1.setParameter("email", gmBoletin.getEmail());
				//rollback the transaction whether the query returns null 
				//print the error message and set the gmBoletin object to NULL
				FacesMessage msg = new FacesMessage("oops! Este Email Ya Existe ","Try Again");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				gmBoletin=null;	
			}
			catch(NoResultException e)//if not result was triggered in try block we can add the mail to te DB 
			{
				//persist the gmBoletin object, commit the transaction and show the successful message
				em.persist(gmBoletin);
				utx.commit();
				FacesMessage msg = new FacesMessage("Email  Enviado con Exito! ", gmBoletin.getEmail());
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		catch (Exception e) 
		{
			FacesMessage msg = new FacesMessage("HA OCURRIDO UN ERROR INESPERADO.. VUELVA A INTENTAR ", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	/**
	 * @return current System Date
	 */
	public Date fecha()
	{
		java.util.Date dates=new java.util.Date();
		long sysDate = dates.getTime();
		java.sql.Date date=new java.sql.Date(sysDate);
		return date;
	}
}
