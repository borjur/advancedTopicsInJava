/** 
 * TestApp
 * Created Jan, 17, 2013
 * @author Boris Jurosevic
 * CS 2550 Class diagram to JavaDoc
 */

/**
 * main class
 */
public class TestApp {
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args){
		/**
		 * car1 object from car class
		 */
		Car car1 = new Car(12, 32);
		/**
		 * prints the runVehicle method from car class
		 */
		car1.runVehicle();
		
	/**
	 * car2 object from car class
	 */
		Car car2 = new Car(42,34);
		/**
		 * prints pressClutch method from a car class
		 */
		car2.PressClutch();
		/**
		 * prints opentaligate from a car class
		 */
		car2.OpenTaligate();
		Car car3 = new Car(233,232);
		/**
		 * prints use nitro method from a car class
		 */
		car3.UseNitro();
		/**
		 * axle1 object from a axle class
		 */
		Axle axle1 = new Axle(1.0,2.0);
		/**
		 * prints add wheel method using composition
		 */
		axle1.AddWheel();
		/**
		 * prints spinning a car using a spin method
		 */
		axle1.Spin(car1);
		/**
		 * wheel object from a wheel class
		 */
		Wheel wheel = new Wheel(1.0,2.0);
		/**
		 * prints rolling a car method from wheel class 
		 */
		wheel.Roll();
		
		
		
		
	}

}
