package dao;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Flat;
import model.Notification;
public class NotificationDAO {
    private EntityManager em;

    public NotificationDAO(EntityManager em) {
        this.em = em;
    }
    
    public void addNotification(Notification newNotification,int source) {
        try {
            em.getTransaction().begin();
            Flat flat=em.find(Flat.class,source);
            newNotification.setFlat(flat);
            newNotification.setDate();
            em.persist(newNotification);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
}
    
    @SuppressWarnings("unchecked")
	public Vector<Notification> showInfoAboutAllNotifications(){
    	Query query = em.createQuery( "SELECT e " + "FROM Notification e");
		  return (Vector<Notification>)query.getResultList();
    }
		  
   
}