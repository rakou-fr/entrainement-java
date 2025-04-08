
public class Paire <U,V>{
	private U valeurGauche;
	private V valeurDroite;
	
	public Paire(U valeurGauche, V valeurDroite) {
		this.valeurGauche = valeurGauche;
		this.valeurDroite = valeurDroite;
	}
	
	public U getValeurGauche() {
		return valeurGauche;
	}
	public V getValeurDroite() {
		return valeurDroite;
	}
	
	@Override
	public String toString() {
		return valeurGauche + " " + valeurDroite;
	}
}
