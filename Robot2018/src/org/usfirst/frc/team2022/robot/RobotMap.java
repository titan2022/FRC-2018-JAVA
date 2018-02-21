package org.usfirst.frc.team2022.robot;

/**
 * This class is initialized in the Robot class and is referenced
 * in the subsystem classes. This class holds the variables to port 
 * numbers for sensors and motors.
 * 
 * Standard format for port number variables:
 * public static final portNumber = 0;
 */

public class RobotMap {
	
	//Drivebase Motor Ports 
	public static final int LEFT_DRIVE_PORT_1 = 2;
	public static final int LEFT_DRIVE_PORT_2 = 4;
	public static final int LEFT_DRIVE_PORT_3 = 3;
	public static final int RIGHT_DRIVE_PORT_1 = 8;
	public static final int RIGHT_DRIVE_PORT_2 = 9;
	public static final int RIGHT_DRIVE_PORT_3 = 10;
	
	//Grabber Motor Ports
	public static final int INNERLEFT_GRABBER_PORT = 5;
	public static final int INNERRIGHT_GRABBER_PORT = 11;
	
	//Elevator Motor Ports
	public static final int FRONT_ELEVATOR_PORT = 7;
	public static final int BACK_ELEVATOR_PORT = 0;
	
	//Limit switch ports
	public static final int BOX_SWITCH = 0;
	public static final int ELEVATOR_SWITCH = 0;
	
	//Encoder ports for drive base (looking at it from the back)
	public static final int LEFT_ENCODER_PORT_A = 0;
	public static final int LEFT_ENCODER_PORT_B = 1;
	public static final int RIGHT_ENCODER_PORT_A = 2;
	public static final int RIGHT_ENCODER_PORT_B = 3;
	
	//Solenoid ports
	public static final int SOLENOID_PORT_1 = 0; 
	public static final int SOLENOID_PORT_2 = 0;
}