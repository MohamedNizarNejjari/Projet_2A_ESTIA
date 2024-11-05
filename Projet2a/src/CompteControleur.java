

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CompteControleur
 */
@WebServlet("/CompteControleur")
public class CompteControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean login_State = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (login_State == false){
		request.getRequestDispatcher("/CompteVue.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/DisponibiliteVue.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String password = request.getParameter("password");	
		UtilisateurDAOModele utilisateurDAOModele = new UtilisateurDAOModele();
		try {
			if (password.equals(utilisateurDAOModele.getPsw(nom))) { 
				System.out.println("connecté");
				login_State = true;
			}
			else { 
				System.out.println("Votre identitiant ou mot de passe est incorrect!");
				login_State = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//login_State = login(firstname,password);
		//login_State = true;
		doGet(request, response);
	}
	
	protected boolean login(String nom, String password){
		UtilisateurDAOModele utilisateurDAOModele = new UtilisateurDAOModele();
		try {
			if (password.equals(utilisateurDAOModele.getPsw(nom))) {
				System.out.println("connecté");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connecté");
		return false;	
	}

}
