package utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * 
 * @authors Georgi Iliev, Vencislav Penev
 *
 */
public class EntityManagerProvider {

    private static final String PERSISTENCE_UNIT = "domoic-persistence-unit";

    private EntityManagerProvider() {
    }

    /**
     * @return
     */
    public static EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }
}