package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjoutUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_LIST = "/WEB-INF/ajouterUtilisateur.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(VUE_LIST).forward(request, response);
	}
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String lieuNaissance = request.getParameter("lieuNaissance");
        String dateNaissance = request.getParameter("dateNaissance");
        String telephone = request.getParameter("telephone");
        String image = "default.jpg"; // Ou vous pouvez gérer le téléchargement de fichier pour l'image
        String sexe = request.getParameter("sexe");
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateNaissance);
            date = new Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace(); // Gérer l'exception ou afficher un message d'erreur si la conversion échoue
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(prenom);
        utilisateur.setNom(nom);
        utilisateur.setLogin(login);
        utilisateur.setPassword(password);
        utilisateur.setMail(mail);
        utilisateur.setLieuNaissance(lieuNaissance);
        utilisateur.setDateNaissance(date);
        utilisateur.setTelephone(telephone);
        utilisateur.setImage(image);
        utilisateur.setSexe(sexe);
        UtilisateurDao.addUser(utilisateur);
        response.sendRedirect("list");	
        }

}
