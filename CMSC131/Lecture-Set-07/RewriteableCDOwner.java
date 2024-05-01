public class RewriteableCDOwner {
	private String name;
	private RewriteableCD myFavorite;
	
	public RewriteableCDOwner() {
		name = "Fawzi";
		myFavorite = new RewriteableCD("this", "that");
	}
	
	/* Privacy leak, since RewriteableCD's are mutable! */
	public RewriteableCD getCD() {
		return myFavorite;
	}

	/* This is fine */
	public RewriteableCD getCDAlternative() {
		return new RewriteableCD(myFavorite);
	}
}
