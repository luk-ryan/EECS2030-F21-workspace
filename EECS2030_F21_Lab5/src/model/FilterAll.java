package model;

public class FilterAll extends SeqEvaluator {

	/* Constructors */
	public FilterAll (int maxOperations) {
		super(maxOperations);
	}
	
	/* Accessors */
	public String toString() {
		if (isCompatible()) {
			this.report = "Filter result is: ";
			for (int i = 0; i < this.noo; i++) {
				if (i == this.noo-1) {
					if (((OccursWithin)this.operations[i]).getIsTrue()) {
						this.report += "true";
					}
					else {
						this.report += "_";
					}
				}
				else {
					if (((OccursWithin)this.operations[i]).getIsTrue()) {
						this.report += "true, ";
					}
					else {
						this.report += "_, ";
					}
				}
			}
		}
		else {
			this.report = String.format("Filter cannot be evaluated due to %d incompatile operations.", numIncompatible());
		}
		
		return this.report;
	}
	
	private int numIncompatible() {
		int num = 0;
		for (int i = 0; i < this.noo; i++) {
			if (this.operations[i] instanceof Projection || this.operations[i] instanceof SumsOfPrefixes) {
				num++;
			}
		}
		return num;
	}
	
	private boolean isCompatible() {
		for (int i = 0; i < this.noo; i++) {
			if (this.operations[i] instanceof Projection || this.operations[i] instanceof SumsOfPrefixes) {
				return false;
			}
		}
		return true;
	}
	
	/* Mutators */
}
