package duke.soccer.service;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.io.IOException;

import duke.soccer.dao.LeagueDao;
import duke.soccer.dao.PlayerDao;
import duke.soccer.dao.impl.LeagueDaoImpl;
import duke.soccer.dao.impl.PlayerDaoImpl;
import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.utils.JpaUtils;

/**
 * This object performs a variety of player services, such as looking
 * up player objects and creating new ones.
 *
 * Note: This implementation uses flat-files to maintain player records.
 * This is inefficient and has several bugs.  A better data persistence
 * mechanism is to use a database.  See the code examples in the database
 * module.
 */
public class PlayerService {

    
    PlayerDao playerDao;
	
    public PlayerService() {
    	playerDao = new PlayerDaoImpl();
	}


    public Player getPlayer(String name) {
        
    	JpaUtils.getEntityManager().getTransaction().begin();
    	Player player = playerDao.get(name);
    	JpaUtils.getEntityManager().getTransaction().commit();
    	return player;
    }
    
    /**
     * This method adds a new Player object.
     */
    public void save(Player player) {
    	JpaUtils.getEntityManager().getTransaction().begin();
    	playerDao.create(player);
    	JpaUtils.getEntityManager().getTransaction().commit();
    }
    
    
}
