
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO pour CRUD (create, read, update, delete)
public class DisponibiliteDAOModele {

	// CRUD: create(obj)
	public int creer(DisponibiliteBeanModele disponibilite)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		int resultat = -1;
		try
		{

			String requete = new String("INSERT INTO disponibilite (date, jour, hre) VALUES (?,?,?);");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, disponibilite.getDate());
			statement.setString(2, disponibilite.getJour());
			statement.setString(3, disponibilite.getHre());


			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				resultat = rs.getInt(1);
				disponibilite.setId(resultat);
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
	public List<DisponibiliteBeanModele> lireListe()
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		List<DisponibiliteBeanModele> disponibiliteListe = new ArrayList<DisponibiliteBeanModele>();		

		try
		{
			String requete = new String("SELECT id, date, jour, hre FROM disponibilite;");
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				DisponibiliteBeanModele disponibilite = new DisponibiliteBeanModele();
				disponibilite.setId(rs.getInt("id"));
				disponibilite.setDate(rs.getString("date"));
				disponibilite.setJour(rs.getString("jour"));
				disponibilite.setHre(rs.getString("hre"));


				disponibiliteListe.add(disponibilite);
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
		return disponibiliteListe;
	}
	
	// CRUD: obj = read(id)
	public  DisponibiliteBeanModele lire(int id)
	{
		ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();

		DisponibiliteBeanModele disponibilite = new DisponibiliteBeanModele();
		try
		{
			String requete = new String("SELECT id, date, jour, hre FROM disponibilite WHERE id = ?;");
			PreparedStatement statement = connexion.prepareStatement(requete);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			if ( rs.next() )
			{
				disponibilite = new DisponibiliteBeanModele();
				disponibilite.setId(id);
				disponibilite.setDate(rs.getString("date"));
				disponibilite.setJour(rs.getString("jour"));
				disponibilite.setHre(rs.getString("hre"));

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
		return disponibilite;
	}
	
    public int deleteByNom(String nom) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        int resultat = -1;
        try {
            String requete = "DELETE FROM disponibilite WHERE nom = ?;";
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
