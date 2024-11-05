
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrancheControleur
 */
@WebServlet("/BrancheControleur")
public class BrancheControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BrancheDAOModele brancheDAOModele = new BrancheDAOModele();
	private AppareilDAOModele appareilDAOModele = new AppareilDAOModele();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BrancheControleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		List<BrancheBeanModele> brancheListe = brancheDAOModele.lireListe();
		request.setAttribute("brancheListe", brancheListe);

		List<AppareilBeanModele> tousAppareilListe = appareilDAOModele.lireListe();
		List<AppareilBeanModele> appareilListe = new ArrayList<AppareilBeanModele>();

		for (BrancheBeanModele brancheBeanModele : brancheListe) {
			appareilListe.add(appareilDAOModele.lire(brancheBeanModele.getId_appareil()));
			System.out.println("IDappareil EST" + brancheBeanModele.getId_appareil());
		}

		 request.setAttribute("appareilListe", appareilListe);
		 request.setAttribute("tousAppareilListe", tousAppareilListe);
		 

		request.getRequestDispatcher("/BrancheVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AppareilDAOModele appareilDAOModele = new AppareilDAOModele();
		String nomAppareilBranche = request.getParameter("nomAppareilBranche");
		System.out.println(nomAppareilBranche + "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
		int id_appareil = appareilDAOModele.lireIdByNom(nomAppareilBranche);
		System.out.println( id_appareil + "TTTTTTTTTTTTTTTTTTTTTTTTT");
		BrancheBeanModele brancheBeanModele = new BrancheBeanModele();
		brancheBeanModele.setId(2);
		brancheBeanModele.setId_appareil(id_appareil);
		brancheBeanModele.setNom(nomAppareilBranche);
		brancheDAOModele.createByNomIdappareil(nomAppareilBranche, id_appareil);
		
		doGet(request, response);
	}

}