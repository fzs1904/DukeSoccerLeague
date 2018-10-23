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

import duke.soccer.model.Player;
import duke.soccer.service.RegisterService;
import duke.soccer.service.exception.ObjectNotFoundException;

/**
 * Servlet implementation class RegSelectLeagueServlet
 */
public class RegEnterPlayerServlet extends HttpServlet {
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
        // Retrieve form parameters.
        String name = request.getParameter("name").trim();
        String address = request.getParameter("address").trim();
        String city = request.getParameter("city").trim();
        String province = request.getParameter("province").trim();
        String postalCode = request.getParameter("postalCode").trim();
        
        // Verify 'Enter Player Information' form fields
        if ( name.length() == 0 ) {
            errorMsgs.add("You must enter your full name.");
        }
        if (   (address.length() == 0)  || (city.length() == 0)
        || (province.length() == 0) || (postalCode.length() == 0) ) {
            errorMsgs.add("You must enter your full address.");
        }
        
        String path;
        if ( ! errorMsgs.isEmpty() ) {
        	// Send the ErrorPage view if there were errors
        	path = "/jsp/reg_enter_player.jsp";
        }else{
            // Perform business logic
            ServletContext ctx = this.getServletContext();            
            RegisterService registerSvc = (RegisterService)ctx.getAttribute("registerSvc");
                        
			try {
	            // Update the player info
	            Player player = registerSvc.getPlayer(name);
	            player.setAddress(address);
	            player.setCity(city);
	            player.setProvince(province);
	            player.setPostalCode(postalCode);
	            
	            // Store the player object in the session-scope
	            HttpSession session = request.getSession();
	            session.setAttribute("player", player);
	            
	            // Send the Success view
	            path = "/jsp/reg_select_division.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
	            errorMsgs.add(e.getMessage());
	            path = "/jsp/reg_select_league.jsp";
			}        	
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);        
        		
	}

}
