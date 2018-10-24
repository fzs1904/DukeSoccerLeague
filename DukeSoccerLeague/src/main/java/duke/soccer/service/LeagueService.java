package duke.soccer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duke.soccer.dao.LeagueDao;
import duke.soccer.dao.impl.LeagueDaoImpl;
import duke.soccer.model.League;
import duke.soccer.utils.JpaUtils;
@Service
public class LeagueService {
	@Autowired
	LeagueDao leagueDao;

	public LeagueService() {
		leagueDao = new LeagueDaoImpl();
	}

	public List<League> getAllLeagues() throws Exception {

		JpaUtils.getEntityManager().getTransaction().begin();
		List<League> leagues = leagueDao.findAllByJdbc();
		JpaUtils.getEntityManager().getTransaction().commit();
		return leagues;
	}

	public League getLeague(int year, String season) throws Exception {
		League league=null;
		try {
			JpaUtils.getEntityManager().getTransaction().begin();
			league = leagueDao.findByYearAndSeason(year, season);
			JpaUtils.getEntityManager().getTransaction().commit();
			
		} catch (Exception e) {
			JpaUtils.getEntityManager().getTransaction().rollback();

			throw e;
		}
			return league;
	}

	public League createLeague(int year, String season, String title) {
		League league = new League(year, season, title);
		
		
			JpaUtils.getEntityManager().getTransaction().begin();
			//leagueDao.create(league);
			leagueDao.createJdbc(year, season, title);
			JpaUtils.getEntityManager().getTransaction().commit();
		
		return league;
	}

}
