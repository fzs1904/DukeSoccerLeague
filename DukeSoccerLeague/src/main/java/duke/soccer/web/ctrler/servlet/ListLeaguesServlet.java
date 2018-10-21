package duke.soccer.web.ctrler.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import duke.soccer.service.LeagueService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ListLeaguesServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request,
    				  HttpServletResponse response) throws IOException,ServletException {
        ServletContext ctx = this.getServletContext();     
        LeagueService leagueSvc = (LeagueService)ctx.getAttribute("leagueSvc");
        List leagueList = leagueSvc.getAllLeagues();     
        request.setAttribute("leagueList",leagueList);
        
        // Send the list view
        String path = "/jsp/list_leagues.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
    }
}
