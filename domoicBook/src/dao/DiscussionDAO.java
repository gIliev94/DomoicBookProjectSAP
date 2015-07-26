package dao;

import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Discussion;
public class DiscussionDAO {
    private EntityManager em;

    public DiscussionDAO(EntityManager em) {
        this.em = em;
    }
    
    public void addDiscussion(Discussion newDiscussion) {
        try {
            em.getTransaction().begin();
            newDiscussion.setDate();
            em.persist(newDiscussion);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
	public Vector<Discussion> showInfoAboutAllDiscussions(){
    	Query query = em.createQuery( "SELECT e " + "FROM Discussion e");
		  return (Vector<Discussion>)query.getResultList();
    }
}