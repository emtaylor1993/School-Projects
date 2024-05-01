public class CatLady {
	private String name;
	private Cat[] cats;
	
	public CatLady(String name, int numberOfCats) {
		this.name = name;
		cats = new Cat[numberOfCats];
		
		for (int ind = 0; ind < cats.length; ind++) {
			cats[ind] = new Cat("CAT " + (ind + 1));
		}
	}
	
	public CatLady(CatLady otherLady){
		name = otherLady.name;
		cats = new Cat[otherLady.cats.length];
		
		for (int ind = 0; ind < cats.length; ind++){
			cats[ind] = new Cat(otherLady.cats[ind]);
		}
	}
	
	public Cat[] getCats(){
		Cat[] locCats = new Cat[cats.length];
		
		for (int ind = 0; ind < cats.length; ind++){
			locCats[ind] = new Cat(cats[ind]);
		}
		
		return locCats;
	}
	
	public void showCats() {
		System.out.println("I am " + name);
		System.out.println("Here are my cats:");
		
		for (int ind = 0; ind < cats.length; ind++) {
			System.out.println(cats[ind]);
		}
	}
	
	public static boolean oneLifeLess(Cat[] catArr) {
		if (catArr == null  || catArr.length == 0 ) {
			return false;
		}
		
		for (int ind = 0; ind < catArr.length; ind++) {
			catArr[ind].beEatenByADog();
		}	
		
		return true;
	}
	
	public static boolean oneLifeLess(Cat oneCat) {
		if (oneCat == null ){
			return false;
		}	
		
		oneCat.beEatenByADog();
		return true;
	}
	
	public static boolean oneLifeLess(int oneCatLife) {
		oneCatLife -= 1;   
		return true;
	}
	
	public static void main(String[] args) {
		CatLady x = new CatLady("Anabel", 13);
		x.showCats();
		oneLifeLess(x.cats);
		x.showCats();
		oneLifeLess(x.cats[0]);
		x.showCats();
		oneLifeLess(x.cats[0].getLives());
		x.showCats();
		CatLady y = new CatLady(x);
		Cat[] list = x.getCats();
	}
}
