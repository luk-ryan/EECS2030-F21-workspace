package model;

public class VaccineDistribution {
	private Vaccine vaccine;
	private int nod;
	
	
	/* Constructor(s) */
	public VaccineDistribution(Vaccine v, int nod) {
		this.vaccine = v;
		this.nod = nod;
	}
	
	/* Accessors */
	public Vaccine getVaccine() {
		return this.vaccine;
	}
	public int getNumberOfDoses() {
		return this.nod;
	}
	public String toString() {
		return String.format("%d doses of %s by %s", this.nod, this.vaccine.getCodename(), this.vaccine.getManufacturer());
	}
	
	
	/* Mutators */
	public void addDistribution(int n) {
		this.nod += n;
	}
}
