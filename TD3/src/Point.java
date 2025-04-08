
public class Point {
	private float abscisse;
	private float ordonnée;
	
	public Point(float abscisse, float ordonnée) {
		this.ordonnée = 0.0f;
		this.abscisse = 0.0f;
	}
	
	public float getAbscisse() {
		return this.abscisse;
	}
	
	public float getOrdonnée() {
		return this.ordonnée;
	}
	
	public void translater(float tx, float ty) {
		this.abscisse += tx;
		this.ordonnée += ty;
	}
	
	public void mettreAEchelle(float h) throws IllegalArgumentException{
		if (h <= 0.0f) {
			throw new IllegalArgumentException("h < 0.0f");
		}
		this.abscisse *= h;
		this.ordonnée *= h;
	}
	
	@Override
	public String toString() {
		return "(" + this.abscisse + ";" + this.ordonnée + ")";
	}
}
