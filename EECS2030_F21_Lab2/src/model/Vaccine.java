package model;

public class Vaccine {
	private String codename;
	private String type;
	private String manufacturer;
	
	/* Constructor(s) */
	public Vaccine(String codename, String type, String manufacturer) {
		this.codename = codename;
		this.type = type;
		this.manufacturer = manufacturer;
	}
	
	/* Accessors */	
	public String getCodename() {
		return this.codename;
	}
	public String gettype() {
		return this.type;
	}
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	
	public boolean isRecognized() {
		String[] recognizedCodenames = {"mRNA-1273", "BNT162b2", "Ad26.COV2.S", "AZD1222"};
		boolean isRecognized = false;
		
		for (int i = 0; i < recognizedCodenames.length; i++) { // loop through list of recognized codenames and if in the array, isRecognized set to true
			if (this.codename.equals(recognizedCodenames[i])) {
				isRecognized = true;
			}
		}
		return isRecognized;
	}
	
	public String toString() {
		
		if (this.isRecognized()) { // using the isRecognized variable, output the appropriate string
			return String.format("Recognized vaccine: %s (%s; %s)", this.codename, this.type, this.manufacturer);
		}
		else {
			return String.format("Unrecognized vaccine: %s (%s; %s)", this.codename, this.type, this.manufacturer);
		}
	}
	
	/* Mutators */

}
