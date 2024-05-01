public class FirstClass {
	private int viFC;
	private static int vsFC;
	public int biFC;
	public static int bsFC;
	
	public void fiFC(){
		//viFC = 1;   	//FirstClass.viFC = 1;
		//vsFC = 2;   	//FirstClass.vsFC = 2;
		//biFC = 3;	  	//FirstClass.biFC = 3;
		//bsFC = 4;	  	//FirstClass.bsFC = 4;
		System.out.println("Values = " 
			//	+ viFC + " "
			//	+ vsFC + " "
			//	+ biFC + " "
			//	+ bsFC
		);
		
		//fsFC();			
		FirstClass varFC = new FirstClass();
		//varFC.viFC = 5;			//FirstClass.viFC = 9;
		//varFC.vsFC = 6;			//FirstClass.vsFC = 9;
		//varFC.biFC = 7;			//FirstClass.biFC = 9;
		//varFC.bsFC = 8;			//FirstClass.bsFC = 9;
	}
	
	public static void fsFC(){
		//viFC = 1;
		//vsFC = 2;
		//biFC = 3;
		//bsFC = 4;
		System.out.println("Values = " 
		//		+ viFC + " "
		//		+ vsFC + " "
		//		+ biFC + " "
		//		+ bsFC
		);
		
		//fiFC();
		FirstClass varFC = new FirstClass();
		//varFC.viFC = 5;			//FirstClass.viFC = 9;
		//varFC.vsFC = 6;			//FirstClass.vsFC = 9;
		//varFC.biFC = 7;			//FirstClass.biFC = 9;
		//varFC.bsFC = 8;			//FirstClass.bsFC = 9;
	}
}
