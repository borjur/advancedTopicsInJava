/** 
 * Wheel
 * Created Jan, 17, 2013
 * @author Boris Jurosevic
 * CS 2550 Class diagram to JavaDoc
 */

/**
 * this is a wheel class that has a relationshiop with the axle
 */
public class Wheel extends Axle{
	
	/**
	 * array of rollwheels
	 */
	int[] rollWheels = new int [2];
	
	


	/**
	 * contructor from that is used in with same paramters as a car
	 * @param m_Mileage
	 * @param m_Speed
	 */	
public Wheel(double m_Mileage, double m_Speed) {
		super(m_Mileage, m_Speed);
		// TODO Auto-generated constructor stub
	}

/**
 * this is roll void method that has a composition with axle
 * @param rollWheel
 */
	public void Roll(){
		
		/**
		 * first array which holds 1
		 */
		rollWheels[0] = 1;
		/**
		 * second array which holds 2
		 */
		rollWheels[1] = 2;

		/**
		 * prints the first array
		 */
		System.out.println("the car rolls" + rollWheels[0] + "wheeel");
		
	}

}
