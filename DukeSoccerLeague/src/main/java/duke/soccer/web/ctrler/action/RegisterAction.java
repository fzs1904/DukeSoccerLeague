package duke.soccer.web.ctrler.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;
import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.service.LeagueService;
import duke.soccer.service.PlayerService;
import duke.soccer.service.RegisterService;

public class RegisterAction extends ActionSupport implements SessionAware{
	
	private League league;
	private Player player;
	private String division;
	Map<String, Object> session;
	ActionContext actCtx = ActionContext.getContext() ;
	Map<String, Object> application = actCtx.getApplication() ;
	LeagueService leagueSvc = (LeagueService) application.get("leagueSvc");
	PlayerService playerSvc = (PlayerService) application.get("playerSvc");
	RegisterService registerSvc = (RegisterService) application.get("registerSvc");

	public Map<String, Object> getSession() {
		return session;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String entry() {
		return nextView();
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}

	public String select_league() {

		System.out.println("league: "+ league);
		session.put("league", league);
		return nextView();
	}
	public String enter_player() {
		System.out.println("player: "+ player);
		session.put("player", player);
		return nextView();
	}
	public String select_division() {
		System.out.println("division: "+ division);
		session.put("division", division);
		return nextView();
	}
	public String getCurrentActionMethod() {
		ActionContext actCtx = ActionContext.getContext();
		ActionInvocation actInv = actCtx.getActionInvocation();
		ActionProxy actPxy = actInv.getProxy();
		String result = actPxy.getMethod();
		return result;
	}
	public String nextView() {
		String view = getCurrentActionMethod()+"_next";
		return view;
	}
}
