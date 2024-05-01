public class DerivedType2 extends BaseType {
	private double age;

	public DerivedType2() {
		super();
		age = -1;
	}
	
	public DerivedType2(String name, int size, double age) {
		super(name,size);
		this.age = age;
	}
	
	public DerivedType2(DerivedType2 oldOne) {
		super(oldOne);
		this.age = oldOne.age;
	}
	
	public boolean grow(int amt) {
		if (super.grow(amt)) {
			age++;
			return true;
		} else{
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + "[" + age + "]";
	}
}
