package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import duke.soccer.dao.LeagueDao;
import duke.soccer.dao.impl.LeagueDaoImpl;
import duke.soccer.model.League;
import duke.soccer.utils.JpaUtils;

public class LeagueDaoTest {
	LeagueDao leagueDao = new LeagueDaoImpl();

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
	public void testCreateLeague() throws Exception {
		System.out.println("testCreateLeague");
		League league = new League(2018, "Winter", "Code A");
		leagueDao.createJdbc(2018, "Winter", "Code A");
	}

	@Test
	public void testGetAllLeagues() throws Exception {
		System.out.println("testGetAllLeagues");
		League league1 = new League(2018, "Winter", "Code A");
		League league2 = new League(2018, "Winter", "Code B");
		leagueDao.createJdbc(2018, "Winter", "Code A");
		leagueDao.createJdbc(2018, "Winter", "Code B");
		List<League> leagues = leagueDao.findAllByJdbc();
		System.out.println("*********");
		for (League league : leagues) {
			System.out.println(league.getId() + "." + "Year:" + league.getYear() + ", Season:" + league.getSeason()
					+ ", Title:" + league.getTitle());
		}
	}
	@Test
	public void getLeague() throws Exception {
		System.out.println("getLeague");
		leagueDao.createJdbc(2018, "Spring", "APP");
		List<League> leagues = leagueDao.findAllByJdbc();
		int id = leagues.get(0).getId();
		League output = leagueDao.get(id);
		System.out.println("Output Season:"+output.getSeason());

	}
	@Test
	public void getLeagueByYearAndSeason() throws Exception {
		System.out.println("getLeagueByYearAndSeason");
		leagueDao.createJdbc(2019,"Summer","Java Team");
		List<League> leagues = leagueDao.findAllByJdbc();
		int year = leagues.get(0).getYear();
		String season = leagues.get(0).getSeason();
		
		League output = leagueDao.findByYearAndSeason(year, season);
		System.out.println("result:"+output.getSeason());

	}
	@Test
	public void updateLeague() {
		System.out.println("updateLeague");
		leagueDao.createJdbc(2018, "Spring", "APP");
		int afterYear=2019;
		leagueDao.updateByYear(afterYear);

	}
	@Test
	public void deleteAllLeagues() {
		System.out.println("deleteAllLeagues");
		leagueDao.deleteAll();
	}
}