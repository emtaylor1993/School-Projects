public class DerivedType extends BaseType {
	private double age;

	public DerivedType() {
		setName("none");
		setSize(0);
		age = -1;
	}
	
	public DerivedType(String name, int size, double age) {
		setName(name);
		setSize(size);
		this.age = age;
	}
	
	public DerivedType(DerivedType oldOne) {
		setName(oldOne.getName());
		setSize(oldOne.getSize());
		this.age = oldOne.age;
	}
	
	public boolean grow(int amt) {
		if (super.grow(amt)) {
			age++;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + "[" + age + "]";
	}
}
