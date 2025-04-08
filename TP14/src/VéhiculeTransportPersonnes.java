
abstract public class VéhiculeTransportPersonnes extends Véhicule{
	private int nbMaxPersonnes;
	
	public  VéhiculeTransportPersonnes(int nbMaxPersonnes, float poids, String immatriculation) {
		super(immatriculation, poids);
		this.nbMaxPersonnes = nbMaxPersonnes;
	}
	
	public int getNbMaxPersonnes() {
		return this.nbMaxPersonnes;
	}
}
