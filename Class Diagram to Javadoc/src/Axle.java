/** 
 * Axle
 * Created Jan, 17, 2013
 * @author Boris Jurosevic
 * CS 2550 Class diagram to JavaDoc
 */

/**
 * this is a axle class that has a relationship with car
 */
public class Axle extends Car {

	/**
	 * private variable spinaxle using composition with a car class
	 */
	private Car spinAxle ;
	/**
	 * array variables that stores 4 wheels
	 */
	int [] wheels = {1,2,3,4};
	
	/**
	 * contructor from that is used in with same paramters as a car
	 * @param m_Mileage
	 * @param m_Speed
	 */
	public Axle(double m_Mileage, double m_Speed) {
		super(m_Mileage, m_Speed);
		// TODO Auto-generated constructor stub
	}

/**
 * returns a new spin axle
 * @return
 */
	public Car getSpinAxle() {
		return spinAxle;
	}

/**
 * sets a new spin axle
 * @param spinAxle
 */
	public void setSpinAxle(Car spinAxle) {
		this.spinAxle = spinAxle;
	}
	
	

	/**
	 * method that spins the car's wheels
	 * @param spinAxle
	 */
	public void Spin(Car spinAxle) {
		this.spinAxle = spinAxle;
		
		System.out.println("spins the car's axle"); 

}

	public void AddWheel(){
		
		for(int i=0; i < wheels.length; i++) {
	        System.out.println("the car can have " + wheels[i] + "wheels" );
	    }
	}
	
}