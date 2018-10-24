package duke.soccer.dao;

import java.util.List;

import duke.soccer.model.League;

public interface LeagueDao {
	List<League> findAllByJdbc() throws Exception;

	League createJdbc(int year, String season, String title);

    League get(int id);
	League findByYearAndSeason(int year, String season)throws Exception;
	void updateByYear(int year);
	void deleteAll();
}
