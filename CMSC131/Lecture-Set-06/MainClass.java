public class MainClass {
	private int viMC;
	private static int vsMC;
	public int biMC;
	public static int bsMC;
	
	public void fiMC() {
		// viMC = 1;	vsMC = 2;	biMC = 3;	bsMC = 4;
		// System.out.println("Values = "+ viMC + " "+ vsMC + " " + biMC + " "+ bsMC);
		// fsMC();    
		// MainClass.fsMC();
	}
	
	public static void fsMC() {
		// viMC = 1;	vsMC = 2;	biMC = 3;	bsMC = 4;
		// System.out.println("Values = "+ viMC + " "+ vsMC + " " + biMC+ " "	+ bsMC);
		// fiMC();
	}
	
	public static void main(String[] args) {
		// Methods of another class
		FirstClass var1FC = new FirstClass();
		// fiFC();	
		// FirstClass.fiFC();	
		// var1FC.fiFC();
		// fsFC();	
		// FirstClass.fsFC();	
		// var1FC.fsFC();
		
		// Methods of the current class
		MainClass var1MC = new MainClass();
		// fiMC();	
		// MainClass.fiMC();		
		// var1MC.fiMC();
		// fsMC();	
		// MainClass.fsMC();		
		// var1MC.fsMC();	
		// data members of another class
		// var1FC.viFC = 7;  	
		// FirstClass.viFC = 12;
		// var1FC.vsFC = 7;		
		// FirstClass.vsFC = 12;
		// var1FC.biFC = 7;		
		// FirstClass.biFC = 12;
		// var1FC.bsFC = 7;		
		// FirstClass.bsFC = 12;
		
		// Data members of the current class
		// var1MC.viMC = 8;		
		// MainClass.viMC = 99;
		// var1MC.vsMC = 8;		
		// MainClass.vsMC = 99;
		// var1MC.biMC = 8;		
		// MainClass.biMC = 99;
		// var1MC.bsMC = 8;		
		// MainClass.bsMC = 99;
	}
}
