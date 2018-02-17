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
	public static final int LEFT_DRIVE_PORT_1 = 4;
	public static final int LEFT_DRIVE_PORT_2 = 5;
	public static final int LEFT_DRIVE_PORT_3 = 6;
	public static final int RIGHT_DRIVE_PORT_1 = 7;
	public static final int RIGHT_DRIVE_PORT_2 = 8;
	public static final int RIGHT_DRIVE_PORT_3 = 9;
	
	//Grabber Motor Ports
	public static final int OUTTERLEFT_GRABBER_PORT = 0;
	public static final int OUTTERRIGHT_GRABBER_PORT = 0;
	public static final int INNERLEFT_GRABBER_PORT = 0;
	public static final int INNERRIGHT_GRABBER_PORT = 0;
	
	//Elevator Motor Ports
	public static final int FRONT_ELEVATOR_PORT = 0;
	public static final int BACK_ELEVATOR_PORT = 0;
	
	//Limit switch ports
	public static final int BOX_SWITCH = 0;
	
	//Encoder ports for drive base
	public static final int LEFT_ENCODER_PORT_A = 7;
	public static final int LEFT_ENCODER_PORT_B = 6;
	public static final int RIGHT_ENCODER_PORT_A = 9;
	public static final int RIGHT_ENCODER_PORT_B = 8;
	
	//Encoder ports for Elevator
	public static final int FRONT_ENCODER_PORT_A = 0;
	public static final int FRONT_ENCODER_PORT_B = 0;
	public static final int BACK_ENCODER_PORT_A = 0;
	public static final int BACK_ENCODER_PORT_B = 0;
	
	//Grabber Solenoid ports
	public static final int SOLENOID_PORT_1 = 0; 
	public static final int SOLENOID_PORT_2 = 0;
	public static final int SOLENOID_PORT_3 = 0;
	public static final int SOLENOID_PORT_4 = 0;
	
}