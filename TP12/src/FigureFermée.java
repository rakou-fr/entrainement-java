import java.awt.Graphics;

public abstract class FigureFermée {
	private Point point1;
	private Point point2;
	
	
	public FigureFermée(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}
	
	public void tracer(Graphics g) {
		
	}
	
	public Point getPoint1() {
		return this.point1;
	}

	public Point getPoint2() {
		return this.point2;
	}
	
	public abstract double périmètre();
	public abstract double surface();
	
}
