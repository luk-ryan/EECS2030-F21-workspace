package model;

public class RegistrationSystem {
	private Transcript[] transcripts;
	private int MAX_NUMBER_OF_TRANSCRIPTS = 500;
	
	/* Constructors */
	public RegistrationSystem() {
		this.transcripts = new Transcript[0];
	}
	
	
	/* Accessors */
	public Transcript[] getReport() {
		return this.transcripts;
	}
	public int getMarks(String name, String course) {
		int mark = -1;
		for (int i = 0; i < this.transcripts.length; i++) {
			if (this.transcripts[i].getStudentName().equals(name)) {
				mark = this.transcripts[i].getMarks(course);
			}
		}
		return mark;
	}
	
	
	/* Mutators */
	public void addTranscript(Transcript t) {
		Transcript[] tempArray = new Transcript[this.transcripts.length + 1]; // create temp array for a new index
		
		for (int i = 0; i < this.transcripts.length; i++) { // put existing items into temp array
			tempArray[i] = this.transcripts[i];
		}

		tempArray[tempArray.length - 1] = t; // put the input into last index of temp array
		this.transcripts = new Transcript[tempArray.length]; // make original array length the same as temp array

		for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.transcripts[i] = tempArray[i];
		}
	}



}




