package dao;

import java.util.Calendar;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import model.Flat;
import model.Notification;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class NotificationDAO {

    private static final Logger LOG = Logger.getLogger(NotificationDAO.class);

    private EntityManager entityManager;

    public NotificationDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param newNotification
     * @param author
     */
    public void addNotification(Notification newNotification, int author) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    Flat flat = entityManager.find(Flat.class, author);
	    newNotification.setFlat(flat);
	    newNotification.setDate();

	    entityManager.persist(newNotification);
	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for notification (" + newNotification.getTitle() + ") Performing rollback.");
	    }
	}
    }

    /**
     * @return
     */
    public Vector<Notification> showInfoAboutAllNotifications() {
	Query notificationFilter = entityManager.createQuery("SELECT e " + "FROM Notification e");

	@SuppressWarnings("unchecked")
	Vector<Notification> notifications = (Vector<Notification>) notificationFilter.getResultList();

	return notifications;
    }
}