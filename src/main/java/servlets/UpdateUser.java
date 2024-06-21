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
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int idUser;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 idUser = Integer.parseInt(request.getParameter("id"));
	     Utilisateur utilisateur = UtilisateurDao.findUser(idUser);
	     request.setAttribute("utilisateur", utilisateur);
        request.getRequestDispatcher("WEB-INF/modifierUtilisateur.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        String lieuNaissance = request.getParameter("lieuNaissance");
        String dateNaissance =request.getParameter("dateNaissance");
        String telephone = request.getParameter("telephone");
        String imageName= "default.jpg";
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
        utilisateur.setId(idUser);
        utilisateur.setPrenom(prenom);
        utilisateur.setNom(nom);
        utilisateur.setLogin(login);
        utilisateur.setPassword(password);
        utilisateur.setMail(mail);
        utilisateur.setLieuNaissance(lieuNaissance);
		utilisateur.setDateNaissance(date);
        utilisateur.setTelephone(telephone);
        utilisateur.setImage(imageName);
        utilisateur.setSexe(sexe);
        System.out.println(utilisateur.getNom()+utilisateur.getPrenom()+utilisateur.getLieuNaissance());
        UtilisateurDao.updateUser(utilisateur);
        response.sendRedirect("list");	
	}

}
