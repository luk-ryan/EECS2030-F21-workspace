package model;

public class Student {
	protected String name;
	protected Course[] courses;
	protected double tuition;
	
	/* Constructors */
	public Student(String name) {
		this.name = name;
		this.courses = new Course[0];
		this.tuition = 0.0;
	}
	
	/* Accessors */
	public Course[] getCourses() {
		return this.courses;
	}
	public double getTuition() {
		this.tuition = 0.0;
		for (int i = 0; i < this.courses.length; i++) {
			this.tuition += this.courses[i].getFee();
		}
		return this.tuition;
	}
	
	/* Mutators */
	public void register(Course c) {
		Course[] tempArray = new Course[this.courses.length + 1]; // create temp array for a new index
		
		for (int i = 0; i < this.courses.length; i++) { // put existing items into temp array
			tempArray[i] = this.courses[i];
		}

		tempArray[tempArray.length - 1] = c; // put the input into last index of temp array
		this.courses = new Course[tempArray.length]; // make original array length the same as temp array

		for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.courses[i] = tempArray[i];
		}
	}
	
	public void drop(Course c) {
		boolean isRegistered = false;
		
		for (int i = 0; i < this.courses.length; i++) { // check if object we want to remove is in the original array
			if (this.courses[i] == c) {
				isRegistered = true;
			}
		}
		
		if (isRegistered == true) {
			Course[] tempArray = new Course[this.courses.length - 1]; // create temp array for 1 less index than original
			int count = 0;
			
			for (int i = 0; i < this.courses.length; i++) { // put every item exccept for the one we want to remove into temp array
				if (courses[i] != c) {
					tempArray[count++] = this.courses[i];
				}
			}
			
			this.courses = new Course[tempArray.length]; // make original array length the same as temp array
			
			for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
				this.courses[i] = tempArray[i];
			}
		}
	}
}
