package model;

public class AppStore {
	private String branchName;
	
	// Keeps track of apps in the store
	private App[] apps;
	private int noA;
	private final int MAX_APPS;
	
	// Stable apps
	private App[] stableApps;
	private int noSA;
	
	/* constructors */
	public AppStore(String name, int max) {
		this.branchName = name;
		
		MAX_APPS = max;
		this.apps = new App[MAX_APPS];
		this.stableApps = new App[MAX_APPS];
	}
	
	/* Accessors */
	public String getBranch() {
		return this.branchName;
	}
	
	public App getApp(String name) {
		for (int i = 0; i < this.noA; i++) {
			if (this.apps[i].getName().equals(name)) {
				return this.apps[i];
			}
		}
		return null;
	}
	
	public String[] getStableApps(int numberOfUpdates) {
		
		for (int i = 0; i < this.noA; i++) { // first, add the apps that have enough updates to our stable apps array
			if (numberOfUpdates <= this.apps[i].getUpdateHistory().length) {
				this.stableApps[this.noSA++] = this.apps[i];
			}
		}
		
		String[] stableAppsReport = new String[this.noSA]; // make an output array same length as stable apps array
		for (int i = 0; i < this.noSA; i++) {
			stableAppsReport[i] = String.format("%s (%d versions; Current Version: %s)", 
												this.stableApps[i].getName(), this.stableApps[i].getUpdateHistory().length, 
												this.stableApps[i].getUpdateHistory()[this.stableApps[i].getUpdateHistory().length - 1].toString());
		}
		
		return stableAppsReport;
	}
	
	/* mutators */
	public void addApp(App a) {
		if (this.noA <= MAX_APPS) {
			this.apps[this.noA++] = a;
		}
	}
	
	
	
}
