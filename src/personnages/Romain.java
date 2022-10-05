package personnages;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements = {null, null};
	private int nbEquipement = 0;
	
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
		int forceDebut = force;
		assert force > 0 : "La force est supérieure à 0";
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceDebut > force : "La force à bien diminuer";
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 0:
				if(equipements[nbEquipement] == null && equipements[nbEquipement+1] == null) {
					equipements[nbEquipement]= equipement;
					nbEquipement ++;
					sequipe(equipement);
				} else if(equipements[nbEquipement].toString().equals(equipement.toString()) || equipements[nbEquipement+1].toString().equals(equipement.toString())  ) {
					dejaEquiper(equipement);
				}
				break;
			case 1 :
				if(equipements[nbEquipement] == null && !equipements[nbEquipement-1].toString().equals(equipement.toString())) {
					equipements[nbEquipement]= equipement;
					nbEquipement ++;
					sequipe(equipement);
				} else if(equipements[nbEquipement-1].toString().equals(equipement.toString())) {
					dejaEquiper(equipement);
				}

				break;
			case 2 :
				System.out.println("Le soldat " + getNom() + " est déjà bien équipé");
		}
		
	}

	private void dejaEquiper(Equipement equipement) {
		System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement.toString());
	}

	private void sequipe(Equipement equipement) {
		System.out.println("Le soldat " + getNom() + " s'équipe d'un " + equipement.toString());
	}
	
	public static void main(String[] args) throws Exception {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
