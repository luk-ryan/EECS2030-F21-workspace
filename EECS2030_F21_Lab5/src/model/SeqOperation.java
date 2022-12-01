package model;

public abstract class SeqOperation {
	
	protected int[] result;
	protected String report;
	
	/* Constructors */
	protected SeqOperation() {
		this.result = new int[0];
		this.report = "";
	}
	
	/* Accessors */
	public int[] getResult() {
		return this.result;
	}
	
	public abstract String toString();
	
	protected String seqToString(int[] seq) {
		String outSeq = "[";
		
		for (int i = 0; i < seq.length; i++) {
			if (i == seq.length-1) {
				outSeq += String.format("%d", seq[i]);
			}
			else {
				outSeq += String.format("%d, ", seq[i]);
			}
		}
		outSeq += "]";
		return outSeq;
	}
	
	/* Mutators */
	protected void addResult(int n) {
		int[] tempArray = new int[this.result.length + 1]; // create temp array for a new index
		
		for (int i = 0; i < this.result.length; i++) { // put existing items into temp array
			tempArray[i] = this.result[i];
		}

		tempArray[tempArray.length - 1] = n; // put the input into last index of temp array
		this.result = new int[tempArray.length]; // make original array length the same as temp array

		for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.result[i] = tempArray[i];
		}
	}
	
}
