package dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import model.Flat;
import model.Obligation;
import model.Payment;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class ObligationDAO {

    private static final Logger LOG = Logger.getLogger(ObligationDAO.class);

    private EntityManager entityManager;

    public ObligationDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param newObligation
     */
    public void addObligation(Obligation newObligation) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    setObligationToAll(newObligation);

	    entityManager.persist(newObligation);
	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for obligation (" + newObligation.getDescription() + ") Performing rollback.");
	    }
	}
    }

    private void setObligationToAll(Obligation obligation) {
	Query flatFilter = entityManager.createQuery("SELECT e " + "FROM Flat e");

	@SuppressWarnings("unchecked")
	List<Flat> flats = flatFilter.getResultList();

	for (Flat flat : flats) {
	    Payment payment = new Payment();
	    payment.setFlat(flat);
	    payment.setObligation(obligation);
	    entityManager.persist(payment);
	}
    }
}