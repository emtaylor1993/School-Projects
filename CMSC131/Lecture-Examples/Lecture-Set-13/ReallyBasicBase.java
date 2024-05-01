public class ReallyBasicBase {
	public int baseVal1;
	public int baseVal2;
	
	public ReallyBasicBase() {
		baseVal1 = 9;
		baseVal2 = 4;
	}
	
	public int diff() {
		return baseVal1-baseVal2;
	}
	
	public int sum() {
		return 0;
	}
	
	public String toString() {
		return (baseVal1 + ":" + baseVal2);
	}
}
