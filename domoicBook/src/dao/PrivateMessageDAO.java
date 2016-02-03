package dao;

import java.util.Calendar;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import model.Flat;
import model.PrivateMessage;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class PrivateMessageDAO {

    private static final Logger LOG = Logger.getLogger(PrivateMessageDAO.class);

    private EntityManager entityManager;

    public PrivateMessageDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param message
     * @param senderNumber
     * @param recipientNumber
     */
    public void addPrivateMessage(PrivateMessage message, int senderNumber, int recipientNumber) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    Flat sender = entityManager.find(Flat.class, senderNumber);
	    Flat recipient = entityManager.find(Flat.class, recipientNumber);
	    message.setSender(sender);
	    message.setRecipient(recipient);
	    message.setDate();

	    entityManager.persist(message);
	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for message to flat (" + recipientNumber + ") Performing rollback.");
	    }
	}
    }

    /**
     * @param flatNumber
     * @return
     */
    public Vector<PrivateMessage> getInfoAboutInbox(int flatNumber) {
	Flat flat = entityManager.find(Flat.class, flatNumber);
	String messageFilterQuery = "SELECT u FROM PrivateMessage u WHERE u.flat2=:flat2";

	TypedQuery<PrivateMessage> messageFilter = entityManager.createQuery(messageFilterQuery, PrivateMessage.class);
	messageFilter.setParameter("flat2", flat);

	return (Vector<PrivateMessage>) messageFilter.getResultList();
    }

    /**
     * @param flatNumber
     * @return
     */
    public Vector<PrivateMessage> getInfoAboutOutbox(int flatNumber) {
	Flat flat = entityManager.find(Flat.class, flatNumber);
	String messageFilterQuery = "SELECT u FROM PrivateMessage u WHERE u.flat1=:flat1";

	TypedQuery<PrivateMessage> messageFilter = entityManager.createQuery(messageFilterQuery, PrivateMessage.class);
	messageFilter.setParameter("flat1", flat);

	return (Vector<PrivateMessage>) messageFilter.getResultList();
    }
}