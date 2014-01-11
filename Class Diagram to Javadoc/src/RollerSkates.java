/** 
 * RollerSkates
 * Created Jan, 17, 2013
 * @author Boris Jurosevic
 * CS 2550 Class diagram to JavaDoc
 */
/**
 * this is rollerskates class that extends abstract class vehicle
 */
public class RollerSkates extends Vehicle{

	/**
	 * this is abstract method from vehicle that moves  the car
	 */
	@Override
	public void Move() {
		// TODO Auto-generated method stub
		System.out.println("Roller skates are moving");
	}
	/**
	 * this is a stop method from vehicle that stops the car
	 */
	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("Roller skates are stoping...");
	}
	/**
	 * this is turn method from Vehicle that turns the car
	 */
	@Override
	public void Turn() {
		// TODO Auto-generated method stub
		System.out.println("Roller skates are turning");
	}

}
