package model;

public class OccursWithin extends BinarySeqOperation {
	private boolean isTrue;
	
	/* Constructors */
	public OccursWithin(int[] s1, int[] s2) {
		super(s1, s2);
		this.isTrue = false;
		
		if (s1.length == 0) {
			this.isTrue = true;
		}
		else if (s1.length > s2.length) {
			this.isTrue = false;
		}
		else {
			int i = 0;
			while (i < s2.length && this.isTrue == false) {
				if (s1[0] == s2[i]) {
					int count = i+1, j = 1;
					boolean tempCounter = true;
					while (j < s1.length && count < s2.length && tempCounter == true) {
						if (s1[j] != s2[count]) {
							tempCounter = false;
						}
						count++;
						j++;
					}
					if (tempCounter == true) {
						this.isTrue = true;
					}
				}
				i++;
			}
		}
	}
	
	
	/* Accessors */
	public boolean getIsTrue() {
		return this.isTrue;
	}
	
	public String toString() {
		if (isTrue) {
			this.report = String.format("%s occurs within %s", seqToString(seq1), seqToString(seq2));
		}
		else {
			this.report = String.format("%s does not occur within %s", seqToString(seq1), seqToString(seq2));
		}
		return this.report;
	}
	
	/* Mutators */
}
