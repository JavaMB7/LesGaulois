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
		texte.append("\n]");
		return texte.toString();
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obelix", 42);
		Romain romain = new Romain("Romain", 1);
		Romain minus = new Romain("Minus", 1);
		Musee musee = new Musee();
		asterix.boirePotion(7);
		romain.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		asterix.frapper(romain);
		obelix.frapper(minus);
		asterix.faireUneDonation(musee);
		obelix.faireUneDonation(musee);
		System.out.println(musee.extraireInstructionCaml());
	}
}
