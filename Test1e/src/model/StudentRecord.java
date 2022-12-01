package model;

public class StudentRecord {
	private String courseName;
	private Assessment[] assessments;
	private String report;
	
	/* Constructors */
	public StudentRecord(String cn) {
		this.courseName = cn;
		this.assessments = new Assessment[0];
		this.report = String.format("Number of assessments in %s: 0 []", this.courseName);
	}
	
	
	/* Accessors */
	public String getCourse() {
		return this.courseName;
	}
	
	public String getAssessmentReport() { // format report before returning an output
		int i;
		
		this.report = String.format("Number of assessments in %s: %d [", this.courseName, this.assessments.length);

		for (i = 0; i < this.assessments.length; i++) {
			if (i == this.assessments.length-1) {
				this.report += String.format("%s (weight: %.3f percents; marks: %d)", this.assessments[i].getName(), 
						this.assessments[i].getWeight(), this.assessments[i].getMarks());
			}
			else {
				this.report += String.format("%s (weight: %.3f percents; marks: %d), ", this.assessments[i].getName(), 
						this.assessments[i].getWeight(), this.assessments[i].getMarks());
			}
		}
		this.report += "]";
		return this.report;
	}
	
	public double getCompletionRate() {
		double completion = 0.0;
		for (int i = 0; i < this.assessments.length; i++) {
			completion += (this.assessments[i].getWeight()/100);
		}
		return completion;
	}
	
	public double getRawMarks() {
		double rawMarks = 0.0;
		double temp = 0.0;
		for (int i = 0; i < this.assessments.length; i++) {
			temp = (this.assessments[i].getWeight()/100) * this.assessments[i].getMarks();
			rawMarks += temp;
		}
		return rawMarks;
	}
	
	
	/* Mutators */
	public void addAssessment(Assessment a) {
		Assessment[] tempArray = new Assessment[this.assessments.length + 1]; // create temp array for a new index
		int i;
		
		for (i = 0; i < this.assessments.length; i++) { // put existing items into temp array
			tempArray[i] = this.assessments[i];
		}

		tempArray[tempArray.length - 1] = a; // put the input into last index of temp array
		this.assessments = new Assessment[tempArray.length]; // make original array length the same as temp array

		for (i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.assessments[i] = tempArray[i];
		}
	}
	public void addAssessment(String assessment, double w, int m) { // overloaded version of add assessment
		Assessment a = new Assessment(assessment, w, m);
		this.addAssessment(a);
	}
	
	public void removeAssessment(String course) {
		
		for (int i = 0; i < this.assessments.length; i++) {
			if (this.assessments[i].getName().equals(course)) {
				Assessment[] tempArray = new Assessment[this.assessments.length - 1]; // create temp array for a new index
				int j;
				
				int count = 0;
				for (j = 0; j < this.assessments.length; j++) { // put existing items into temp array (excluding the one index we want to remove)
					if (j != i) {
						tempArray[count++] = this.assessments[j];
					}
				}

				this.assessments = new Assessment[tempArray.length]; // make original array length the same as temp array

				for (i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
					this.assessments[i] = tempArray[i];
				}
			}
		}
	}
	
	public void changeMarksOf(String course, int m) {
		for (int i = 0; i < this.assessments.length; i++) {
			if (this.assessments[i].getName().equals(course)) {
				this.assessments[i].setMarks(m);
			}
		}
	}
	
}
