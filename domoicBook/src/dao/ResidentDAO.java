package dao;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import model.Flat;
import model.Resident;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class ResidentDAO {

    private static final Logger LOG = Logger.getLogger(ResidentDAO.class);

    private EntityManager entityManager;

    public ResidentDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param resident
     * @param flatNumber
     */
    public void addResident(Resident resident, int flatNumber) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    Flat flat = entityManager.find(Flat.class, flatNumber);
	    resident.setFlat(flat);

	    entityManager.persist(resident);
	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for resident in flat (" + flatNumber + ") Performing rollback.");
	    }
	}
    }

    /**
     * @param resident
     */
    public void removeResident(Resident resident) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    entityManager.remove(resident);
	    LOG.warn("Transaction failed for person in flat (" + resident.getFirstName() + " " + resident.getLastName()
		    + ") Performing rollback.");

	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
	    }
	}
    }
}