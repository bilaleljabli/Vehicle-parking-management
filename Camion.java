package gestionDeParking;

public class Camion extends Véhicule {

	private boolean remorque;
	public Camion(String marque, String modéle, String immatriculation, boolean remorque) {
		super(marque, modéle, immatriculation);
		this.remorque = remorque;
	}
	
	public boolean isRemorque() {
		return remorque;
	}
	public void setRemorque(boolean remorque) {
		this.remorque = remorque;
	}

	
	@Override
	public String toString() {
		String affichage;
		if(isRemorque()) {
	    affichage = "La camion de la marque "+getMarque()+" et du modéle "+getModéle()+" et d'immatriculation "
	      +getImmatriculation()+" contient un remorque";
		} else {
	    affichage = "La camion de la marque "+getMarque()+" et du modéle "+getModéle()+" et d'immatriculation "
		  +getImmatriculation()+" ne contient pas un remorque";	
		}
		return affichage;
	}
	
}
