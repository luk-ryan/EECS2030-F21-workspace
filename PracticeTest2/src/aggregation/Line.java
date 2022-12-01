package aggregation;

public class Line {
	private Point pStart;
	private Point pEnd;
	
	/* Constructors */
	public Line(Point p1, Point p2) {
		this.pStart = p1;
		this.pEnd = p2;
	}
	public Line(Line other) {
		this.pStart = other.pStart;
		this.pEnd = other.pEnd;
	}
	
	/* Accessors */
	public Point getStart() {
		return this.pStart;
	}
	public Point getEnd() {
		return this.pEnd;
	}
	
	public boolean equals(Line l) {
		if (this == l) {
			return true;
		}
		Line other = (Line) l;
		return (this.pStart.equals(other.pStart)) && (this.pEnd.equals(other.pEnd));
	}
	
	/* Mutators */
}
