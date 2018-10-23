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
		leagueDao.create(league);
	}

	@Test
	public void testGetAllLeagues() throws Exception {
		System.out.println("testGetAllLeagues");
		League league1 = new League(2018, "Winter", "Code A");
		League league2 = new League(2018, "Winter", "Code B");
		leagueDao.create(league1);
		leagueDao.create(league2);
		List<League> leagues = leagueDao.findAll();
		System.out.println("*********");
		for (League league : leagues) {
			System.out.println(league.getId() + "." + "Year:" + league.getYear() + ", Season:" + league.getSeason()
					+ ", Title:" + league.getTitle());
		}
	}
	@Test
	public void getLeague() {
		System.out.println("getLeague");
		League input = new League(2018,"Spring","APP");
		leagueDao.create(input);
		List<League> leagues = leagueDao.findAll();
		int id = leagues.get(0).getId();
		League output = leagueDao.get(id);
		System.out.println("Output Season:"+output.getSeason());

	}
	@Test
	public void getLeagueByYearAndSeason() {
		System.out.println("getLeagueByYearAndSeason");
		League input = new League(2019,"Summer","Java Team");
		leagueDao.create(input);
		List<League> leagues = leagueDao.findAll();
		int year = leagues.get(0).getYear();
		String season = leagues.get(0).getSeason();
		
		League output = leagueDao.findByYearAndSeason(year, season);
		System.out.println("result:"+output.getSeason());

	}
	@Test
	public void updateLeague() {
		System.out.println("updateLeague");
		League input = new League(2018,"Spring","APP");
		leagueDao.create(input);
		int afterYear=2019;
		leagueDao.updateByYear(afterYear);

	}
	@Test
	public void deleteAllLeagues() {
		System.out.println("deleteAllLeagues");
		leagueDao.deleteAll();
	}
}