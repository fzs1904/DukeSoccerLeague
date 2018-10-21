package duke.soccer.web.ctrler.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import duke.soccer.model.League;
import duke.soccer.service.LeagueService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;


public class AddLeaguesServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
			  HttpServletResponse response) throws IOException,ServletException {
    	this.doGet(request, response);
    }
    public void doGet(HttpServletRequest request,
    				  HttpServletResponse response) throws IOException,ServletException {
        // Keep a set of strings to record form processing errors.
        List errorMsgs = new LinkedList();
        
        // Store this set in the request scope, in case we need to
        // send the ErrorPage view.
        request.setAttribute("errorMsgs", errorMsgs);
                   
        // Retrieve form parameters.
        String yearStr = request.getParameter("year").trim();
        String season = request.getParameter("season").trim();
        String title = request.getParameter("title").trim();
        
        // Perform data conversions.
        int year = -1;
        try {
            year = Integer.parseInt(yearStr);
        } catch (NumberFormatException nfe) {
            errorMsgs.add("The 'year' field must be a positive integer.");
        }
        
        // Verify form parameters
        if ( (year != -1) && ((year < 2000) || (year > 2010)) ) {
            errorMsgs.add("The 'year' field must within 2000 to 2010.");
        }
        if ( season.equals("UNKNOWN") ) {
            errorMsgs.add("Please select a league season.");
        }
        if ( title.length() == 0 ) {
            errorMsgs.add("Please enter the title of the league.");
        }
        
        String path;
        if ( ! errorMsgs.isEmpty() ) {
        	// Send the ErrorPage view if there were errors
        	path = "/jsp/add_league.jsp";
        }else{
        
            // Perform business logic
            ServletContext ctx = this.getServletContext();
            LeagueService leagueService = (LeagueService)ctx.getAttribute("leagueService");
            League league = leagueService.createLeague(year, season, title);
            // Store the new league in the request-scope
            request.setAttribute("league", league);
            path = "/jsp/success.jsp";
            // Send the Success view
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
    }
}
