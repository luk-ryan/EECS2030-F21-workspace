package model;

public class Log {
	private String version;
	
	// keeps track of fixes internally through array
	private String[] fixes;
	private int noF;
	private final int MAX_FIXES = 10;
	
	private String fixReport;
	
	/* constructors */
	public Log(String version) {
		this.version = version;
		this.fixes = new String[MAX_FIXES];
	}
	
	/* accessors */
	public String getVersion() {
		return this.version;
	}
	
	public int getNumberOfFixes() {
		return this.noF;
	}
	
	public String getFixes() { // format string report (array items within this "[]")
		this.fixReport = "[";
		for (int i = 0; i < this.noF; i++) {
			if (i+1 == this.noF) {
				this.fixReport += String.format("%s", this.fixes[i]);
			}
			else {
				this.fixReport += String.format("%s, ", this.fixes[i]);
			}
		}
		this.fixReport += "]";
		
		return this.fixReport;
	}
	
	public String toString() {
		String s;
		s = String.format("Version %s contains %d fixes %s", this.version, this.noF, this.getFixes());
		return s;
	}
	
	/* mutators */
	public void addFix(String fix) {
		this.fixes[this.noF++] = fix;
	}
	
}