package duke.soccer.web.ctrler.action;

import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import duke.soccer.service.LeagueService;

public class ListLeaguesAction extends ActionSupport{
	private LeagueService leagueSrv;
	public LeagueService getLeagueSrv() {
		return leagueSrv;
	}
	public void setLeagueSrv(LeagueService leagueSrv) {
		this.leagueSrv = leagueSrv;
	}
	private List leagueList ;
	public List getLeagueList() {
		return leagueList ;
	}
	public ListLeaguesAction() {
		System.out.println("in ListLeaguesAction");
	}
	@Override
	public String execute() throws Exception {
	System.out.println("in execute");
	//ActionContext actCtx = ActionContext.getContext();
	//Map<String, Object> application = actCtx.getApplication();
	//LeagueService leagueService = (LeagueService) application.get("leagueSvc");
	leagueList =leagueSrv.getAllLeagues();
	return SUCCESS;
	}

}
