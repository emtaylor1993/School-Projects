public class CDOwner {
	private String name;
	private CD myFavorite;
	
	public CDOwner() {
		name = "Fawzi";
		myFavorite = new CD("this", "that");
	}
	
	/* This is fine, since CD's are immutable */
	public CD getCD() {
		return myFavorite;
	}
	
	/* This is fine, but wastes resources */
	public CD getCDAlternative() {
		return new CD(myFavorite);
	}
}
