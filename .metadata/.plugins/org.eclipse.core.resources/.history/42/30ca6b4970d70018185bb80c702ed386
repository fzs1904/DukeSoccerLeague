package duke.soccer.web.ctrler.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import duke.soccer.model.League;
import duke.soccer.service.LeagueService;
@Controller
public class ListLeaguesController{
	@Autowired
	private LeagueService leagueSrv;
	@RequestMapping("list_leagues")
	public String showAll(Model model) 
	{
		List<League> leagueList = leagueSrv.getAllLeagues();
		model.addAttribute("leagueList",leagueList);
		return "list_leagues";
	}


}
