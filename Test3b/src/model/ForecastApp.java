package model;

public class ForecastApp extends WeatherApp{

	
	/* Constructors */	
	public ForecastApp(String name, int maxStations) {
		super(name, maxStations);
	}
	
	/* Accessors */
	public String toString() {
		if (this.stations.length == 0) {
			this.report = String.format("Weather Forecast App %s is connected to no stations.", this.name);
		}
		else {
			this.report = String.format("Weather Forecast App %s is connected to %d stations: <", this.name, this.stations.length);
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
	
	
	
	/* Mutators */
}
