package dao;

import javax.persistence.EntityManager;

import model.Flat;
import model.People;

public class PeopleDAO {
    private EntityManager em;

    public PeopleDAO(EntityManager em) {
	this.em = em;
    }

    public void addMember(People member, int flatNumber) {
	try {
	    em.getTransaction().begin();
	    Flat flat = em.find(Flat.class, flatNumber);
	    member.setFlat(flat);
	    em.persist(member);
	    em.getTransaction().commit();
	} finally {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    }

    public void removeMember(People member) {
	try {
	    em.getTransaction().begin();

	    em.remove(member);
	    em.getTransaction().commit();
	} finally {
	    if (em.getTransaction().isActive()) {
		em.getTransaction().rollback();
	    }
	}
    }

}