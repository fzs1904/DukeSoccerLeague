package duke.soccer.web.ctrler.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.geronimo.mail.util.Encoder;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import duke.soccer.model.League;
import duke.soccer.model.Player;
import duke.soccer.service.LeagueService;
import duke.soccer.service.PlayerService;
import duke.soccer.service.RegisterService;

@Controller
public class RegisterController {
	private League league;
	private Player player;
	private String division;
	List<String>errorMsgs=new ArrayList<String>();
	@Autowired
	private List seasons_list;
	@Autowired
	private LeagueService leagueService;
	
	@Autowired
	private PlayerService playerService;
	@Autowired
	private RegisterService registerService;
	@RequestMapping(value="/reg_entry", method=RequestMethod.GET)
	public String preEntry(Model models)	
	{
		models.addAttribute("seasons_list",seasons_list);
		return "reg_select_league";	
	}
	@RequestMapping(value="/reg_entry", method=RequestMethod.POST)
	public String postEntry(Model models)	
	{
		models.addAttribute("seasons_list",seasons_list);
		return "reg_select_league";	
	}
	@RequestMapping(value="/reg_select_league",method=RequestMethod.POST)
	public String selectLeague(Model models,
			@RequestParam int year,
			@RequestParam String season)	
	{
		errorMsgs.clear();
		try {
			league = leagueService.getLeague(year, season);
			return "reg_enter_player";
		} catch (Exception e) {
			errorMsgs.add("league not find");
			models.addAttribute("errorMsgs",errorMsgs);
			models.addAttribute("seasons_list",seasons_list);
			return "reg_select_league";
		}
		
	}
	@RequestMapping(value="/reg_enter_player",method=RequestMethod.POST)
	public String enterPlayer(Model models,
			@RequestParam String name,
			@RequestParam String address,
			@RequestParam String city,
			@RequestParam String province,
			@RequestParam String postalCode)	
	{
		errorMsgs.clear();
		try {
			player = new Player(name, address, city, province, postalCode);
			Player validatePlayer = registerService.getPlayer(name);
			if(validatePlayer==null)
			{
				throw new Exception("Player is exist");				
			}
			playerService.save(player);
			return "reg_select_division";
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			models.addAttribute("errorMsgs",errorMsgs);
			return "reg_enter_player";
		}
		
	}
	@RequestMapping(value="/reg_select_division",method=RequestMethod.POST)
	public String selectDivision(Model models,			
			@RequestParam String division)	
	{
		errorMsgs.clear();
		try {
			registerService.register(league, player, division);
			models.addAttribute("league", league);
			models.addAttribute("player",player);
			return "reg_thank_you";
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			models.addAttribute("errorMsgs",errorMsgs);
			return "reg_select_division";
		}
		
	}
	
}
