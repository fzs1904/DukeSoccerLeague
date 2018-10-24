package duke.soccer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duke.soccer.dao.PlayerDao;
import duke.soccer.dao.impl.PlayerDaoImpl;
import duke.soccer.model.Player;
import duke.soccer.utils.JpaUtils;

@Service
public class PlayerService {

	@Autowired
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
    public void save(Player player) throws Exception{
    	try {
    		JpaUtils.getEntityManager().getTransaction().begin();
        	playerDao.create(player);
        	JpaUtils.getEntityManager().getTransaction().commit();
        
		} catch (Exception e) {
			JpaUtils.getEntityManager().getTransaction().rollback();
			throw e;
		}
    	}
    
    
}
