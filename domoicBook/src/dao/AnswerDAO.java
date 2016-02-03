package dao;

import java.util.Calendar;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import model.Answer;
import model.Discussion;
import model.Flat;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class AnswerDAO {

    private static final Logger LOG = Logger.getLogger(AnswerDAO.class);

    private EntityManager entityManager;

    public AnswerDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param newAnswer
     * @param discussId
     * @param flatNumber
     * @return
     */
    public boolean addAnswer(Answer newAnswer, int discussId, int flatNumber) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    if (isAlreadyAnsweredByThisFlat(discussId, flatNumber)) {
		return false;
	    }

	    Flat flat = entityManager.find(Flat.class, flatNumber);
	    Discussion discussion = entityManager.find(Discussion.class, discussId);
	    newAnswer.setFlat(flat);
	    newAnswer.setDiscussion(discussion);
	    newAnswer.setDate();

	    entityManager.persist(newAnswer);
	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());

	    return true;
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for answer by flat (" + newAnswer.getFlat().getNumber()
			+ ") Performing rollback.");
	    }
	}
    }

    private boolean isAlreadyAnsweredByThisFlat(int discussID, int flatNumber) {
	Flat flat = entityManager.find(Flat.class, flatNumber);
	Discussion discussion = entityManager.find(Discussion.class, discussID);
	String answerFilterQuery = "SELECT u FROM Answer u WHERE u.discussion=:discussion AND u.flat=:flat";

	TypedQuery<Answer> answerFilter = entityManager.createQuery(answerFilterQuery, Answer.class);
	answerFilter.setParameter("discussion", discussion);
	answerFilter.setParameter("flat", flat);

	return findAnswer(answerFilter) != null;
    }

    private Answer findAnswer(TypedQuery<Answer> answerFilter) {
	try {
	    return answerFilter.getSingleResult();
	} catch (Exception e) {
	    return null;
	}
    }

    /**
     * @param discussId
     * @return
     */
    public Vector<Answer> getInfoAboutDiscuss(int discussId) {
	Discussion discussion = entityManager.find(Discussion.class, discussId);
	String answerFilterQuerry = "SELECT u FROM Answer u WHERE u.discussion=:discussion";

	TypedQuery<Answer> answerFilter = entityManager.createQuery(answerFilterQuerry, Answer.class);
	answerFilter.setParameter("discussion", discussion);

	return (Vector<Answer>) answerFilter.getResultList();
    }
}