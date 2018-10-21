package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import duke.soccer.dao.LeagueDao;
import duke.soccer.dao.PlayerDao;
import duke.soccer.dao.RegisterDao;
import duke.soccer.dao.impl.LeagueDaoImpl;
import duke.soccer.dao.impl.PlayerDaoImpl;
import duke.soccer.dao.impl.RegisterDaoImpl;
import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.utils.JpaUtils;

public class RegisterDaoTest {
	PlayerDao playerDao = new PlayerDaoImpl();
	LeagueDao leagueDao = new LeagueDaoImpl();

	RegisterDao registerDao = new RegisterDaoImpl();

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

		em.getTransaction().commit();
	}
	@Test
	public void testRegister() {
		System.out.println("testRegister");
		Player player= new Player("Robin","address","city","province","postalCode");
		League league = new League(2020,"Autumn","Code");
		String division = "A";
		playerDao.create(player);
		leagueDao.create(league);
		player = playerDao.get("Rpbin");
		league = leagueDao.findAll().get(0);
		registerDao.register(league, player, division);		
	}
	@Test
	public void deleteRegister() {
		registerDao.deleteAll();
	}
}
