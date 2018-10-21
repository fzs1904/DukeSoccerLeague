package dao;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import duke.soccer.dao.PlayerDao;
import duke.soccer.dao.impl.PlayerDaoImpl;
import duke.soccer.model.Player;
import duke.soccer.utils.JpaUtils;

public class PlayerDaoTest {
	PlayerDao playerDao = new PlayerDaoImpl();
	@Before
	public void setup() {
		System.out.println("setup");
	EntityManager em = JpaUtils.getEntityManager();
	em.getTransaction().begin();
	}
	@After
	public void tearDown() {
		System.out.println("tearDown");
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().rollback();
	}
	@Test
	public void testCreatePlayer() {
		System.out.println("testCreatePlayer");
		Player player= new Player("Robin","address","city","province","postalCode");
		playerDao.create(player);
	}
	@Test
	public void testGetPlayer() {
		System.out.println("testGetPlayer");
		Player player= new Player("Robin","address","city","province","postalCode");
		playerDao.create(player);
		player = playerDao.get("Robin");
		System.out.println("*********");
		System.out.println(player.getName());
		}
}
