package gestionDeParking;

public class Moto extends Véhicule{
	
	private int vitesseMax;

	public Moto(String marque, String modéle, String immatriculation, int vitesseMax) {
		super(marque, modéle, immatriculation);
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
		String affichage = "Le moto de la marque "+getMarque()+" et du modéle "+getModéle()
		+" et d'immatriculation "+getImmatriculation()+" a une vitesse de  "+getVitesseMax();
		return affichage;
	}
	
	
	

}
