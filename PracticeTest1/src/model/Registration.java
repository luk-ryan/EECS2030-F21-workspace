package model;

public class Registration {
	private String name;
	private int credits;
	private int rawMarks;
	
	/* Constructors */
	public Registration(String courseName, int credits, int marks) {
		this.name = courseName;
		this.credits = credits;
		this.rawMarks = marks;
	}
	public Registration(String courseName, int credits) { // overloaded version
		this.name = courseName;
		this.credits = credits;
	}
	
	/* Accessors */
	public String getCourseName() {
		return this.name;
	}
	public int getNumberOfCredits() {
		return this.credits;
	}
	public int getMarks() {
		return this.rawMarks;
	}
	
	/* Here is the map from numerical raw marks to string letter grades:
	 * Marks >= 90			: "A+"
	 * 80 <= Marks <  90	: "A"
	 * 70 <= Marks <  80	: "B"
	 * 60 <= Marks <  70	: "C"
	 * 50 <= Marks <  60	: "D"
	 * Marks < 50			: "F"
	 */
	public String getLetterGrade() {
		if (this.rawMarks >= 90) {
			return "A+";
		}
		else if (this.rawMarks >= 80) {
			return "A";
		}
		else if (this.rawMarks >= 70) {
			return "B";
		}
		else if (this.rawMarks >= 60) {
			return "C";
		}
		else if (this.rawMarks >= 50) {
			return "D";
		}
		else {
			return "F";
		}
	}
	
	/*
	 * Weighted Grade Point: grade point * number of credits.
	 * Here is the map from string letter grades to numerical grade points:
	 * "A+"	: 9
	 * "A"	: 8
	 * "B"	: 7
	 * "C" 	: 6
	 * "D"	: 5
	 * "F"	: 0
	 * For example, for r1 with letter grade B (and hence grade point 7) and 3 credits, 
	 * its weighted grade point is 7 * 3. 
	 */
	public int getWeightedGradePoint() {
		if (getLetterGrade().equals("A+")) {
			return (this.credits * 9);
		}
		else if (getLetterGrade().equals("A")) {
			return (this.credits * 8);
		}
		else if (getLetterGrade().equals("B")) {
			return (this.credits * 7);
		}
		else if (getLetterGrade().equals("C")) {
			return (this.credits * 6);
		}
		else if (getLetterGrade().equals("D")) {
			return (this.credits * 5);
		}
		else {
			return (this.credits * 0);
		}
	}
	
	
	/* Mutators */
	
	public void setMarks(int m) {
		this.rawMarks = m;
	}
}



