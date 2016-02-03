package dao;

import java.security.MessageDigest;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import model.Flat;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class FlatDAO {

    private static final Logger LOG = Logger.getLogger(FlatDAO.class);

    private EntityManager entityManager;

    public FlatDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param newflat
     */
    public void addFlat(Flat newflat) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    newflat.setPassword(getHashedPassword(newflat.getPassword()));

	    entityManager.persist(newflat);
	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for flat (" + newflat.getNumber() + ") Performing rollback.");
	    }
	}
    }

    /**
     * @param flatNumber
     * @param password
     * @return
     */
    public boolean validateFlat(int flatNumber, String password) {
	String validationQuery = "SELECT u FROM Flat u WHERE u.number=:flatNumber AND u.password=:password";

	TypedQuery<Flat> validatedFlatFilter = entityManager.createQuery(validationQuery, Flat.class);
	validatedFlatFilter.setParameter("flatNumber", flatNumber);
	validatedFlatFilter.setParameter("password", getHashedPassword(password));

	return findValidatedFlat(validatedFlatFilter) != null;
    }

    private Flat findValidatedFlat(TypedQuery<Flat> validatedFlatFilter) {
	try {
	    return validatedFlatFilter.getSingleResult();
	} catch (Exception e) {
	    return null;
	}
    }

    private String getHashedPassword(String password) {
	try {
	    MessageDigest decrypter = MessageDigest.getInstance("SHA-512");
	    password = new String(decrypter.digest(password.getBytes()));
	} catch (Exception e) {
	    LOG.error("ERROR: ", e);
	    throw new RuntimeException("ERROR: ", e);
	}

	return password;
    }
}