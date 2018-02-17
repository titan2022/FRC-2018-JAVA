package org.usfirst.frc.team2022.robot;

/*
 * Easy place to access variables that need to be easily changed
 */

public class ConstantsMap {
	//Robot dimensions
	public static final double ROBOT_LENGTH_INCHES = 36.5; 
	public static final double ROBOT_WIDTH_INCHES = 0; 
	public static final double ROBOT_WHEEL_RADIUS_INCHES = 4; 

	//Grabber Speeds
	public static final double OUTTER_GRABBER_SPEED = 0.3;
	public static final double INNER_GRABBER_SPEED = 0.3;
	
	//Drive encoders
	public static final double DRIVE_ENCODER_DIST_PER_TICK = ((ROBOT_WHEEL_RADIUS_INCHES * Math.PI)/(360));
	
	public static final double DRIVE_SPEED_REDUCER_MULTIPLIER = 0.3;

	//Radius Elevator
	public static final double FRONTWHEEL_RADIUS_INCHES = 0;
	public static final double BACKWHEEL_RADIUS_INCHES = 0;
	//Elevator encoders
	public static final double FRONTELEVATOR_ENCODER_DIST_PER_TICK = ((FRONTWHEEL_RADIUS_INCHES * Math.PI)/(360));
	public static final double BACKELEVATOR_ENCODER_DIST_PER_TICK = ((BACKWHEEL_RADIUS_INCHES * Math.PI)/(360));
	
	//PID Values
	public static double KP_DRIVE_ANGLE = 0.1;
	public static double KI_DRIVE_ANGLE = 0;
	public static double KD_DRIVE_ANGLE = 0.05; 
	public static double KF_DRIVE_ANGLE = 0;
	
	public static double KP_DRIVE_SPEED = 1.0;
	public static double KI_DRIVE_SPEED = 0;
	public static double KD_DRIVE_SPEED = 4.5;
	public static double KF_DRIVE_SPEED = 0;
	public static double KSPEED_DRIVE_SPEED = 0.5;
	
	public static double KP_DRIVE_TURN = 0.1;
	public static double KI_DRIVE_TURN = 0.7;//0.18;
	public static double KD_DRIVE_TURN = 0;//0.23;
	public static double KF_DRIVE_TURN = 0.7;
	public static double KSPEED_DRIVE_TURN = 0.2;
	
	public static double KP_SHOOTER_SPEED = 0.0013;
	public static double KI_SHOOTER_SPEED = 1e-9;
	public static double KD_SHOOTER_SPEED = 0.01;
	public static double KF_SHOOTER_SPEED = 0.635;
	
	//Dimensions
	public static double BASE_WIDTH = 27.75;
	public static double BASE_LENGTH = 32.75;
	
}