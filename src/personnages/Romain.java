package personnages;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements = {null, null};
	private int nbEquipement = 0;
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		// TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	
	public Romain(String nom, int force){
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	public void recevoirCoup(int forceCoup) {
//		int forceDebut = force;
//		assert force > 0 : "La force est supérieure à 0";
//		
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceDebut > force : "La force à bien diminuer";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		if(forceCoup < 0) {
			forceCoup = 0;
		}
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
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
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.recevoirCoup(2);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
