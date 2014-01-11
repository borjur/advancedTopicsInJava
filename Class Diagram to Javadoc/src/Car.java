/** 
 * Car
 * Created Jan, 17, 2013
 * @author Boris Jurosevic
 * CS 2550 Class diagram to JavaDoc
 */

/**
 *  and implements interfaces sportscar and stationwagon
 */
public class Car extends Vehicle implements SportsCar, StationWagon{
    
	/**
	 * mileage variable that is private
	 */
	private double m_Mileage;
	/**
	 * speed variable that is private
	 */
	private double m_Speed;
	/**
	 * this is the car constructor that has mileage and speed variables
	 * @param m_Mileage
	 * @param m_Speed
	 */
	public Car(double m_Mileage,double m_Speed){
		this.m_Mileage = m_Mileage;
		this.m_Speed = m_Speed;
	}

/**
 * this is abstract method from vehicle that moves  the car
 */
	@Override
	public void Move() {
		// TODO Auto-generated method stub
		System.out.println("The car is moving.");
	}
/**
 * this is a stop method from vehicle that stops the car
 */
	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("the car is stoping...");
	}
/**
 * this is turn method from Vehicle that turns the car
 */
	@Override
	public void Turn() {
		// TODO Auto-generated method stub
		System.out.println("The car is turning...");
	}
/*
 * (non-Javadoc)
 * this is method OpenTaligate from stationwagon interface that opens the taligate
 * @see StationWagon#OpenTaligate()
 */
	@Override
	public void OpenTaligate() {
		// TODO Auto-generated method stub
		System.out.println("opens taligate");
	}

/**
 * this is a set void method for mileage that sets the new mileage
 * @param m_Mileage
 */

	public void setMileage(double m_Mileage) {
		this.m_Mileage = m_Mileage;
	}
/**
 * this is getSpeed method that returns the new speed
 * @return
 */
	public double getSpeedMPH() {
		return m_Speed;
	}
/**
 * this is a set speed method that sets new speed in mph
 * @param m_Speed
 */
	public void setSpeedMPH(double m_Speed) {
		this.m_Speed = m_Speed;
	}
	/**
	 * this is a set speed method that sets new speed in mpk
	 * @param m_Speed
	 */	
	public void setSpeedMPK(double m_Speed) {
		this.m_Speed = m_Speed;
		
	}
/**
 * this is press clutch method that that returns pressing the clutch from sports car interface
 */
	@Override
	public void PressClutch() {
		// TODO Auto-generated method stub
		System.out.println("the car is pressing clutch and the mileage is " + m_Mileage + "MPH" );
	}
	/**
	 * this is a use nitro method that that returns using the nitro from sports car interface
	 */
	@Override
	public void UseNitro() {
		// TODO Auto-generated method stub
		System.out.println("the car is using nitro with the speed of " + m_Speed + "MPH" );
	}
	

	/**
	 * sting represention of car
	 */
	public String toString(){
		return String.format("%d","%d", m_Mileage, m_Speed);


	}

	
}