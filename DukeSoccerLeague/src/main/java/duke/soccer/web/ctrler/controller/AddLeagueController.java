package duke.soccer.web.ctrler.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import duke.soccer.model.League;
import duke.soccer.service.LeagueService;


@Controller
public class AddLeagueController{
	@Autowired
	private List seasons_list;
	@Autowired
	private LeagueService leagueService;
	@RequestMapping("/add_league_form")
	public String input(Model models) {
		models.addAttribute("seasons_list",seasons_list);
		return "add_league";
	}
	
	@RequestMapping(value="/add_league", method=RequestMethod.POST)
	public String add(Model models,
			@RequestParam int year,
			@RequestParam String season,
			@RequestParam String title) 
	{
		League league=leagueService.createLeague(year, season, title);
		models.addAttribute("league",league);
		return "success";
	}

}