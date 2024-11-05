
public class BrancheBeanModele {
	private int id;
	private String nom;
	private int id_appareil;
	public BrancheBeanModele() {
		super();
	}
	public BrancheBeanModele(int id, String nom, int id_appareil) {
		super();
		this.id = id;
		this.nom = nom;
		this.id_appareil = id_appareil;
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
	public int getId_appareil() {
		return id_appareil;
	}
	public void setId_appareil(int id_appareil) {
		this.id_appareil = id_appareil;
	}
	@Override
	public String toString() {
		return "BrancheBeanModele [id=" + id + ", nom=" + nom + ", id_appareil=" + id_appareil + "]";
	}

	
	
	
}
