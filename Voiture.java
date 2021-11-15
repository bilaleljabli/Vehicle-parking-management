package gestionDeParking;

public class Voiture extends V�hicule{
	
	private int nombrePortes;

	public Voiture(String marque, String mod�le, String immatriculation,int nombrePortes) {
		super(marque, mod�le, immatriculation);
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
		String affichage = "La voiture de la marque "+getMarque()+" et du mod�le "+getMod�le()+""
				+ " et d'immatriculation "+getImmatriculation()+" contient "+getNombrePortes()+" portes";
		return affichage;
	}
	


}
