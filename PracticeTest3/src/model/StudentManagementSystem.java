package model;

public class StudentManagementSystem {
	private Student[] students;
	
	/* Constructors */
	public StudentManagementSystem() {
		this.students = new Student[0];
	}
	
	/* Accessors */
	public Student[] getStudents() {
		return this.students;
	}
	
	
	/* Mutators */
	public void addStudent(Student s) {
		Student[] tempArray = new Student[this.students.length + 1]; // create temp array for a new index
		
		for (int i = 0; i < this.students.length; i++) { // put existing items into temp array
			tempArray[i] = this.students[i];
		}

		tempArray[tempArray.length - 1] = s; // put the input into last index of temp array
		this.students = new Student[tempArray.length]; // make original array length the same as temp array

		for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.students[i] = tempArray[i];
		}
	}
	
	public void registerAll(Course c) {
		for (int i = 0; i < this.students.length; i++) {
			this.students[i].register(c);
		}
	}
}
