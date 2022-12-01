package aggregation;

public class Point {
	private int x;
	private int y;
	
	/* Constructors */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point(Point other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	/* Accessors */
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean equals(Point p) {
		if (this == p) {
			return true;
		}
		Point other = (Point) p;
		return (this.x == other.x) && (this.y == other.y);
	}
	
	/* Mutators */
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
