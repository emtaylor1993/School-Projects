public class ReallyBasicDerived extends ReallyBasicBase {
	private int derVal1;
	private int derVal2;
	
	public ReallyBasicDerived() {
		baseVal1 = 9;
		baseVal2 = 4;
		derVal1 = 3;
		derVal2 = 2;
	}
	
	public int sum() {
		return baseVal1 + baseVal2 + derVal1 + derVal2;
	}
	
	public int largerDiff() {
		int baseDiff = diff();
		int derDiff = derVal1 - derVal2;
		
		return (baseDiff > derDiff ? baseDiff : derDiff);
	}
	
	public String toString() {
		return (baseVal1 + "X" + baseVal2 + "|" + derVal1 + "X" + derVal2);
	}
}
