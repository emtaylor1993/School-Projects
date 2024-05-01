public class CDCollectionOwner {
	private String name;
	private CD[] myFavorites;
	
	public CDCollectionOwner() {
		name = "Fawzi";
		myFavorites = new CD[2];
		myFavorites[0] = new CD("Bob Usher", "Confessions");
		myFavorites[1] = new CD("Beyonce", "Irreplaceable");
	}
	
	/* Privacy leak! */
	public CD[] getCDsReferenceCopy() {
		return myFavorites;
	}
	
	/* This is fine, since CD's are immutable */
	public CD[] getCDsShallowCopy() {
		CD[] copy = new CD[myFavorites.length];
		
		for (int ind = 0; ind < copy.length; ind++)
			copy[ind] = myFavorites[ind];
		
		return copy;
	}
	
	/* This is fine, but wastes resources */
	public CD[] getCDsDeepCopy() {
		CD[] copy = new CD[myFavorites.length];
		
		for (int ind = 0; ind < copy.length; ind++)
			copy[ind] = new CD(myFavorites[ind]);
		
		return copy;
	}
	
	public String toString() {
		String s = name + "\n";
		s += myFavorites[0] + " & " + myFavorites[1] + "\n";
		s += "------------------";
		return s;
	}
}
