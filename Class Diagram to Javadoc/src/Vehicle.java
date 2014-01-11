/** 
 * Vehicle
 * Created Jan, 17, 2013
 * @author Boris Jurosevic
 * CS 2550 Class diagram to JavaDoc
 */

/**
 * this is a abstract class Vehicle
 */
public abstract class Vehicle {
	
	/**
	 * move method that moves car,bicycle, rollerskates
	 */
	public abstract void Move();
	/**
	 * stop method  that stops car,bicycle,rollerskates
	 */
	public abstract void Stop();
	
	/**
	 * turn method that turns car,bicycle,rollerskates
	 */
	public abstract void Turn();
	
	/**
	 * method that runs the vehicle that includes move,stop, and turn
	 */
	public void runVehicle(){
		Move();
		Stop();
		Turn();
	}

}
