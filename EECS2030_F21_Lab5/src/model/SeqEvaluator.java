package model;

public abstract class SeqEvaluator {
	protected SeqOperation[] operations;
	protected int noo; // number of operations
	
	protected String report;
	
	/* Constructors */
	public SeqEvaluator(int maxOperations) {
		this.operations = new SeqOperation[maxOperations];
		this.noo = 0;
		
		this.report = "";
	}
	
	/* Accessors */
	public abstract String toString();
	
	/* Mutators */
	public void addOperation(String operation, int[] seq1, int[] seq2) throws IllegalOperationException{
		SeqOperation op;
		
		if (operation.equals("op:projection")) {
			op = new Projection(seq1, seq2);
			this.operations[this.noo++] = op;
		}
		else if (operation.equals("op:sumsOfPrefixes")) {
			op = new SumsOfPrefixes(seq1);
			this.operations[this.noo++] = op;
		}
		else if (operation.equals("op:occursWithin")) {
			op = new OccursWithin(seq1, seq2);
			this.operations[this.noo++] = op;
		}
		else {
			throw new IllegalOperationException("Illegal operation");
		}
	}
}
