package duke.soccer.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.eclipse.persistence.annotations.PrivateOwned;
import org.eclipse.persistence.platform.database.SQLAnywherePlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import duke.soccer.dao.LeagueDao;
import duke.soccer.model.League;
import duke.soccer.utils.JpaUtils;
@Repository
public class LeagueDaoImpl implements LeagueDao{
	@Autowired
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	public List<League> findAllByJdbc() throws Exception{
		String sql = "select * from league";
		jdbcTemplate = new JdbcTemplate(datasource);
		List<League> rows =jdbcTemplate.query(sql,new LeagueRowMapper());
		
		return rows;
	}
	public League createJdbc(int year, String season, String title) {
		String sql="insert into League(year,season,title) values(?,?,?)";
		jdbcTemplate.update(sql,year,season,title);
		League league = new League(year, season, title);
	    return league;
   }	

	public League get(int id) {
		return JpaUtils.getEntityManager().find(League.class, id);
	
	}
	
	public League findByYearAndSeason(int year, String season) throws Exception{
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
