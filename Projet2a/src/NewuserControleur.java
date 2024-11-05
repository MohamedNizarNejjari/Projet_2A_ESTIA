

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewuserControleur
 */
@WebServlet("/NewuserControleur")
public class NewuserControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewuserControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilisateurDAOModele utilisateurDAOModele = new UtilisateurDAOModele();
		List<UtilisateurBeanModele> utilisateurListe = utilisateurDAOModele.lireListe();
		request.setAttribute("utilisateurListe", utilisateurListe);
		request.getRequestDispatcher("/Newuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String fonction = request.getParameter("fonction");
		String password = request.getParameter("password");
		
		UtilisateurBeanModele utilisateur = new UtilisateurBeanModele();
		
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setFonction(fonction);
		utilisateur.setPassword(password);
		
		UtilisateurDAOModele utilisateurDAOModele = new UtilisateurDAOModele();
		utilisateurDAOModele.creer(utilisateur);
		
		
		doGet(request, response);
	}

}
