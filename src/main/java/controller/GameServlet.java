package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/gameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
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
		GameHelper help = new GameHelper();
		String action = request.getParameter("doThisToItem");
		String path = "/viewAllTeamsServlet";
		if (action.equals("Delete")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("game"));
				help.deleteGame(id);
			} catch (NullPointerException ex) {
				request.setAttribute("result", "Error: " + ex.getMessage());
				path = "/index.html";
			}	
		} else if (action.equals("Add a Team")) {
			path = "/index.jsp";		
		} else if (action.equals("Add a Game")) {
			path = "/addGameServlet";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
