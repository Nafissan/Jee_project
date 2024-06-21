package servlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListUser
 */
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_LIST = "/WEB-INF/listerUtilisateur.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Utilisateur> utilisateurs = UtilisateurDao.lister();
		System.out.print(utilisateurs.size());
		request.setAttribute("utilisateurs", utilisateurs);
		getServletContext().getRequestDispatcher(VUE_LIST).forward(request, response);
	}

}
