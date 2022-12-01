package model;

public class Monitor extends Follower{
	private double[][] stats;
	private int nocs; // current number of channel stats
	
	/* Constructors */
	public Monitor(String name, int maxChannels) {
		super(name, maxChannels);
		this.name = "Monitor " + this.name;
		
		this.stats = new double[maxChannels][4];
		this.nocs = 0;
	}
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	public String toString() { // uses parent class' toString function to handle most of the formatting
		this.report = String.format("%s follows ", this.name);
		
		if (this.noc == 0) { // if there are no channels being followed, format string this way
			this.report += "no channels";
		}
		else { // formats the list of channels that are currently being followed by this follower
			this.report += "[";
			for (int i = 0; i < this.noc; i++) {
				if (i == this.noc-1) {
					if (this.stats[i][0] == 0.0) {
						this.report += this.channels[i].getName() + "]";
					}
					else {
						this.report += String.format("%s {#views: %.0f, max watch time: %.0f, avg watch time: %.2f}]", 
														this.channels[i].getName(), this.stats[i][0], this.stats[i][1], this.stats[i][3]);
					}
					
				}
				else {
					if (this.stats[i][0] == 0.0) {
						this.report += this.channels[i].getName() + ", ";
					}
					else {
						this.report += String.format("%s {#views: %.0f, max watch time: %.0f, avg watch time: %.2f}, ", 
														this.channels[i].getName(), this.stats[i][0], this.stats[i][1], this.stats[i][3]);
					}
				}
			}
		}
		return this.report + ".";
	}
	
	
	/* Mutators */
	public void addChannel(Channel c) {
		super.addChannel(c);
		
		this.stats[this.nocs][0] = 0.0; // number of views
		this.stats[this.nocs][1] = 0.0; // max watch time
		this.stats[this.nocs][2] = 0.0; // total watch time
		this.stats[this.nocs][3] = 0.0; // average watch time
		this.nocs++;
	}
	
	public void removeChannel(Channel c) {
		super.removeChannel(c);
		
		double[][] temp = new double[this.stats.length][4];
		int i, index = 0, count = 0; // counter to track index of temp, as well as the index of channel we want to remove
		
		for (i = 0; i < this.noc; i++) { // loop through channels array
			if (this.channels[i] == c) {
				index = i;
			}
		}
		
		for (i = 0; i < this.nocs; i++) {
			if (i != index) {
				temp[count++][0] = this.stats[i][0];
				temp[count++][1] = this.stats[i][1];
				temp[count++][2] = this.stats[i][2];
				temp[count++][3] = this.stats[i][3];
			}
		}
		
		this.stats = new double[temp.length][4]; // point to new array of same length as temp
		this.nocs --; // new number of channels in array
		
		for (i = 0; i < this.nocs; i++) { // add everything in temp back into stats array
			this.stats[i][0] = temp[i][0];
			this.stats[i][1] = temp[i][1];
			this.stats[i][2] = temp[i][2];
			this.stats[i][3] = temp[i][3];
		}
	}
	
	public void addView(Channel c, int time) {
		for (int i = 0; i < this.noc; i++) {
			if (this.channels[i] == c) { 
				this.stats[i][0]++; // update number of views
				
				if (this.stats[i][1] < time) { // updates max watch time if current is more than original
					this.stats[i][1] = time;
				}
				this.stats[i][2] += time; // update total watch time
				
				this.stats[i][3] = this.stats[i][2] / this.stats[i][0]; // update average watch time
			}
		}
	}
	
}
