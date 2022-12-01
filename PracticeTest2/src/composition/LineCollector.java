package composition;

public class LineCollector {
	private Line[] lines;
	
	/* Constructors */
	public LineCollector() {
		this.lines = new Line[0];
	}
	public LineCollector(LineCollector other) {
		this.lines = new Line[0];
		for (int i = 0; i < other.lines.length; i++) {
			this.addLine(other.lines[i]);
		}
	}
	
	/* Accessors */
	public Line[] getLines() {
		return this.lines;
	}
	public Line getLineAt(int i) {
		return this.lines[i];
	}
	
	public boolean equals(Object lc) {
		if (this == lc) {
			return true;
		}
		LineCollector other = (LineCollector) lc;
		if (this.lines.length != other.lines.length) {
			return false;
		}
		boolean isEqual = true;
		
		for (int i = 0; i < this.lines.length; i++) {
			if (!(this.lines[i].equals(other.lines[i]))) {
				isEqual = false;
			}
		}
		return isEqual;
		
	}
	
	/* Mutators */
	public void addLine(Line l) {
		Line[] tempArray = new Line[this.lines.length + 1]; // create temp array for a new index
		int i;
		
		for (i = 0; i < this.lines.length; i++) { // put existing items into temp array
			tempArray[i] = this.lines[i];
		}

		tempArray[tempArray.length - 1] = new Line(l); // put the input into last index of temp array
		this.lines = new Line[tempArray.length]; // make original array length the same as temp array

		for (i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.lines[i] = tempArray[i];
		}
	}
}
