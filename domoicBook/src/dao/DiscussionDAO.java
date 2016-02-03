package dao;

import java.util.Calendar;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import model.Discussion;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class DiscussionDAO {

    private static final Logger LOG = Logger.getLogger(DiscussionDAO.class);

    private EntityManager entityManager;

    public DiscussionDAO(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @param newDiscussion
     */
    public void addDiscussion(Discussion newDiscussion) {
	try {
	    entityManager.getTransaction().begin();
	    LOG.info("Begin transaction: " + Calendar.getInstance().getTime());

	    newDiscussion.setDate();

	    entityManager.persist(newDiscussion);
	    entityManager.getTransaction().commit();
	    LOG.info("Commit passed: " + Calendar.getInstance().getTime());
	} finally {
	    if (entityManager.getTransaction().isActive()) {
		entityManager.getTransaction().rollback();
		LOG.warn("Transaction failed for discussion (" + newDiscussion.getTitle() + ") Performing rollback.");
	    }
	}
    }

    /**
     * @return
     */
    public Vector<Discussion> showInfoAboutAllDiscussions() {
	Query discussionsFilter = entityManager.createQuery("SELECT e " + "FROM Discussion e");

	@SuppressWarnings("unchecked")
	Vector<Discussion> discussions = (Vector<Discussion>) discussionsFilter.getResultList();

	return discussions;
    }
}