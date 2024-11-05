
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class AppareilDAOModele {

	// CRUD: create(obj)
	public int creer(AppareilBeanModele appareil)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO appareil (nom, nombre, puissance, niveaubatterie, dureeutilisation) VALUES (?,?,?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, appareil.getNom());
			statement.setInt(2, appareil.getNombre());
			statement.setInt(3, appareil.getPuissance());
			statement.setInt(4, appareil.getNiveaubatterie());
			statement.setInt(5, appareil.getDureeutilisation());

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				appareil.setId(resultat);
			}
			else 
				resultat = -1;

		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return resultat;
	}
	
	
	// read all
	public List<AppareilBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<AppareilBeanModele> appareilListe = new ArrayList<AppareilBeanModele>();		

		try
		{
			String requete = new String("SELECT id, nom, nombre, puissance, niveaubatterie, dureeutilisation FROM appareil;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				AppareilBeanModele appareil = new AppareilBeanModele();
				appareil.setId(rs.getInt("id"));
				appareil.setNom(rs.getString("nom"));
				appareil.setNombre(rs.getInt("nombre"));
				appareil.setPuissance(rs.getInt("puissance"));
				appareil.setNiveaubatterie(rs.getInt("niveaubatterie"));
				appareil.setDureeutilisation(rs.getInt("dureeutilisation"));

				appareilListe.add(appareil);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally 
		{
			connexionBDDModele.fermerConnexion();
		}
		return appareilListe;
	}
	
	// CRUD: obj = read(id)
	public  AppareilBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		AppareilBeanModele appareil = new AppareilBeanModele();
		try
		{
			String requete = new String("SELECT id, nom, nombre, puissance, niveaubatterie, dureeutilisation FROM appareil WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if ( rs.next() )
			{
				appareil = new AppareilBeanModele();
				appareil.setId(id);
				appareil.setNom(rs.getString("nom"));
				appareil.setNombre(rs.getInt("nombre"));
				appareil.setPuissance(rs.getInt("puissance"));
				appareil.setNiveaubatterie(rs.getInt("niveaubatterie"));
				appareil.setDureeutilisation(rs.getInt("dureeutilisation"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		return appareil;
	}
	
	public  int lireIdByNom(String nom)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		int resultat = -1;

		AppareilBeanModele appareil = new AppareilBeanModele();
		try
		{
			String requete = new String("SELECT id FROM appareil WHERE nom = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);

			statement.setString(1, nom);
			ResultSet rs = statement.executeQuery();

			if ( rs.next() )
			{
				appareil = new AppareilBeanModele();
				appareil.setId(rs.getInt("id"));
				resultat = rs.getInt("id");
				
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		return resultat;
	}
	
	
    public int deleteByNom(String nom) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        int resultat = -1;
        try {
            String requete = "DELETE FROM appareil WHERE nom = ?;";
            PreparedStatement statement = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, nom);
                            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                resultat = rs.getInt(1);         
            } else
                resultat = -1;

        } catch (SQLException ex3) {
            while (ex3 != null) {
                System.out.println(ex3.getSQLState());
                System.out.println(ex3.getMessage());
                System.out.println(ex3.getErrorCode());
                ex3 = ex3.getNextException();
            }
        } finally {
            connexionBDDModele.fermerConnexion();
        }
        return resultat;
    }
}
