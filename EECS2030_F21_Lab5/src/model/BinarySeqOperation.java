package model;

public abstract class BinarySeqOperation extends SeqOperation {
	protected int[] seq1;
	protected int[] seq2;
	
	/* Constructors */
	public BinarySeqOperation(int[] s1, int[] s2) {
		super();
		this.seq1 = s1;
		this.seq2 = s2;
	}
	
	/* Accessors */
	public abstract String toString();
	
	/* Mutators */

}
