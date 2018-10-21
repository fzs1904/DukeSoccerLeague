package duke.soccer.dao;

import duke.soccer.model.League;
import duke.soccer.model.Player;

public interface RegisterDao {

	void register(League league,Player player,String division);
	void deleteAll();
}
