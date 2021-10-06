package model;

public class VaccinationData {
	private Vaccine vaccine;
	private String vaccinationSite;
	private String date;
	
	/* Constructors */
	public VaccinationData(Vaccine v, String site, String date) {
		this.vaccine = v;
		this.vaccinationSite = site;
		this.date = date;
	}
	
	
	/* Accessors */
	public Vaccine getVaccine() {
		return this.vaccine;
	}
	public String getVaccinationSite() {
		return this.vaccinationSite;
	}
	public String getdate() {
		return this.date;
	}
	
}
