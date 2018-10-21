package duke.soccer.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {

	private static final EntityManager
	entityManager=buildEntityManager();
	
	private static EntityManager buildEntityManager() {
		try {
			return Persistence.createEntityManagerFactory("DukeSoccerLeague")
					.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}
	public static EntityManager getEntityManager() {
		return entityManager;
	}
}
