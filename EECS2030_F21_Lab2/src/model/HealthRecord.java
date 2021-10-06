package model;

public class HealthRecord {
	private String name;
	private String receipt;
	
	private VaccinationData[] data;
	private int nod; // number of doses the patient has received (used to keep track of how much data is stored)
	private final int MAX_NUMBER_OF_DOSES;
	
	
	/* Constructor(s) */
	public HealthRecord(String name, int mnod) {
		this.name = name;
		MAX_NUMBER_OF_DOSES = mnod;
		this.data = new VaccinationData[MAX_NUMBER_OF_DOSES];
		this.receipt = this.name + " has not yet received any doses.";
	}
	
	
	/* Accessors */
	public String getVaccinationReceipt() {
		if (nod > 0) {
			this.receipt = String.format("Number of doses %s has received: %d [", this.name, this.nod);
			
			for (int i = 0; i < this.nod; i++) {
				
				if (i == this.nod - 1) {
					this.receipt += String.format("%s in %s on %s]", this.data[i].getVaccine().toString(), 
							this.data[i].getVaccinationSite(), this.data[i].getdate());
				}
				else {
					this.receipt += String.format("%s in %s on %s; ", this.data[i].getVaccine().toString(), 
							this.data[i].getVaccinationSite(), this.data[i].getdate());
				}
			}
		}
		return this.receipt;
	}
	
	public String getAppointmentStatus() {
		return "No vaccination appointment for Alan yet";
	}
	
	
	/* Mutators */
	public void addRecord(Vaccine v, String site, String date) {
		VaccinationData vd = new VaccinationData(v, site, date);
		
		if (this.nod < MAX_NUMBER_OF_DOSES) {
			this.data[this.nod++] = vd;
		}
	}
}
