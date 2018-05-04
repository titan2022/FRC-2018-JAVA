package org.usfirst.frc.team2022.robot;

/*
 * Easy place to access variables that need to be easily changed
 */

public class ConstantsMap {
	
	public static final boolean testing = true;

	public static final double TurtleSpeed = .7;
	
	
	//Presets
	public static final double ElevatorSwitchHeight = 40;
	public static final double ElevatorScaleNormalHeight = (12*5) + 10;
	public static final double ElevatorScaleHighHeight = (12*6) + 10;
	public static final double ElevatorPortalHeightHeight = (12*3) + 10;
	
	//Robot dimensions
	public static final double ROBOT_LENGTH_INCHES = 36.5; 
	public static final double ROBOT_WIDTH_INCHES = 0; 
	public static final double ROBOT_WHEEL_RADIUS_INCHES = 6; 
	public static final double FrontElevatorTravel = 34;
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
	public static final double FRONTELEVATOR_ENCODER_DIST_PER_TICK = (30/1963959.0);
	public static final double GRABBER_ENCODER_ANGLE_PER_TICK = (90/92819.0);
//	/public static finadl double BACKELEVATOR_ENCODER_DIST_PER_TICK = ((BACKWHEEL_RADIUS_INCHES * Math.PI)/(128));
	
	public static final double ElevatorManualSpeed	 = 1;
	public static final double GrabberManualSpeed	 = 1;
	
	public static final int DRIVE_TICKS_PER_REV = 256;
	
	
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
	
	public static double KP_DRIVE_TURN = .13;
	public static double KI_DRIVE_TURN = 0;//0.18;
	public static double KD_DRIVE_TURN = .13;//0.23;
	public static double KF_DRIVE_TURN = .1;
	public static double TURN_ERR_TOLERANCE = .02;
	public static double TURN_MIN_SPEED = -.6;
	public static double TURN_MAX_SPEED = .6;
	
	public static double KP_ELEVATOR = 0.1;
	public static double KI_ELEVATOR = 0;
	public static double KD_ELEVATOR = 0;
	public static double KF_ELEVATOR = 0;
	public static double ELEVATOR_ERR_TOLERANCE = .25;
	public static double ELEVATOR_MAX_SPEED = .4;
	
	public static double KP_GRABBER = .1;
	public static double KI_GRABBER = 0;
	public static double KD_GRABBER = 0;
	public static double KF_GRABBER = 0;
	public static double GRABBER_ERR_TOLERANCE = .25;
	public static double GRABBER_MAX_SPEED = .5;
	public static double GrabberSpeed = .9;
	//Dimensions
	public static double BASE_WIDTH = 27.75;
	public static double BASE_LENGTH = 32.75;
	
}