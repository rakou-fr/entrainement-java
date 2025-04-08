import java.util.Scanner;

public class Segment {	

	private Point extrémitéInitiale;
	private Point extrémitéFinale;
	
	public Segment(Point extrémitéInitiale, Point extrémitéFinale) {
		this.extrémitéInitiale = extrémitéInitiale;
		this.extrémitéFinale = extrémitéFinale;
	}
	
	public Point pointMiliue() {
		return new Point(
				(this.extrémitéInitiale.getAbscisse() + this.extrémitéFinale.getAbscisse()) / 2.0f,
				(this.extrémitéInitiale.getOrdonnée() + this.extrémitéFinale.getOrdonnée()) / 2.0f
				);
	}
	
}
