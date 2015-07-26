package dao;

import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Answer;
import model.Discussion;
import model.Flat;

public class AnswerDAO {
    private EntityManager em;

    public AnswerDAO(EntityManager em) {
        this.em = em;
    }
    
 public boolean addAnswer(Answer answer,int discussID,int flatNumber) {
    try {
            em.getTransaction().begin();
           if(isAlreadyCommentedByThisFlat(discussID,flatNumber))  return false;
            Flat flat=em.find(Flat.class,flatNumber);
            Discussion discuss=em.find(Discussion.class,discussID);    
            answer.setFlat(flat);
            answer.setDiscussion(discuss);
            answer.setDate();
            em.persist(answer);
            em.getTransaction().commit();
             return true;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    
    public boolean isAlreadyCommentedByThisFlat(int discussID,int flatNumber){
    	Flat flat=em.find(Flat.class, flatNumber);
    	Discussion discussion=em.find(Discussion.class, discussID);
        String query = "SELECT u FROM Answer u WHERE u.discussion=:discussion AND u.flat=:flat";
           TypedQuery<Answer>getQuery = em.createQuery(query, Answer.class);
          getQuery.setParameter("discussion",discussion);
           getQuery.setParameter("flat",flat);
           return queryAnswer(getQuery) != null;
      }
    
    
    private Answer queryAnswer(TypedQuery<Answer> query) {
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public Vector<Answer> getInfoAboutDiscuss(int discussId) {
    	Discussion discussion=em.find(Discussion.class, discussId);
        String query = "SELECT u FROM Answer u WHERE u.discussion=:discussion";
        TypedQuery<Answer>getQuery = em.createQuery(query, Answer.class);
        getQuery.setParameter("discussion",discussion);
        return (Vector<Answer>)getQuery.getResultList();
    }

    
}