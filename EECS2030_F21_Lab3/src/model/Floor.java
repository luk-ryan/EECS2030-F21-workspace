package model;

public class Floor {
	
	private Unit[] units;
	private final int MAX_UNITS = 20;
	private int nou; // number of units
	
	private String report;
	private final int MAX_CAPACITY;
	
	/* Constructor */
	public Floor(int maxCapacity) {
		this.units = new Unit[MAX_UNITS];
		MAX_CAPACITY = maxCapacity;
		this.report = String.format("Floor's utilized space is 0 sq ft (%d sq ft remaining): []", MAX_CAPACITY);
	}
	public Floor(int maxCapacity, Unit[] u, int n) { // overloaded constructor
		this.units = u;
		this.nou = n;
		MAX_CAPACITY = maxCapacity;
		this.report = ""; 
	}
	public Floor(Floor other) throws InsufficientFloorSpaceException { // copy constructor
		this (other.MAX_CAPACITY, other.units, other.nou);
	}
	
	/* Accessors */
	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}
	public Unit[] getUnits() {
		return this.units;
	}
	public int getNOU() {
		return this.nou;
	}
	public String toString() {
		
		int currentCapacity = 0, remaining = 0, i;
		for (i = 0; i < this.nou; i++) {
			currentCapacity += this.units[i].getWidth()*this.units[i].getLength();
		}
		remaining = MAX_CAPACITY - currentCapacity;
		this.report = String.format("Floor's utilized space is %d sq ft (%d sq ft remaining): [", currentCapacity, remaining);
	
		for (i = 0; i < this.nou; i++) {
			if (i == this.nou-1) {
				this.report += String.format("%s: %.0f sq ft (%.0f' by %.0f')", this.units[i].getName(), this.units[i].getWidth()*this.units[i].getLength(), 
												this.units[i].getWidth(), this.units[i].getLength());
			}
			else {
				this.report += String.format("%s: %.0f sq ft (%.0f' by %.0f'), ", this.units[i].getName(), this.units[i].getWidth()*this.units[i].getLength(), 
												this.units[i].getWidth(), this.units[i].getLength());
			}
		}
		this.report += "]";
		return this.report;
	}
	
	public boolean equals(Object f) {
		if (this == f) {
			return true;
		}
		if (f == null) {
			return false;
		}
		Floor other = (Floor) f;
		if (this.nou != other.nou) {
			return false;
		}
		boolean isEqual = true, tempEqual;
		int i = 0, j;
		while (isEqual && i < this.nou) {
			j = 0;
			tempEqual = false;
			while(!tempEqual && j < other.nou) {
				if (this.units[i].equals(other.units[j])) {
					tempEqual = true;
				}
				j++;
			}
			isEqual = tempEqual;
		i++;
		}
		return (MAX_CAPACITY == other.MAX_CAPACITY && isEqual);
	}
	
	/* Mutators */
	public void addUnit(Unit u) throws InsufficientFloorSpaceException {
		int currentCapacity = 0, i;
		for (i = 0; i < this.nou; i++) {
			currentCapacity += this.units[i].getWidth()*this.units[i].getLength();
		}
		if (currentCapacity+(u.getWidth()*u.getLength()) > MAX_CAPACITY) {
			throw new InsufficientFloorSpaceException("Unexpected exception thrown");
		}
		else {
			this.units[this.nou++] = u;
		}
	}
	public void addUnit(String name, int w, int l) throws InsufficientFloorSpaceException { // overloaded version of addUnit
		Unit u = new Unit(name, w, l);
		this.addUnit(u);
	}
}
