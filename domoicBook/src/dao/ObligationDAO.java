package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Flat;
import model.Obligation;
import model.Payment;
public class ObligationDAO {
    private EntityManager em;

    public ObligationDAO(EntityManager em) {
        this.em = em;
    }
    
    public void addObligation(Obligation newObligation) {
        try {
            em.getTransaction().begin();
            em.persist(newObligation);
           setObligationToAll(newObligation);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
}
    
    @SuppressWarnings("unchecked")
	public void setObligationToAll(Obligation obligation){
    	Query query = em.createQuery( "SELECT e " + "FROM Flat e");
		  List<Flat>list=query.getResultList();
		  for(Flat fl:list){
			  Payment pay= new Payment();
			  pay.setFlat(fl);
			  pay.setObligation(obligation);
			  em.persist(pay);
		  }
    }
}