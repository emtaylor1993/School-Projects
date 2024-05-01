public class BaseType2 {
	private String name;
	private int size;
	
	public BaseType2() {
		name = "none";
		size = 0;
	}
	
	public BaseType2(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public BaseType2(BaseType2 oldOne) {
		this.name = oldOne.name;
		this.size = oldOne.size;
	}
	
	public boolean grow(int amt) {
		if (amt > 100){
			return false;
		} else if ((size + amt) > 150) {
			size = 150;
			return true;
		} else {
			size += amt;
			return true;
		}
	}
	
	public String toString() {
		return name + "(" + size + ")";
	}
}
