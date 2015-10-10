package utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private static final String PERSISTENCE_UNIT = "domoic-persistence-unit";

    public static EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }
}