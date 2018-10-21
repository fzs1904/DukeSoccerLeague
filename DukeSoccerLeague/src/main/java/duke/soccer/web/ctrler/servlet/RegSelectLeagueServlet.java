package duke.soccer.web.ctrler.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import duke.soccer.model.League;
import duke.soccer.service.RegisterService;
import duke.soccer.service.exception.ObjectNotFoundException;

/**
 * Servlet implementation class RegSelectLeagueServlet
 */
public class RegSelectLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // Keep a set of strings to record form processing errors.
        List errorMsgs = new LinkedList();
        // Store this set in the request scope, in case we need to
        // send the ErrorPage view.
        request.setAttribute("errorMsgs", errorMsgs);
        
        // Retrieve form parameters.
        String season = request.getParameter("season").trim();
        String yearStr = request.getParameter("year").trim();
        
        // Perform data conversions.
        int year = -1;
        try {
            year = Integer.parseInt(yearStr);
        } catch (NumberFormatException nfe) {
            errorMsgs.add("The 'year' field must be a positive integer.");
        }
        
        // Verify 'Select League' form fields
        if ( (year != -1) && ((year < 2000) || (year > 2010)) ) {
            errorMsgs.add("The 'year' field must within 2000 to 2010.");
        }
        if ( season.equals("UNKNOWN") ) {
            errorMsgs.add("Please select a league season.");
        }
        
        String path;
        if ( ! errorMsgs.isEmpty() ) {
        	// Send the ErrorPage view if there were errors
        	path = "/jsp/reg_select_league.jsp";
        }else{
            // Perform business logic
            ServletContext ctx = this.getServletContext();            
            RegisterService registerSvc = (RegisterService)ctx.getAttribute("registerSvc");
                        
			try {
				// Retrieve the league
				League league = registerSvc.getLeague(year, season);
	            
	            // Store the league object in the session-scope
				HttpSession session = request.getSession();
	            session.setAttribute("league", league);
	            
	            // Send the Success view
	            path = "/jsp/reg_enter_player.jsp";
			} catch (ObjectNotFoundException e) {
				// TODO Auto-generated catch block
	            errorMsgs.add("The league you selected does not yet exist.");
	            path = "/jsp/reg_select_league.jsp";
			}        	
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);        
        		
	}

}
