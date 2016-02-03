package dao;

import java.util.Calendar;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import model.Flat;
import model.Payment;
import model.PaymentPK;
import model.PaymentStatus;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class PaymentDAO {

    private static final Logger LOG = Logger.getLogger(PaymentDAO.class);

    private EntityManager entityManager;

    public PaymentDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param flatNumber
     * @param obligationId
     */
    public void updatePayment(int flatNumber, int obligationId) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    PaymentPK paymentId = new PaymentPK();
	    paymentId.setFlatNumber(flatNumber);
	    paymentId.setObligationId(obligationId);

	    Payment payment = entityManager.find(Payment.class, paymentId);
	    payment.setPaymentDate();
	    payment.setPaymentStatus(PaymentStatus.PAID);

	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for payment by flat (" + flatNumber + ") Performing rollback.");
	    }
	}
    }

    /**
     * @param flatNumber
     * @return
     */
    public Vector<Payment> getPaymentsByNumber(int flatNumber) {
	Flat flat = entityManager.find(Flat.class, flatNumber);
	String paymentFilterQuery = "SELECT u FROM Payment u WHERE u.flat=:flat";

	TypedQuery<Payment> paymentFilter = entityManager.createQuery(paymentFilterQuery, Payment.class);
	paymentFilter.setParameter("flat", flat);

	return (Vector<Payment>) paymentFilter.getResultList();
    }

    /**
     * @return
     */
    public Vector<Payment> getAllObligations() {
	Query paymentFilter = entityManager.createQuery("SELECT e " + "FROM Payment e");

	@SuppressWarnings("unchecked")
	Vector<Payment> obligations = (Vector<Payment>) paymentFilter.getResultList();

	return obligations;
    }
}