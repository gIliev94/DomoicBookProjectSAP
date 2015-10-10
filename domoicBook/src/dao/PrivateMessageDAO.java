package dao;

import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Flat;
import model.PrivateMessage;

public class PrivateMessageDAO {
    private EntityManager em;

    public PrivateMessageDAO(EntityManager em) {
	this.em = em;
    }

    public void addPrivateMessage(PrivateMessage message, int senderNumber, int receiverNumber) {
	try {
	    em.getTransaction().begin();
	    Flat sender = em.find(Flat.class, senderNumber);
	    Flat receiver = em.find(Flat.class, receiverNumber);
	    message.setFlat1(sender);
	    message.setFlat2(receiver);
	    message.setDate();
	    em.persist(message);
	    em.getTransaction().commit();
	} finally {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    }

    public Vector<PrivateMessage> getInfoAboutInbox(int flatNumber) {
	Flat flat = em.find(Flat.class, flatNumber);
	String query = "SELECT u FROM PrivateMessage u WHERE u.flat2=:flat2";
	TypedQuery<PrivateMessage> getQuery = em.createQuery(query, PrivateMessage.class);
	getQuery.setParameter("flat2", flat);
	return (Vector<PrivateMessage>) getQuery.getResultList();
    }

    public Vector<PrivateMessage> getInfoAboutOutbox(int flatNumber) {
	Flat flat = em.find(Flat.class, flatNumber);
	String query = "SELECT u FROM PrivateMessage u WHERE u.flat1=:flat1";
	TypedQuery<PrivateMessage> getQuery = em.createQuery(query, PrivateMessage.class);
	getQuery.setParameter("flat1", flat);
	return (Vector<PrivateMessage>) getQuery.getResultList();
    }

}