package model;

public class Blueprint {
	
	private Floor[] floors;
	private final int MAX_FLOORS;
	private String report;
	
	/* Constructors */
	public Blueprint(int numberOfFloors) {
		MAX_FLOORS = numberOfFloors;
		this.floors = new Floor[0];
		this.report = String.format("0.0 percents of building blueprint completed (0 out of %d floors)", MAX_FLOORS);
	}
	
	public Blueprint (Blueprint other) { // copy constructor
		this (other.MAX_FLOORS);
		
		for (int i = 0; i < other.floors.length; i++) {
			Floor src = other.floors[i];
			try {
				Floor nf = new Floor(src);
				this.addFloorPlan(nf);
			} catch (InsufficientFloorSpaceException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Accessors */
	public String toString() {
		this.report = String.format("%.1f percents of building blueprint completed (%d out of %d floors)", 
				(100.0*this.floors.length/MAX_FLOORS), this.floors.length, MAX_FLOORS);
		return this.report;
	}
	public Floor[] getFloors() {
		Floor[] output = new Floor[this.floors.length];
		
		for (int i = 0; i < output.length; i++) {
			output[i] = new Floor(this.floors[i].getMaxCapacity(), 
									this.floors[i].getUnits(), this.floors[i].getNOU());
		}
		return output;
	}
	
	/* Mutators */
	public void addFloorPlan(Floor f) {
		Floor[] tempArray = new Floor[this.floors.length + 1]; // create temp array for a new index
		int i;
		
		for (i = 0; i < this.floors.length; i++) { // put existing items into temp array
			tempArray[i] = this.floors[i];
		}

		tempArray[tempArray.length - 1] = f; // put the input into last index of temp array
		this.floors = new Floor[tempArray.length]; // make original array length the same as temp array

		for (i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.floors[i] = tempArray[i];
		}
	}
}
