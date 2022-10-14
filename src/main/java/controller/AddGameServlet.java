package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;
import model.Team;

/**
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamHelper help = new TeamHelper();
		request.setAttribute("allTeams", help.showAllTeams());
		String path = "/add-game.jsp";
		if(help.showAllTeams().isEmpty()){
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Game game = new Game();
		Team home = new Team();
		Team away = new Team();
		GameHelper gHelp = new GameHelper();
		TeamHelper tHelp = new TeamHelper();
		try {
			home = tHelp.searchForTeamById(Integer.parseInt(request.getParameter("home")));
			away = tHelp.searchForTeamById(Integer.parseInt(request.getParameter("away")));
			game.setHome(home);
			game.setAway(away);
			game.setDate(LocalDate.parse(request.getParameter("date")));
			game.setTime(LocalTime.parse(request.getParameter("time")));
			gHelp.insertGame(game);
			getServletContext().getRequestDispatcher("/viewGamesServlet").forward(request, response);
			request.setAttribute("result", "Game added");
		} catch (NullPointerException ex) {
			request.setAttribute("result", "Error: Please select 2 Games.");
			getServletContext().getRequestDispatcher("/viewGamesServlet").forward(request, response);
		} catch (NumberFormatException ex) {
			doGet(request, response);
		}
	}

}
