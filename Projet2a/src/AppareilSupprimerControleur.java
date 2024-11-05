

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppareilSupprimerControleur
 */
@WebServlet("/AppareilSupprimerControleur")
public class AppareilSupprimerControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppareilSupprimerControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AppareilDAOModele appareilDAOModele = new AppareilDAOModele();
		List<AppareilBeanModele> appareilListe = appareilDAOModele.lireListe();
		request.setAttribute("appareilListe", appareilListe);
		request.getRequestDispatcher("/AppareilVue.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AppareilDAOModele appareilDAOModele = new AppareilDAOModele();		
		
		String nom = request.getParameter("nom");
		appareilDAOModele.deleteByNom(nom);
		doGet(request, response);
	}

}
