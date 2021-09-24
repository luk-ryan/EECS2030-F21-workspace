package model;

public class App {
	private String name;
	
	// keeps track of ratings log
	private int[] ratings;
	private int noR;
	private final int MAX_RATINGS;
	private double sumRatings;
	private double avgRatings;
	private int[] rCount; // stores how many of each rating app has gotten
	
	// keeps track of update log
	private Log[] updates;
	private final int MAX_UPDATES = 20;
	
	
	/* constructors */
	public App(String name, int inputMaxRatings) {
		this.name = name;
		this.updates = new Log[0];
		MAX_RATINGS = inputMaxRatings;
		this.ratings = new int[MAX_RATINGS];
		this.rCount = new int[5];
	}
	
	
	/* accessors */
	public String getName() {
		return this.name;
	}
	
	public String getWhatIsNew() {
		if (this.updates.length == 0) {
			return "n/a";
		}
		else {
			return this.updates[this.updates.length-1].toString();
		}
	}
	
	public Log[] getUpdateHistory() {
		return this.updates;
	}
	
	public Log getVersionInfo(String version) {
		for (int i = 0; i < this.updates.length; i++) {
			if (this.updates[i].getVersion().equals(version)) {
				return this.updates[i];
			}
		}
		return null;
	}
	
	public String getRatingReport() {
		if (noR == 0) {
			return "No ratings submitted so far!";
		}
		else {
			
			return String.format("Average of %d ratings: %.1f (Score 5: %d, Score 4: %d, Score 3: %d, Score 2: %d, Score 1: %d)", 
									noR, this.avgRatings, this.rCount[4], this.rCount[3], this.rCount[2], this.rCount[1], this.rCount[0]);
		}
	}
	
	public String toString() {
		String s;
		if (noR == 0) {
			s = String.format("%s (Current Version: %s; Average Rating: n/a)", this.name, this.getWhatIsNew());
		}
		else {
			s = String.format("%s (Current Version: %s; Average Rating: %.1f)", this.name, this.getWhatIsNew(), this.avgRatings);
		}
		return s;
	}
	
	
	/* mutators */
	public void releaseUpdate(Log log) {
		if (this.updates.length < MAX_UPDATES) { // max number
			Log[] tempArray = new Log[this.updates.length + 1]; // create temp array for a new index
			
			for (int i = 0; i < this.updates.length; i++) { // put existing items into temp array
				tempArray[i] = this.updates[i];
			}
	
			tempArray[tempArray.length - 1] = log; // put the input into last index of temp array
			this.updates = new Log[tempArray.length]; // make original array length the same as temp array
	
			for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
				this.updates[i] = tempArray[i];
			}
		}
	}
	
	public void releaseUpdate(String version) { // overloaded version of the one above
		Log l = new Log(version);
		releaseUpdate(l);
	}
	
	public void submitRating(int r) {
		if (this.noR < MAX_RATINGS) {
			this.ratings[this.noR++] = r;
			
			this.sumRatings += r;
			this.rCount[r-1] += 1;
			
			this.avgRatings = this.sumRatings / this.noR;
		}
	}
	
}











