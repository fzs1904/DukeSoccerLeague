package duke.soccer.dao.impl;

import duke.soccer.dao.RegisterDao;
import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.model.Register;
import duke.soccer.utils.JpaUtils;

public class RegisterDaoImpl implements RegisterDao{

	public void register(League league, Player player, String division) {
		Register register = new Register(league,player,division);
		JpaUtils.getEntityManager().persist(register);
	}

	public void deleteAll() {
		JpaUtils.getEntityManager().createQuery("delete from Register r")
		.executeUpdate();
	}

}
