package duke.soccer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import duke.soccer.dao.RegisterDao;
import duke.soccer.dao.impl.RegisterDaoImpl;
import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.utils.JpaUtils;

@Service
public class RegisterService {
	@Autowired
   	private RegisterDao registerDao;
   	@Autowired
    private LeagueService leagueSrv;
   	@Autowired
    private PlayerService playerSrv;
    
    public RegisterService() {
    	registerDao = new RegisterDaoImpl();
    }
    

    public League getLeague(int year, String season)throws Exception {        
        return leagueSrv.getLeague(year, season);
    }
    

    public Player getPlayer(String name) {
        return playerSrv.getPlayer(name);
    }
    
    /**
     * This method stores the registration information for the player,
     * based on the league and division information.
     */
    public void register(League league, Player player, String division) throws Exception{
        try {
        playerSrv.save(player);
        JpaUtils.getEntityManager().getTransaction().begin();
        registerDao.register(league, player, division);
        JpaUtils.getEntityManager().getTransaction().commit();
        }
        catch(Exception e){
        	JpaUtils.getEntityManager().getTransaction().rollback();
        	throw e;
        }
        }


	public LeagueService getLeagueSrv() {
		return leagueSrv;
	}


	public void setLeagueSrv(LeagueService leagueSrv) {
		this.leagueSrv = leagueSrv;
	}


	public PlayerService getPlayerSrv() {
		return playerSrv;
	}


	public void setPlayerSrv(PlayerService playerSrv) {
		this.playerSrv = playerSrv;
	}
    


    
} // END of RegisterService class
