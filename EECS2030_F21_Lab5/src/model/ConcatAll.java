package model;

public class ConcatAll extends SeqEvaluator {
	private int[] result;
	
	/* Constructors */
	public ConcatAll (int maxOperations) {
		super(maxOperations);
		
		this.result = new int[0];
		
		if (isCompatible()) {
			evaluate();
		}
	}
	
	/* Accessors */
	public String toString() {
		
		if (isCompatible()) {
			evaluate();
			this.report = "Concat(";
			for(int i = 0; i < this.noo; i++) {
				if (i == this.noo-1) {
					this.report += String.format("%s", seqToString(this.operations[i].getResult()));
				}
				else {
					this.report += String.format("%s, ", seqToString(this.operations[i].getResult()));
				}
			}
			this.report += String.format(") = %s", seqToString(this.result));
		}
		else {
			this.report = String.format("Concat cannot be evaluated due to %d incompatile operations.", numIncompatible());
		}
		
		return this.report;
	}
	
	private String seqToString(int[] seq) {
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
	
	private int numIncompatible() {
		int num = 0;
		for (int i = 0; i < this.noo; i++) {
			if (this.operations[i] instanceof OccursWithin) {
				num++;
			}
		}
		return num;
	}
	
	private boolean isCompatible() {
		for (int i = 0; i < this.noo; i++) {
			if (this.operations[i] instanceof OccursWithin) {
				return false;
			}
		}
		return true;
	}
	
	/* Mutators */
	private void addResult(int n) {
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
	
	private void evaluate() {
		for(int i = 0; i < this.noo; i++) {
			for (int j = 0; j < this.operations[i].getResult().length; j++) {
				addResult(this.operations[i].getResult()[j]);
			}
		}
	}

}
