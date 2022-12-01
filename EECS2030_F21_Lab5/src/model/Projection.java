package model;

public class Projection extends BinarySeqOperation {

	
	/* Constructors */
	public Projection(int[] s1, int[] s2) {
		super(s1, s2);
		
		for (int i = 0; i < s2.length; i++) {
			int j = 0, count = this.result.length;
			while (j < s1.length && this.result.length == count) {
				if (s2[i] == s1[j]) {
					addResult(s2[i]);
				}
				j++;
			}
		}
	}
	
	/* Accessors */
	public String toString() {
		this.report = String.format("Projecting %s to %s results in: %s", seqToString(seq1), seqToString(seq2), seqToString(this.result));
		
		
		
		return this.report;
	}
	
	
	/* Mutators */
}
