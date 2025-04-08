public class Point {
	
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    
    public int getY() {
        return this.y;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2.0)
                + Math.pow(p2.getY() - p1.getY(), 2.0));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.x;
        result = prime * result + this.y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.x == point.x && this.y == point.y) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Point [x=" + this.x + ", y=" + this.y + "]";
    }

}
