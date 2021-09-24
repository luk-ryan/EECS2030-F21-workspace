package model;

public class Account {
	private String name; // user's name
	private AppStore store; // ONE linked store
	private String status;
	
	private App[] downloadedApps; // array of apps user has downloaded
	private String[] downloadedAppNames;
	private final int MAX_DOWNLOADS = 50;


	/* constructors */
	public Account(String name, AppStore store) {
		this.name = name;
		this.store = store;
		this.status = String.format("An account linked to the Canada store is created for %s.", this.name);
		
		this.downloadedApps = new App[0];
		this.downloadedAppNames = new String[0];
	}
	
	
	/* accessors */
	public String toString() {
		return this.status;
	}
	
	public String[] getNamesOfDownloadedApps() {
		return this.downloadedAppNames;
	}
	
	public App[] getObjectsOfDownloadedApps() {
		return this.downloadedApps;
	}
	
	
	/* mutators */
	private void download (App app) { // This version of download app can ONLY be used locally (adds an app to existing downloadedApps array)
		if (this.downloadedApps.length <= MAX_DOWNLOADS) {
			App[] tempArray = new App[this.downloadedApps.length + 1]; // create temp array for a new index
			
			for (int i = 0; i < this.downloadedApps.length; i++) { // put existing items into temp array
				tempArray[i] = this.downloadedApps[i];
			}
	
			tempArray[tempArray.length - 1] = app; // put the input into last index of temp array
			this.downloadedApps = new App[tempArray.length]; // make original array length the same as temp array
	
			for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
				this.downloadedApps[i] = tempArray[i];
			}
		}
	}
	
	public void  download (String appName) {
		App a = this.store.getApp(appName);
		boolean isAllowed = true;
		
		for (int i = 0; i < this.downloadedApps.length; i++) {
			if (this.downloadedApps[i].equals(a)) {
				isAllowed = false;
				this.status = String.format("Error: %s has already been downloaded for %s.", a.getName() , this.name);
			}
		}
		
		if (isAllowed) {
			this.download(a);
			this.downloadedAppNames = new String[this.downloadedApps.length];
			
			for (int j = 0; j < this.downloadedApps.length; j++) {
				this.downloadedAppNames[j] = this.downloadedApps[j].getName();
			}
			this.status = String.format("%s is successfully downloaded for %s.", a.getName() , this.name);
		}
	}
	
	private boolean allowed(String s) { // same condition is needed to uninstall and submit rating (input must be already downloaded)
		boolean isAllowed = false;
		for (int i = 0; i < this.downloadedApps.length; i++) {
			if (this.downloadedAppNames[i].equals(s)) {
				isAllowed = true;
			}
		}
		return isAllowed;
	}
	
	public void uninstall(String appName) {
		
		boolean isAllowed;
		isAllowed = allowed(appName);
		
		if (isAllowed) {
			App[] tempArray = new App[this.downloadedApps.length - 1]; // create temp array for one less index
			int i = 0;
			int count = 0;
			
			while (i < this.downloadedApps.length) { // put existing items (except the one specified) into temp array
				if (!(this.downloadedAppNames[i].equals(appName))) {
					tempArray[count] = this.downloadedApps[i];
					count++;
				}
				i++;
			}

			this.downloadedApps = new App[tempArray.length]; // make both original array length the same as temp array
			this.downloadedAppNames = new String[tempArray.length];
	
			for (i = 0; i < tempArray.length; i++) { // copy everything from temp array into original
				this.downloadedApps[i] = tempArray[i];
				this.downloadedAppNames[i] = tempArray[i].getName(); // copy the strings into this one
			}
			
			this.status = String.format("%s is successfully uninstalled for %s.", appName , this.name);
		}
		else {
			this.status = String.format("Error: %s has not been downloaded for %s.", appName , this.name);
		}
	}
	
	public void submitRating(String appName, int rating) {
		
		boolean isAllowed;
		isAllowed = allowed(appName);
		
		if (isAllowed) {
			this.store.getApp(appName).submitRating(rating);
			this.status = String.format("Rating score %d of %s is successfully submitted for %s.", rating, this.name, appName);
		}
		else {
			this.status = String.format("Error: %s is not a downloaded app for %s.", appName , this.name);
		}
	}
	
	public void switchStore(AppStore store) {
		this.store = store;
		this.status = String.format("Account for %s is now linked to the %s store.", this.name, store.getBranch());
	}
	
	
}



