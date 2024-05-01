/* This class is IMMUTABLE. */
public class CD {
	private String title;
	private String artist;
	
	public CD(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public CD(CD other) {
		title = other.title;
		artist = other.title;
	}
	
	public String toString(){
		return (title + ":" + artist);
	}
}
