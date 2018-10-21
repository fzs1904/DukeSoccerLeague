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
import duke.soccer.model.Player;
import duke.soccer.service.RegisterService;
import duke.soccer.service.exception.ObjectNotFoundException;

/**
 * Servlet implementation class RegSelectLeagueServlet
 */
public class RegSelectDivisionServlet extends HttpServlet {
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
        String division = request.getParameter("division").trim();
        
        // Verify 'Select Division' form fields
        if ( division.equals("UNKNOWN") ) {
            errorMsgs.add("You must select a division.");
        }
        
        String path;
        if ( ! errorMsgs.isEmpty() ) {
        	// Send the ErrorPage view if there were errors
        	path = "/jsp/reg_select_division.jsp";
        }else{
            // Perform business logic
            ServletContext ctx = this.getServletContext();            
            RegisterService registerSvc = (RegisterService)ctx.getAttribute("registerSvc");
                        
			try {
	            // Retrieve the league and player objects from the session-scope
	            HttpSession session = request.getSession();
	            League league = (League) session.getAttribute("league");
	            Player player = (Player) session.getAttribute("player");				
				
	            // Perform the registration
	            registerSvc.register(league, player, division);
	            
	            // Send the Success view
	            path = "/jsp/reg_enter_player.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
	            errorMsgs.add(e.getMessage());
	            path = "/jsp/reg_select_division.jsp";
			}        	
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);        
        		
	}

}
