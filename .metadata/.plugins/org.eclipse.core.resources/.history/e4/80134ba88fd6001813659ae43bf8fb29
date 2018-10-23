package duke.soccer.dao.impl;

import java.util.List;

import duke.soccer.dao.LeagueDao;
import duke.soccer.model.League;
import duke.soccer.utils.JpaUtils;

public class LeagueDaoImpl implements LeagueDao{

	public League create(League league) {
			JpaUtils.getEntityManager().persist(league);
		return league;
	}

	public List<League> findAll() {
		List<League> leagues = 
		 JpaUtils.getEntityManager().
		createQuery("from League l").getResultList();
		//createNativeQuery("select * from League l",League.class).getResultList();
		//auto commit	
		return leagues;
	}
	
	public League get(int id) {
		return JpaUtils.getEntityManager().find(League.class, id);
	}
	
	public League findByYearAndSeason(int year, String season) {
		League league
		= JpaUtils.getEntityManager()
		  .createQuery("select l from League l where l.year = :inputYear and "
		  +" l.season = :inputSeason",League.class)
		  .setParameter("inputYear", year)
		  .setParameter("inputSeason", season).getResultList().get(0);
		return league;
	}

	public void deleteAll() {

		JpaUtils.getEntityManager().createQuery("delete from League l").executeUpdate();
	}

	public void updateByYear(int year) {

		JpaUtils.getEntityManager().createQuery("update League l set l.year=:inputYear")
		.setParameter("inputYear", year).executeUpdate();

	}
	

}
