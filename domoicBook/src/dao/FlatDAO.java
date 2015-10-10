package dao;

import java.security.MessageDigest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Flat;

public class FlatDAO {
    private EntityManager em;

    public FlatDAO(EntityManager em) {
	this.em = em;
    }

    public void addFlat(Flat flat) {
	try {
	    em.getTransaction().begin();
	    flat.setPassword(getHashedPassword(flat.getPassword()));
	    em.persist(flat);
	    em.getTransaction().commit();
	} finally {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    }

    public boolean validateFlat(int flatNumber, String password) {
	String validateQuery = "SELECT u FROM Flat u WHERE u.number=:flatNumber AND u.password=:password";
	TypedQuery<Flat> query = em.createQuery(validateQuery, Flat.class);
	query.setParameter("flatNumber", flatNumber);
	query.setParameter("password", getHashedPassword(password));
	return queryUser(query) != null;
    }

    private Flat queryUser(TypedQuery<Flat> query) {
	try {
	    return query.getSingleResult();
	} catch (Exception e) {
	    return null;
	}
    }

    private String getHashedPassword(String password) {
	try {
	    MessageDigest mda = MessageDigest.getInstance("SHA-512");
	    password = new String(mda.digest(password.getBytes()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return password;
    }
}