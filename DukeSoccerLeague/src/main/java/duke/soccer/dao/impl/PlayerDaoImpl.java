package duke.soccer.dao.impl;

import org.springframework.stereotype.Repository;

import duke.soccer.dao.PlayerDao;
import duke.soccer.model.Player;
import duke.soccer.utils.JpaUtils;
@Repository
public class PlayerDaoImpl implements PlayerDao{
	//CRUD
	//create

	public Player create(Player player) {
		JpaUtils.getEntityManager().persist(player);
		return player;
	}	
	//find all
	//find one == find by pk
	public Player get(String name) {
		Player player = JpaUtils.getEntityManager().find(Player.class,name);
	return player;
	}
	//update
	//delete

}
