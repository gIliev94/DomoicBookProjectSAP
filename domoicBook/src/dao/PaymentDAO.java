package dao;

import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Flat;
import model.Payment;
import model.PaymentPK;
import model.paymentStatus;

public class PaymentDAO {
    private EntityManager em;

    public PaymentDAO(EntityManager em) {
	this.em = em;
    }

    public void UpdatePayment(int flatNumber, int obligationId) {
	try {
	    em.getTransaction().begin();
	    PaymentPK key = new PaymentPK();
	    key.setFlatNumber(flatNumber);
	    key.setObligationId(obligationId);

	    Payment payment = em.find(Payment.class, key);
	    payment.setPaymentDate();
	    payment.setPaymentStatus(paymentStatus.PAID);
	    em.getTransaction().commit();
	} finally {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    }

    public Vector<Payment> getPaymentsByNumber(int flatNumber) {
	Flat flat = em.find(Flat.class, flatNumber);
	String query = "SELECT u FROM Payment u WHERE u.flat=:flat";
	TypedQuery<Payment> getQuery = em.createQuery(query, Payment.class);
	getQuery.setParameter("flat", flat);
	return (Vector<Payment>) getQuery.getResultList();
    }

    @SuppressWarnings("unchecked")
    public Vector<Payment> getAllObligations() {
	Query query = em.createQuery("SELECT e " + "FROM Payment e");
	return (Vector<Payment>) query.getResultList();
    }
}