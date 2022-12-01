package model;

public class Channel {
	private String name;
	private String report;
	
	private Follower[] followers;
	private int nof; // current number of followers
	
	private String[] videos;
	private int nov; // current number of videos
	
	/* Constructors */
	public Channel(String name, int maxFollowers, int maxVideos) {
		this.name = name;
	
		this.followers = new Follower[maxFollowers];
		this.nof = 0;
		
		this.videos = new String[maxVideos];
		this.nov = 0;
		
		this.report = "";
	}
	
	/* Accessors */
	public String getName() {
		return this.name;
	}
	
	public int getNOV() {
		return this.nov;
	}
	
	public String[] getVideos() {
		return this.videos;
	}
	
	public String toString() {
		this.report = String.format("%s released", this.name);
		
		if(this.nov == 0) { // if no videos have been release, report adds "no videos"
			this.report += " no videos and";
		}
		else { // formats the list of videos that this channel has released
			this.report += " <";
			for (int i = 0; i < this.nov; i++) {
				if (i == this.nov-1) {
					this.report += this.videos[i] + "> and";
				}
				else {
					this.report += this.videos[i] + ", ";
				}
			}
		}
		if (this.nof == 0) { // if no followers, report adds "no followers"
			this.report += " has no followers.";
		}
		else { // formats the list of followers that is following this channel
			this.report += " is followed by [";
			for (int i = 0; i < this.nof; i++) {
				if (i == this.nof-1) {
					this.report += this.followers[i].getName() + "].";
				}
				else {
					this.report += this.followers[i].getName() + ", ";
				}
			}
		}
		return this.report;
	}
	
	
	/* Mutators */
	public void releaseANewVideo(String s) { // adds a video to video array and updates counter for that array
		this.videos[this.nov++] = s;
		
		for (int i = 0; i < this.nof; i++) {
			if (this.followers[i] instanceof Subscriber) {
				Subscriber f = (Subscriber) this.followers[i];
				f.recommendVideo(s);
			}
		}
	}
	
	public void follow(Follower f) { // adds a follower object to the followers array, and adds this channel object into follower's array of channels
		this.followers[this.nof++] = f; // adds follower object and updates counter
		
		f.addChannel(this); // adds this channel object into follower's array of channels
	}
	
	public void unfollow(Follower f) {
		
		Follower[] temp = new Follower[this.followers.length];
		int i, count = 0; // counter to track index of temp
		
		for (i = 0; i < this.nof; i++) { // loop through followers array
			if (this.followers[i] != f) { // add everything other than f into the temp array
				temp[count++] = this.followers[i];
			}
		}
		if (i != count) {
			this.followers = new Follower[temp.length]; // point to new array of same length as temp
			this.nof --; // new number of followers in array
		
			for (i = 0; i < this.nof; i++) { // add everything in temp back into followers array
				this.followers[i] = temp[i];
			}
		
			f.removeChannel(this); // removes this channel object from follower's array of channels
		}
	}
	
	public void addView(int time) {
		for (int i = 0; i < this.nof; i++) {
			if (this.followers[i] instanceof Monitor) {
				Monitor f = (Monitor) this.followers[i];
				f.addView(this, time);
			}
		}
	}
}
