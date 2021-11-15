package gestionDeParking;

public class Moto extends V�hicule{
	
	private int vitesseMax;

	public Moto(String marque, String mod�le, String immatriculation, int vitesseMax) {
		super(marque, mod�le, immatriculation);
		this.vitesseMax = vitesseMax;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}
	
	
	@Override
	public String toString() {
		String affichage = "Le moto de la marque "+getMarque()+" et du mod�le "+getMod�le()
		+" et d'immatriculation "+getImmatriculation()+" a une vitesse de  "+getVitesseMax();
		return affichage;
	}
	
	
	

}
