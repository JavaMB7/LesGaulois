package personnages;

public class Musee {

	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee]= new Trophee(gaulois,equipement);
		nbTrophee++;
	}
	
	public String extraireInstructionCaml(){
		StringBuilder texte = new StringBuilder("let musee = [");
		for(int i=0; i<trophees.length; i++) {
			if(trophees[i] != null) {
				texte.append("\n \"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() +"\";");
			}
		}
		texte.append("\n ]");
		return texte.toString();
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romain = new Romain("Romain", 1);
		Musee musee = new Musee();
		asterix.boirePotion(7);
		romain.sEquiper(Equipement.CASQUE);
		asterix.frapper(romain);
		asterix.faireUneDonation(musee);
		musee.extraireInstructionCaml();
	}
}
