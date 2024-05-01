public class HumaneSociety {
	private Cat[][] catList;
	public final static int KINDS_OF_CATS = 5;

	// THIS METHOD IS ALREADY IMPLEMENTED
	// creates an empty humane society
	// each type of cat it null
	public HumaneSociety(){
		catList = new Cat[KINDS_OF_CATS][];
	}
	
	// STUDENTS IMPLEMENT THIS METHOD
	// adds one cat (mutable object)
	// in such a way that if his color is 0, he's at the 
	// end of row 0, but if his color is 1, he's at the 
	// end of row 1, etc.
	// Make sure the cat added is a copy of the cat 
	// that there is no aliasing to the cat passed as a parameter
	// At the "end" means all cats already in the list
	// appear in the same order as they were and before
	// the new cat.
	// Notice  the default constructor creates the 
	// array (one entry for each color of cat) but
	// each entry is a null reference since the row
	// is empty when the list is first constructed.
	public void addCat(Cat oneCat) {
		/* student needs to write the code for this method */
		int color = oneCat.getColor();
		
		if(catList[color] == null) {
			Cat[] temp = new Cat[1];
			temp[0] = new Cat(oneCat);
			catList[color] = temp;
		} else {
			Cat[] tempList = catList[color];
			Cat[] tempCat = new Cat[tempList.length + 1];
			
			for (int idx = 0; idx < tempList.length; idx++){
				tempCat[idx] = tempList[idx];
			}
			
			tempCat[tempList.length] = new Cat(oneCat);
			catList[color] = tempCat;
		}
	}
	
	// STUDENTS IMPLEMENT THIS METHOD
	// returns true if and only if there are no
	// cats at all in this humane society
	public boolean allEmpty() {
		/* student needs to write the code for this method */
		for(int i = 0; i < catList.length; i++) {
			if (catList[i] != null) {
				return false;
			}
		}
		
		return true;
	}
	
	// STUDENTS IMPLEMENT THIS METHOD
	// returns true if and only if there is at least one
	// cats of each and every type in this humane society
	public boolean atLeastOneOfEachType() {
		/* student needs to write the code for this method */
		for (int i = 0; i < catList.length; i++){
			if (catList[i] == null) {
				return false;
			}
		}
		
		return true;
	}
	
	// ALREADY IMPLEMENTED FOR YOU SO YOU CAN USE THE DEBUGGER EASILY
	// TO SEE WHAT CATS YOU HAVE
	// produces a string that says "Nothing Available"
	// if there are no cats at this humane society
	// or says "Current Cats Available:" followed by the cats
	// all cats of the same color are printed on the same line
	// starting with those who have color 0
	public String toString() {
		String temp = "";
		
		if (allEmpty()) {
			temp += "Nothing Available";
		} else {
			temp += "Current Cats Available: \n";
			for (int row = 0; row < catList.length; row++) {
				if (catList[row] == null) {
					continue;
				} else {
					for (int col = 0; col < catList[row].length; col++) {
						temp += catList[row][col];
						temp += ";";
					}
				}
				
				temp += "\n";
			}
		}
		
		return temp;
	}
}
