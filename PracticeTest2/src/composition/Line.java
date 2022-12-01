package composition;

public class Line {
	private Point pStart;
	private Point pEnd;
	
	/* Constructors */
	public Line(Point p1, Point p2) {
		this.pStart = new Point(p1);
		this.pEnd = new Point(p2);
	}
	public Line(Line other) {
		this (other.pStart, other.pEnd);
	}
	
	/* Accessors */
	public Point getStart() {
		return this.pStart;
	}
	public Point getEnd() {
		return this.pEnd;
	}
	
	public boolean equals(Object l) {
		if (this == l) {
			return true;
		}
		Line other = (Line) l;
		return (this.pStart.equals(other.pStart)) && (this.pEnd.equals(other.pEnd));
	}
	
	/* Mutators */
}
