package duke.soccer.dao;

import duke.soccer.model.Player;

public interface PlayerDao {
	//CRUD
	//create
	Player create(Player player);
	//find all
	//find one == find by pk
	Player get(String name);
	//update
	//delete
}
