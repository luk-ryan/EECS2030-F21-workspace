package model;

public class SumsOfPrefixes extends SeqOperation {
	private int[] seq;
	
	/* Constructors */
	public SumsOfPrefixes(int[] seq) {
		this.seq = seq;
		
		int tempSum = 0;
		addResult(tempSum);
		
		for (int i = 0; i < seq.length; i++) {
			tempSum += seq[i];
			addResult(tempSum);
		}
	}
	
	/* Accessors */
	public String toString() {
		this.report = String.format("Sums of prefixes of %s is: %s", seqToString(this.seq), seqToString(this.result));
		
		return this.report;
	}
	
	/* Mutators */
}
