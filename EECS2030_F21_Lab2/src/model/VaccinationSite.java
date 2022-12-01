package model;

public class VaccinationSite {
	private String name;
	
	private VaccineDistribution[] supply;
	private int novd; // number of vaccine distributions 
	private final int MAX_SUPPLY;
	
	private HealthRecord[] appointments;
	private int noa; // number of appointments
	private final int MAX_APPOINTMENTS = 200;
	
	/* Constructors */
	public VaccinationSite(String name, int maxSupply) {
		this.name = name;
		MAX_SUPPLY = maxSupply;
		this.supply = new VaccineDistribution[4];
		this.novd = 0;
		
		this.appointments = new HealthRecord[MAX_APPOINTMENTS];
		this.noa = 0;
	}
	
	/* Accessors*/
	public int getNumberOfAvailableDoses() {
		int noad = 0; // number of available doses
		
		for (int i = 0; i < this.novd; i++) {
			noad += this.supply[i].getNumberOfDoses();
		}
		return noad;
	}
	
	public int getNumberOfAvailableDoses(String codename) {
		for (int i = 0; i < this.novd; i++) {
			if (this.supply[i].getVaccine().getCodename().equals(codename)) {
				return this.supply[i].getNumberOfDoses();
			}
		}
		return 0;
	}
	
	public String toString() {
		String report = String.format("%s has %d available doses: <", this.name, this.getNumberOfAvailableDoses());
		if (novd == 0) {
			report += ">";
			
		}
		else {
			for (int i = 0; i < novd; i++) {
				if (i+1 == novd) {
					report += String.format("%d doses of %s>", this.supply[i].getNumberOfDoses(), this.supply[i].getVaccine().getManufacturer());
				}
				else {
					report += String.format("%d doses of %s, ", this.supply[i].getNumberOfDoses(), this.supply[i].getVaccine().getManufacturer());
				}
			}
		}
		return report;
	}
	
	
	/* Mutators */
	public void addDistribution(Vaccine v, int n) throws TooMuchDistributionException, UnrecognizedVaccineCodeNameException {
		
		if (!v.isRecognized()) { // fails when input vaccine is not recognized by Canada government
			throw new UnrecognizedVaccineCodeNameException("Unexpected exception thrown");
		}
		else if (this.getNumberOfAvailableDoses()+n > MAX_SUPPLY) { // fails when supply goes over max supply with this input n
			throw new TooMuchDistributionException ("Unexpected exception thrown");
		}
		else {
			boolean alreadyAvailable = false;
			
			for (int i = 0; i < this.novd; i++) {
				if (this.supply[i].getVaccine().equals(v)) {
					this.supply[i].addDistribution(n);
					alreadyAvailable = true;
				}
			}
			if (!alreadyAvailable) {
				this.supply[this.novd++] = new VaccineDistribution(v, n);
			}
		}
	}
	
	public void bookAppointment(HealthRecord h) throws InsufficientVaccineDosesException {
		
		if (this.getNumberOfAvailableDoses() <= noa) { // fails when there is no more supply available
			h.changeAppointmentStatus(String.format("Last vaccination appointment for %s with %s failed" , h.getName(), this.name));
			throw new InsufficientVaccineDosesException ("Unexpected exception thrown");
		}
		else {
			this.appointments[this.noa++] = h;
			h.changeAppointmentStatus(String.format("Last vaccination appointment for %s with %s succeeded" , h.getName(), this.name));
		}
	}
	
	public void administer(String date) {
		
		for (int i= 0; i < this.noa; i++) { // administer all available vaccines to the booked appointments
			int j = 0;
			boolean done = false;
			
			while (!done) {
				if (this.supply[j].getNumberOfDoses() == 0) {
					j++;
				}
				else {
					this.supply[j].addDistribution(-1);
					this.appointments[i].addRecord(this.supply[j].getVaccine(), this.name, date);
					done = true;
				}
			}	
		}
		this.appointments = new HealthRecord[MAX_APPOINTMENTS];
		this.noa = 0;
	}
	
}









