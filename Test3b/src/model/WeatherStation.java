package model;

public class WeatherStation {
	private String name;
	private WeatherApp[] apps;
	private String report;
	private final int MAX_APPS;
	private SensorApp[] sensors;
	
	/* Constructors */
	public WeatherStation(String name, int maxApps) {
		this.name = name;
		
		this.apps = new WeatherApp[0];
		MAX_APPS = maxApps;
		
		this.sensors = new SensorApp[0];
		
		this.report = String.format("%s has no connected apps.", this.name);
	}
	
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	
	public WeatherApp[] getApps() {
		return this.apps;
	}
	
	public String toString() {
		if (this.apps.length == 0) {
			this.report = String.format("%s has no connected apps.", this.name);
		}
		else {
			this.report = String.format("%s is connected by %d apps: <", this.name, this.apps.length);
		}
		
		for (int i = 0; i < this.apps.length; i++) {
			if (this.apps[i] instanceof ForecastApp) {
				if (i == this.apps.length-1) {
					this.report += String.format("Weather Forcast App %s>.", this.apps[i].getName());
				}
				else {
					this.report += String.format("Weather Forcast App %s, ", this.apps[i].getName());
				}
			}
			else if (this.apps[i] instanceof SensorApp) {
				if (i == this.apps.length-1) {
					this.report += String.format("Weather Sensor App %s>.", this.apps[i].getName());
				}
				else {
					this.report += String.format("Weather Sensor App %s, ", this.apps[i].getName());
				}
			}
		}
			
		return this.report;
	}
	
	public SensorApp[] getSensors() {
		this.sensors = new SensorApp[0];
				
		for (int i = 0; i < this.apps.length;i++) {
			if (this.apps[i] instanceof SensorApp) {
				this.addSensor((SensorApp)this.apps[i]);
			}
		}
		return this.sensors;
	}
	
	/* Mutators */
	public void addSensor(SensorApp s) {
		SensorApp[] tempArray = new SensorApp[this.apps.length + 1]; // create temp array for a new index
		
		for (int i = 0; i < this.sensors.length; i++) { // put existing items into temp array
			tempArray[i] = this.sensors[i];
		}

		tempArray[tempArray.length - 1] = s; // put the input into last index of temp array
		this.sensors = new SensorApp[tempArray.length]; // make original array length the same as temp array

		for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
			this.sensors[i] = tempArray[i];
		}
	}
	
	public void connect(WeatherApp a) {
		if (this.apps.length < MAX_APPS) {
			WeatherApp[] tempArray = new WeatherApp[this.apps.length + 1]; // create temp array for a new index

			for (int i = 0; i < this.apps.length; i++) { // put existing items into temp array
				tempArray[i] = this.apps[i];
			}

			tempArray[tempArray.length - 1] = a; // put the input into last index of temp array
			this.apps = new WeatherApp[tempArray.length]; // make original array length the same as temp array

			for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
				this.apps[i] = tempArray[i];
			}
			
			a.connect(this);
		}
	}
}
