package gestionDeParking;

public abstract class V�hicule {
	protected String marque;
	protected String mod�le;
	protected String immatriculation;
	
	public V�hicule(String marque,String mod�le, String immatriculation) {
		
		this.marque = marque;
		this.mod�le = mod�le;
		this.immatriculation = immatriculation; 
	}
	
	public String getMarque() {
		return marque;
	}
	
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	public String getMod�le() {
		return mod�le;
	}
	
	public void setMod�le(String mod�le) {
		this.mod�le = mod�le;
	}
	
	
	public String getImmatriculation() {
		return immatriculation;
	}
	
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

}

	
