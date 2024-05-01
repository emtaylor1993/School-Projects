public class MethodOverloadExample {
	private static void easyOne(int a) {
		System.out.println("in easyOne-int");
	}
	
	private static int easyOne(double a) {
		System.out.println("in easyOne-double");
		return (int) a;
	}
	
	private static void hardOne(int a, double b) {
		System.out.println("in hardOne-int, double");
	}
	
	private static int hardOne(double a, int b) {
		System.out.println("in hardOne-double,int");
		return (int)a + b;
	}
	
	public static void main(String[] args){
		int i=5; double d=3.5; long l=4; byte b=1; float f=2.2F;
		easyOne(i);
		easyOne(d);
		easyOne(l);
		easyOne(i+d);
		easyOne(b);
		hardOne(i,d);
		hardOne(d,i);
		hardOne(b,l);
		hardOne(b,f);
		hardOne(f,b);
//		hardOne(d,d);
//		hardOne(i,i);
	}
}
