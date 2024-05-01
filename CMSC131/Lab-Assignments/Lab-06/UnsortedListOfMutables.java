public class UnsortedListOfMutables {
	Person[] universityList;

	public UnsortedListOfMutables() {
		universityList = null;
	}
	
	public void addItem(Person newMember) {
		// Adds a new item always to the end of the list
		if (universityList == null) {
			universityList = new Person[1];
			universityList[0] = newMember.copyMe();
		} else {
			Person[] tempPersonArr = new Person[universityList.length + 1];
			for (int index = 0; index < universityList.length; index++) {
				tempPersonArr[index] = universityList[index].copyMe();
			}
			
			tempPersonArr[universityList.length] = newMember.copyMe();
			universityList = tempPersonArr;
		}
	}
	
	private int findIndex(String name) {
		// Returns the index if the first occurrence of the
		// passed name in the current list
		// or returns -1 if that name is not in the list
		if (name == null | universityList == null) {
			return -1;
		}
		
		for (int idx = 0; idx < universityList.length; idx++) {
			if (name.equals(universityList[idx].getName())) {
				return idx;
			}
		}
		
		return -1;
	}
	
	public boolean remove(String name) {
		// If that name appears in the current list,
		// it modifies the current list by removing the first
		// occurrence of that name in the list and returns true
		// if that name does not appear in the list, 
		// it makes no changes and returns false
		if (findIndex(name) > -1) {
			int index = 0;
			Person[] newList = new Person[universityList.length - 1];
			for (int i = 0; i < universityList.length; i++) {
				if (i != findIndex(name)) {
					newList[index] = universityList[i];
					index++;
				}
			}
			
			universityList = newList;
			return true;
		}
		
		return false;
	}
	
	public String getNames() {
		if (universityList == null) {
			return null;
		} else {
			String list = "";
			for (int index = 0; index < universityList.length; index++){
				list += universityList[index].getName();
			}
			
			return list;
		}
	}
	
	public int getValues() {
		// Returns the sum of all values of the individual
		// items in the current array
		// does not modify the current object's array
		int raises = 0;
		if (universityList == null) {
			return 0;
		} else {
			for (int i = 0; i < universityList.length; i++) {
				raises += universityList[i].getValue();
			}
		}
		
		return raises;
	}

	public int giveRaises() {
		// Gives a raise to each member of the list
		// each according to their own giveRaise method
		// within their own class  -- returns the total
		// amount given in raises
		int raises = 0;
		if (universityList == null) {
			return 0;
		} else {
			for(int i = 0; i < universityList.length; i++) {
				universityList[i].giveRaise();
				raises++;
			}
		}
		
		return raises;
	}
}