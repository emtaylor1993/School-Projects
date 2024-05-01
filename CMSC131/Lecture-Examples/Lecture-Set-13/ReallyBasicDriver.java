public class ReallyBasicDriver {
	public static void main(String[] args) {
		ReallyBasicDerived d = new ReallyBasicDerived();
		System.out.println(d);
		System.out.println(d.diff());
		System.out.println(d.sum());
		System.out.println(d.largerDiff());
		
		ReallyBasicBase b = new ReallyBasicBase();
		System.out.println(b);
		System.out.println(b.diff());
		
		ReallyBasicBase bd = new ReallyBasicDerived();
		System.out.println(bd);
		System.out.println(bd.diff());
		System.out.println(bd.sum());
	}
}
