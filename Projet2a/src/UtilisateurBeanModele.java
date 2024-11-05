
public class UtilisateurBeanModele {
	
	private int id;
	private String nom;
	private String prenom;
	private String fonction;
	private String password;
	
	public UtilisateurBeanModele() {
		super();
	}
	
	public UtilisateurBeanModele(int id, String nom, String prenom, String fonction, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "UtilisateurBeanModele [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", fonction="
				+ fonction + ", password=" + password + "]";
	}
	
	

}
