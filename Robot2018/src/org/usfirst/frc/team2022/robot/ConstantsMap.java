package org.usfirst.frc.team2022.robot;

/*
 * Easy place to access variables that need to be easily changed
 */

public class ConstantsMap {
	
	public static final boolean testing = true;
	

	public static final double TurtleSpeed = .4;
	
	//Robot dimensions
	public static final double ROBOT_LENGTH_INCHES = 36.5; 
	public static final double ROBOT_WIDTH_INCHES = 0; 
	public static final double ROBOT_WHEEL_RADIUS_INCHES = 6; 
	public static final double FrontElevatorTravel = 36.5;
	//public static final double FrontElevatorTravel = 18;

	public static final double SPROCKET= 1.5;
	//Grabber Speeds
	public static final double AutoGrabSpeed = 1;
	
	//Drive encoders
	public static final double DRIVE_ENCODER_DIST_PER_TICK = ((ROBOT_WHEEL_RADIUS_INCHES * Math.PI)/(128));
	public static final double DRIVE_SPEED_REDUCER_MULTIPLIER = 0.3;

	//Radius Elevator
	public static final double FRONTWHEEL_RADIUS_INCHES = 0;
	public static final double BACKWHEEL_RADIUS_sINCHES = 0;
	
	//Elevator encoders
	public static final double FRONTELEVATOR_ENCODER_DIST_PER_TICK = (32.5/1480018.0);
//	/public static finadl double BACKELEVATOR_ENCODER_DIST_PER_TICK = ((BACKWHEEL_RADIUS_INCHES * Math.PI)/(128));
	
	public static final double ElevatorManualSpeed = .5;
	
	
	//PID Values
	public static double KP_DRIVE_SPEED = .04;
	public static double KI_DRIVE_SPEED = 0;	
	public static double KD_DRIVE_SPEED = .01;
	public static double KF_DRIVE_SPEED = 0;
	public static double DRIVE_ERR_ABSTOLERANCE = .2;
	public static double DRIVE_ERR_BUFTOLERANCE = 15;
	public static double DRIVE_MIN_SPEED = -4;
	public static double DRIVE_MAX_SPEED = .4;
	
	public static double KP_DRIVESTRAIGHT_TURN = .2;
	public static double KI_DRIVESTRAIGHT_TURN = 0;//0.18;
	public static double KD_DRIVESTRAIGHT_TURN = 0;//0.23;
	public static double KF_DRIVESTRAIGHT_TURN = 0.0;
	
	public static double KP_DRIVE_TURN = .08;
	public static double KI_DRIVE_TURN = 0.001;//0.18;
	public static double KD_DRIVE_TURN = .02;//0.23;
	public static double KF_DRIVE_TURN = 0;
	public static double TURN_ERR_TOLERANCE = .025;
	public static double TURN_MIN_SPEED = -.5;
	public static double TURN_MAX_SPEED = .5;
	
	public static double KP_ELEVATOR = 0.1;
	public static double KI_ELEVATOR = 0;
	public static double KD_ELEVATOR = 0;
	public static double KF_ELEVATOR = 0;
	public static double ELEVATOR_ERR_TOLERANCE = .25;
	public static double ELEVATOR_MAX_SPEED = 1;

	//Dimensions
	public static double BASE_WIDTH = 27.75;
	public static double BASE_LENGTH = 32.75;
	
}