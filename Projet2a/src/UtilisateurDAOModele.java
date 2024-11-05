import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAOModele {

    // CRUD: create(obj)
    public int creer(UtilisateurBeanModele utilisateur) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        int resultat = -1;
        try {
            String requete = "INSERT INTO utilisateur (nom, prenom, fonction, password) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.setString(3, utilisateur.getFonction());
            statement.setString(4, utilisateur.getPassword());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                resultat = rs.getInt(1);
                utilisateur.setId(resultat);
            } else {
                resultat = -1;
            }

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
    
    public UtilisateurBeanModele lire(int id) throws SQLException {
    	ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

       UtilisateurBeanModele utilisateur = new UtilisateurBeanModele();

        try {
            String requete = "SELECT id, nom, prenom, fonction,"
            		+ " password FROM utilisateur where id = ?";
            PreparedStatement statement = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, utilisateur.getId());
            ResultSet rs = statement.executeQuery(requete);

            if (rs.next()) {
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setFonction(rs.getString("fonction"));
                utilisateur.setPassword(rs.getString("password"));

            }
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
        return utilisateur;
    	

       
    }

    // read all
    public List<UtilisateurBeanModele> lireListe() {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();

        List<UtilisateurBeanModele> utilisateurListe = new ArrayList<UtilisateurBeanModele>();

        try {
            String requete = "SELECT id, nom, prenom, fonction, password FROM utilisateur";
            Statement statement = connexion.createStatement();
            ResultSet rs = statement.executeQuery(requete);

            while (rs.next()) {
                UtilisateurBeanModele utilisateur = new UtilisateurBeanModele();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setFonction(rs.getString("fonction"));
                utilisateur.setPassword(rs.getString("password"));


                utilisateurListe.add(utilisateur);
            }
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
        System.out.println("oooook");
        return utilisateurListe;
    }

    // CRUD: update(obj)
    public int modifier(UtilisateurBeanModele utilisateur) {
        ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
        Connection connexion = connexionBDDModele.getConnexion();
        int resultat = -1;

        try {
            String requete = "UPDATE utilisateur SET nom=?, prenom=?, fonction=?, password=? WHERE id=?";
            PreparedStatement statement = connexion.prepareStatement(requete);

            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.setString(3, utilisateur.getPassword());
            statement.setString(4, utilisateur.getFonction());

            resultat = statement.executeUpdate();
        } catch (SQLException ex3) {
            while (ex3 != null) {
                System.out.println(ex3.getSQLState());
                System.out.println(ex3.getMessage());
                System.out.println(ex3.getErrorCode());
                ex3=ex3.getNextException();
            }
        } finally {
            connexionBDDModele.fermerConnexion();
        }
        return resultat;
    }
    
    public String getPsw(String nom) throws SQLException {
    	ConnexionBDDModele connexionBDDModele = new ConnexionBDDModele();
		Connection connexion = connexionBDDModele.getConnexion();
		 String mdp = null;
		
		try {
			String requete = new String("SELECT password from utilisateur WHERE nom=?;");
			PreparedStatement statement = connexion.prepareStatement(requete,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, nom);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				mdp = rs.getString("password");
			}
		}
		catch (SQLException ex3) {
			while (ex3 != null) {
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		finally {
			connexionBDDModele.fermerConnexion();
		}
		
		return mdp;
       
    }
    
}