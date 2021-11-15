package gestionDeParking;

public class Voiture extends Véhicule{
	
	private int nombrePortes;

	public Voiture(String marque, String modéle, String immatriculation,int nombrePortes) {
		super(marque, modéle, immatriculation);
		this.nombrePortes = nombrePortes;
	}

	public int getNombrePortes() {
		return nombrePortes;
	}

	public void setNombrePortes(int nombrePortes) {
		this.nombrePortes = nombrePortes;
	}
	
	
	@Override
	public String toString() {
		String affichage = "La voiture de la marque "+getMarque()+" et du modéle "+getModéle()+""
				+ " et d'immatriculation "+getImmatriculation()+" contient "+getNombrePortes()+" portes";
		return affichage;
	}
	


}
