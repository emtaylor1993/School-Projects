public class BadDriver {
	public static void main(String[] args) {
		BaseType smallOne = new BaseType();
		BaseType biggerOne = new BaseType("Longer Name", 5);
		DerivedType biggestOne = new DerivedType("Me", 100, 75);
		DerivedType newOne = new DerivedType(biggestOne);
		
		System.out.println("smallest is " + smallOne);
		System.out.println("biggerOne is " + biggerOne);
		System.out.println("biggestOne is " + biggestOne);
		System.out.println("newOne is " + newOne);
		
		if (smallOne.grow(5)) {
			System.out.println("changed smallest is " + smallOne);
		} else {
			System.out.println("not changed smallest is " + smallOne);
		}
		
		if (biggerOne.grow(100)) {
			System.out.println("changed biggerOne is " + biggerOne);
		} else {
			System.out.println("not changed biggerOne is " + biggerOne);
		}
		
		if (biggestOne.grow(75)) {
			System.out.println("changed biggestOne is " + biggestOne);
		} else {
			System.out.println("not changed biggestOne is " + biggestOne);
		}
		
		if (newOne.grow(120)) {
			System.out.println("newOne is " + newOne);
		} else {
			System.out.println("not changed newOne is " + newOne);
		}
	}
}
