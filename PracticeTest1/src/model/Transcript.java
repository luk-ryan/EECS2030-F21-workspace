package model;

public class Transcript {
	private String name;
	private Registration[] registrations;
	
	
	/* Constructors */
	public Transcript(String name) {
		this.name = name;
		this.registrations = new Registration[0];
	}
	
	
	/* Accessors */
	public String getStudentName() {
		return this.name;
	}
	public Registration[] getReport() {
		return this.registrations;
	}
	public int getMarks(String courseName) {
		int mark = -1;
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i].getCourseName().equals(courseName)) {
				mark = this.registrations[i].getMarks();
			}
		}
		return mark;
	}
	
	public double getWeightedGPA() {
		double gpa = 0.0;
		for (int i = 0; i < this.registrations.length; i++) {
			gpa += this.registrations[i].getWeightedGradePoint(); 
		}
		gpa = gpa*1.0/this.registrations.length;
		return gpa;
	}
	
	
	/* Mutators */
	public void addRegistration(Registration r) {
		Registration[] tempArray = new Registration[this.registrations.length + 1]; // create temp array for a new index
		
		for (int i = 0; i < this.registrations.length; i++) { // put existing items into temp array
			tempArray[i] = this.registrations[i];
		}

		tempArray[tempArray.length - 1] = r; // put the input into last index of temp array
		this.registrations = new Registration[tempArray.length]; // make original array length the same as temp array

		for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.registrations[i] = tempArray[i];
		}
	}
	public void addRegistration(String courseName, int credits) {
		Registration r = new Registration(courseName, credits);
		this.addRegistration(r);
	}
	public void addRegistrations(Registration[] r) {
		for (int i = 0; i < r.length; i++) {
			this.addRegistration(r[i]);
		}
	}
	
	public void setMarks(String cn, int mark) {
		for (int i = 0; i < this.registrations.length; i++) {
			if (this.registrations[i].getCourseName().equals(cn)) {
				this.registrations[i].setMarks(mark);
			}
		}
	}
	
}




