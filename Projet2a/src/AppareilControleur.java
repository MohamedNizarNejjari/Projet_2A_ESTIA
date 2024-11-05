

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AppareilControleur
 */
@WebServlet("/AppareilControleur")
public class AppareilControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppareilControleur() {
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
		
		BrancheDAOModele brancheDAOModele = new BrancheDAOModele();
		List<BrancheBeanModele> brancheListe = brancheDAOModele.lireListe();
		request.setAttribute("brancheListe", brancheListe);
		
		request.getRequestDispatcher("/AppareilVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		int nombre = Integer.parseInt(request.getParameter("nombre"));
		int puissance = Integer.parseInt(request.getParameter("puissance"));
		int niveaubatterie = Integer.parseInt(request.getParameter("niveaubatterie"));
		int dureeutilisation = Integer.parseInt(request.getParameter("dureeutilisation"));
		
		AppareilBeanModele appareil = new AppareilBeanModele();
		
		appareil.setNom(nom);
		appareil.setNombre(nombre);
		appareil.setPuissance(puissance);
		appareil.setNiveaubatterie(niveaubatterie);
		appareil.setDureeutilisation(dureeutilisation);
		
		AppareilDAOModele appareilDAOModele = new AppareilDAOModele();
		appareilDAOModele.creer(appareil);
		
		doGet(request, response);
	}

}
