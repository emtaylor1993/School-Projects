public class RewriteableCDCollectionOwner {
	private String name;
	private RewriteableCD[] myFavorites;
	
	public RewriteableCDCollectionOwner() {
		name = "Fawzi";
		myFavorites = new RewriteableCD[2];
		myFavorites[0] = new RewriteableCD("Bob Usher", "Confessions");
		myFavorites[1] = new RewriteableCD("Beyonce", "Irreplaceable");
	}
	
	/* Privacy leak! */
	public RewriteableCD[] getCDsReferenceCopy() {
		return myFavorites;
	}
	
	/* Privacy leak, since RewritableCDs are mutable! */
	public RewriteableCD[] getCDsShallowCopy() {
		RewriteableCD[] copy = new RewriteableCD[myFavorites.length];
		for (int ind = 0; ind < copy.length; ind++)
			copy[ind] = myFavorites[ind];
		return copy;
	}
	
	/* This is fine. */
	public RewriteableCD[] getCDsDeepCopy() {
		RewriteableCD[] copy = new RewriteableCD[myFavorites.length];
		for (int ind = 0; ind < copy.length; ind++)
			copy[ind] = new RewriteableCD(myFavorites[ind]);
		return copy;
	}
	
	public String toString(){
		String s = name + "\n";
		s += myFavorites[0] + " & " + myFavorites[1] + "\n";
		s += "------------------";
		return s;
	}
}
