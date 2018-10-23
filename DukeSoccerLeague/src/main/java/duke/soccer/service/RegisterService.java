package duke.soccer.service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import duke.soccer.dao.RegisterDao;
import duke.soccer.dao.impl.RegisterDaoImpl;
import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.service.exception.ObjectNotFoundException;
import duke.soccer.utils.JpaUtils;


public class RegisterService {
   	private RegisterDao registerDao;
    private LeagueService leagueSrv;
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
