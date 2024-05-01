/* This class is MUTABLE. */
public class RewriteableCD {
	private String title;
	private String artist;
	
	public RewriteableCD(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public RewriteableCD(RewriteableCD other) {
		title = other.title;
		artist = other.artist;
	}
	
	public void rewrite(String newTitle, String newArtist) {
		title = newTitle;
		artist = newArtist;
	}
	
	public String toString() {
		return (title + ":" + artist);
	}
}
