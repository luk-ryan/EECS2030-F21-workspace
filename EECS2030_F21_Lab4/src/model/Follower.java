package model;

public class Follower {
	protected String name;
	
	protected Channel[] channels;
	protected int noc; // current number of channels followed
	
	protected String report;
	
	/* Constructors */
	protected Follower(String name, int maxChannels) {
		this.name = name;
		
		this.channels = new Channel[maxChannels];
		this.noc = 0;
		
		this.report = "";
	}
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		this.report = String.format("%s follows ", this.name);
		
		if (this.noc == 0) { // if there are no channels being followed, format string this way
			this.report += "no channels";
		}
		else { // formats the list of channels that are currently being followed by this follower
			this.report += "[";
			for (int i = 0; i < this.noc; i++) {
				if (i == this.noc-1) {
					this.report += this.channels[i].getName() + "]";
				}
				else {
					this.report += this.channels[i].getName() + ", ";
				}
			}
		}
		return this.report;
	}
	
	
	/* Mutators */
	void addChannel(Channel c) {
		this.channels[noc++] = c;
	}
	
	void removeChannel(Channel c) {
		Channel[] temp = new Channel[this.channels.length];
		int i, count = 0; // counter to track index of temp
		
		for (i = 0; i < this.noc; i++) { // loop through channels array
			if (this.channels[i] != c) { // add everything other than c into the temp array
				temp[count++] = this.channels[i];
			}
		}
		
		this.channels = new Channel[temp.length]; // point to new array of same length as temp
		this.noc --; // new number of channels in array
		
		for (i = 0; i < this.noc; i++) { // add everything in temp back into channels array
			this.channels[i] = temp[i];
		}
	}
	
}
