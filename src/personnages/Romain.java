package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force){
		this.nom = nom;
		this.force = force;
		assert force > 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int forceFin = force;
		assert force > 0 : "La force est supérieure à 0";
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceFin > force : "La force à bien diminuer";
	}
	
	public static void main(String[] args) throws Exception {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
	}
}
