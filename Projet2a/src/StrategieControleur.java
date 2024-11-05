

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StrategieControleur
 */
@WebServlet("/StrategieControleur")
public class StrategieControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StrategieControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BrancheDAOModele brancheDAOModele = new BrancheDAOModele();
		List<BrancheBeanModele> brancheListe = brancheDAOModele.lireListe();

		request.setAttribute("brancheListe", brancheListe);
		
		AppareilDAOModele appareilDAOModele = new AppareilDAOModele();
		List<AppareilBeanModele> appareilListe = appareilDAOModele.lireListe();
		
		for (BrancheBeanModele brancheBeanModele : brancheListe) {
			appareilListe.add(appareilDAOModele.lire(brancheBeanModele.getId_appareil()));
			System.out.println("IDappareil EST" + brancheBeanModele.getId_appareil());
		}
		
		request.setAttribute("appareilListe", appareilListe);
		
		DisponibiliteDAOModele disponibiliteDAOModele = new DisponibiliteDAOModele();
		List<DisponibiliteBeanModele> disponibiliteListe = disponibiliteDAOModele.lireListe();
		
		request.setAttribute("disponibiliteListe", disponibiliteListe);

		request.getRequestDispatcher("/StrategieVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
