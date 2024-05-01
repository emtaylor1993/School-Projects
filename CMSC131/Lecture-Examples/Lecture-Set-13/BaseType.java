public class BaseType {
	private String name;
	private int size;
	
	public BaseType() {
		name = "none";
		size = 0;
	}
	
	public BaseType(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public BaseType(BaseType oldOne) {
		this.name = oldOne.name;
		this.size = oldOne.size;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean grow(int amt) {
		if (amt > 100) {
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
