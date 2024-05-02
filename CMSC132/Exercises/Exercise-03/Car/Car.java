package Car;

public abstract class Car {
    private String brand;

    Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public abstract void start();

    public static Car makeHybridCar() {
        Car hybridCar = new Car("Ford") {
            int BatteryPower = 1000;

	        public void start() {
	            BatteryPower -= 25;
	        }
	  
	        public String toString() {
	            String hybridString = "";
	            hybridString += "Ford " + BatteryPower;
	      
	            return hybridString;
	        }
        };
	
        return hybridCar;
    }
  
    public static void main(String args[]) {
        Car aCar = makeHybridCar();
    
        aCar.start();
        aCar.start();
        aCar.start();

        System.out.println(aCar);  
    }
}