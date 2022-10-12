package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamHelper help = new TeamHelper();
		String action = request.getParameter("doThisToItem");
		String path = "/viewAllTeamsServlet";
		if (action.equals("Delete") ) {
			try {
				Integer id = Integer.parseInt(request.getParameter("team"));
				help.deleteTeam(help.searchForTeamById(id));
			} catch (NullPointerException ex) {
				request.setAttribute("result", "Error: " + ex.getMessage());
			}
			
		} else if (action.equals("Edit")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("team"));
				request.setAttribute("teamToEdit", help.searchForTeamById(id));
				path = "/editTeam.jsp";
			} catch (NullPointerException ex) {
				request.setAttribute("result", "Error: " + ex.getMessage());
			}
		} else if (action.equals("Add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
