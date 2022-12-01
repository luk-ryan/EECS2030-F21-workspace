package model;

public class WeatherApp {
	protected String name;
	protected String report;
	
	protected WeatherStation[] stations;
	protected final int MAX_STATIONS;
	
	/* Constructors */
	public WeatherApp(String name, int maxStations) {
		this.name = name;
		
		this.stations = new WeatherStation[0];
		MAX_STATIONS = maxStations;
	}
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.report;
	}
	
	/* Mutators */
	public void connect(WeatherStation ws) {
		if (this.stations.length < MAX_STATIONS) {
			WeatherStation[] tempArray = new WeatherStation[this.stations.length + 1]; // create temp array for a new index

			for (int i = 0; i < this.stations.length; i++) { // put existing items into temp array
				tempArray[i] = this.stations[i];
			}

			tempArray[tempArray.length - 1] = ws; // put the input into last index of temp array
			this.stations = new WeatherStation[tempArray.length]; // make original array length the same as temp array

			for (int i = 0; i < tempArray.length; i++) { // copy everything from temp array back into original
				this.stations[i] = tempArray[i];
			}	
		}
	}
}
