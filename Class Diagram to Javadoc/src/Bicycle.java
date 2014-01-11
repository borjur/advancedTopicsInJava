/** 
 * Bicycle
 * Created Jan, 17, 2013
 * @author Boris Jurosevic
 * CS 2550 Class diagram to JavaDoc
 */

/**
 *this is bicycle class that extends abstract class vehicle
 */
public class Bicycle extends Vehicle{

	/**
	 * this is abstract method from vehicle that moves  the car
	 */
	@Override
	public void Move() {
		// TODO Auto-generated method stub
		System.out.println("the bicycle is moving...");
	}
	/**
	 * this is a stop method from vehicle that stops the car
	 */
	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("the bicycle is stoping...");
		
	}
	/**
	 * this is turn method from Vehicle that turns the car
	 */
	@Override
	public void Turn() {
		// TODO Auto-generated method stub
		System.out.println("the bicycle is turning...");
	}

}
