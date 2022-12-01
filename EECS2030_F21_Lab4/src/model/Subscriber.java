package model;

public class Subscriber extends Follower{
	private String[] recommended;
	private int norv; // current number of recommended videos
	
	/* Constructors */
	public Subscriber(String name, int maxChannels, int maxVideos) {
		super(name, maxChannels);
		this.recommended = new String[maxVideos];
		this.name = "Subscriber " + this.name;
		
	}
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	public String toString() {
		this.report = super.toString();
		
		if (this.norv == 0) { // if no recommended videos, format string this way
			this.report += " and has no recommended videos.";
		}
		else { // formats the list of videos that have been recommended to this subscriber
			this.report += " and is recommended <";
			for (int i = 0; i < this.norv; i++) {
				if (i == this.norv-1) {
					this.report += this.recommended[i] + ">.";
				}
				else {
					this.report += this.recommended[i] + ", ";
				}
			}
		}
		return this.report;
	}
	
	
	/* Mutators */
	public void recommendVideo(String video) {
		this.recommended[norv++] = video;
	}
	
	public void watch(String video, int time) {
		
		for (int i=0; i < this.noc;i++) {
			for (int j = 0; j < this.channels[j].getNOV(); j++) {
				if (this.channels[i].getVideos()[j].equals(video)) {
					this.channels[i].addView(time);
				}
			}
		}
	}
}
