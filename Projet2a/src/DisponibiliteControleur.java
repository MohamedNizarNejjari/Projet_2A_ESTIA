

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisponibiliteControleur
 */
@WebServlet("/DisponibiliteControleur")
public class DisponibiliteControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisponibiliteControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DisponibiliteDAOModele disponibiliteDAOModele = new DisponibiliteDAOModele();
		List<DisponibiliteBeanModele> disponibiliteListe = disponibiliteDAOModele.lireListe();
		request.setAttribute("disponibiliteListe", disponibiliteListe);
		request.getRequestDispatcher("/DisponibiliteVue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		String jour = request.getParameter("jour");
		String hre = request.getParameter("hre");

		
		DisponibiliteBeanModele disponibilite = new DisponibiliteBeanModele();
		
		disponibilite.setDate(date);
		disponibilite.setJour(jour);
		disponibilite.setHre(hre);
		
		DisponibiliteDAOModele disponibiliteDAOModele = new DisponibiliteDAOModele();
		disponibiliteDAOModele.creer(disponibilite);
		
		doGet(request, response);
	}

}
