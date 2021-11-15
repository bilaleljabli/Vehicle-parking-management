package gestionDeParking;

public abstract class Véhicule {
	protected String marque;
	protected String modéle;
	protected String immatriculation;
	
	public Véhicule(String marque,String modéle, String immatriculation) {
		
		this.marque = marque;
		this.modéle = modéle;
		this.immatriculation = immatriculation; 
	}
	
	public String getMarque() {
		return marque;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	public String getModéle() {
		return modéle;
	}
	
	public void setModéle(String modéle) {
		this.modéle = modéle;
	}
	
	
	public String getImmatriculation() {
		return immatriculation;
	}
	
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

}

	
