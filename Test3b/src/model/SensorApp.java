package model;

public class SensorApp extends WeatherApp {

	
	/* Constructors */	
	public SensorApp(String name, int maxStations) {
		super(name, maxStations);
	}
	
	/* Accessors */
	public String toString() {
		if (this.stations.length == 0) {
			this.report = String.format("Weather Sensor App %s is connected to no stations.", this.name);
		}
		else {
			this.report = String.format("Weather Sensor App %s is connected to %d stations: <", this.name, this.stations.length);
		}
		
		for (int i = 0; i < this.stations.length; i++) {
				if (i == this.stations.length-1) {
					this.report += String.format("%s>.", this.stations[i].getName());
				}
				else {
					this.report += String.format("%s, ", this.stations[i].getName());
				}

		}
			
		return this.report;
	}
	public String[] getConnectedForcastersOf(String stationName) {
		String[] forcasters = new String[MAX_STATIONS];
		int count = 0;
		for (int i = 0; i < this.stations.length; i++) {
			if (this.stations[i].getName().equals(stationName)) {
				for (int j = 0; j < this.stations[i].getApps().length; j++) {
					if (this.stations[i].getApps()[j] instanceof ForecastApp) {
						forcasters[count++] = this.stations[i].getApps()[j].getName();
					}
				}
			}
		}
		return forcasters;
	}
	
	/* Mutators */
	public void updateMeasurements(String stationName, int tempurature, int airPressure) {
		for (int i = 0; i < this.stations.length; i++) {
			if (this.stations[i].getName().equals(stationName)) {
				
			}
		}
	}
}
