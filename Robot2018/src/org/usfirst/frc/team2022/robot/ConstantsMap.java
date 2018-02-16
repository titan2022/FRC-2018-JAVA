package org.usfirst.frc.team2022.robot;

/*
 * Easy place to access variables that need to be easily changed
 */

public class ConstantsMap {
	//Robot dimensions
	public static final double ROBOT_LENGTH_INCHES = 36.5; 

	//Encoders
	public static final double DRIVE_ENCODER_INCHES_PER_TICK = ((4* Math.PI)/(360));
	public static final double ELEVATOR_ENCODER_INCHES_PER_TICK = 1.0;

	//Distance and speeds
	public static final double GRABBER_SPEED = 3310;
	public static final double ELEVATOR_MAX_SPEED = 10;
	public static final double DRIVE_MAX_SPEED = 10;
	public static final double TURN_MAX_SPEED = 10;

	//PID Values
	public static double KP_DRIVE_SPEED = 1.0;
	public static double KI_DRIVE_SPEED = 0;
	public static double KD_DRIVE_SPEED = 4.5;
	public static double KF_DRIVE_SPEED = 0;
	public static double DRIVE_ERR_TOLERANCE = 1.0;
	//public static double KSPEED_DRIVE_SPEED = 0.5;
	
	public static double KP_DRIVE_TURN = 0.1;
	public static double KI_DRIVE_TURN = 0.7;//0.18;
	public static double KD_DRIVE_TURN = 0;//0.23;
	public static double KF_DRIVE_TURN = 0.7;
	public static double TURN_ERR_TOLERANCE = 1.0;
	//public static double KSPEED_DRIVE_TURN = 0.2;
	
	public static double KP_ELEVATOR = 0.1;
	public static double KI_ELEVATOR = 1.0;
	public static double KD_ELEVATOR = 0.1;
	public static double KF_ELEVATOR = 0;
	public static double ELEVATOR_ERR_TOLERANCE = 0.1;
	
	//Dimensions
	public static double BASE_WIDTH = 27.75;
	public static double BASE_LENGTH = 32.75;
	
}