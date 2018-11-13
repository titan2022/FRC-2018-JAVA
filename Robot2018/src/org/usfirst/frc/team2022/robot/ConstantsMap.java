package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.robot.Unit.UnitType;

/*
 * Easy place to access variables that need to be easily changed
 */

public class ConstantsMap {
	
	public static final boolean testing = true;

	public static final double TurtleSpeed = .7;
	
	//Presets
	public static final Unit ElevatorSwitchHeight = new Unit(40.0d, UnitType.INCHES);
	public static final Unit ElevatorScaleNormalHeight = new Unit((12*5) + 10.0d, UnitType.INCHES);
	public static final Unit ElevatorScaleHighHeight = new Unit((12*6) + 10.0d, UnitType.INCHES);
	public static final Unit ElevatorPortalHeightHeight = new Unit((12*3) + 10.0d, UnitType.INCHES);
	
	//Robot dimensions
	public static final Unit ROBOT_LENGTH = new Unit(36.5d, UnitType.INCHES); 
	public static final Unit ROBOT_WIDTH = new Unit(28.0d, UnitType.INCHES); 
	public static final Unit ROBOT_WHEEL_RADIUS = new Unit(6.0d, UnitType.INCHES);
	public static final Unit FrontElevatorTravel = new Unit(34.0d, UnitType.INCHES);
	//public static final double FrontElevatorTravel = 18;
	//Grabber Speeds
	public static final double AutoGrabSpeed = 1;

	public static final int DRIVE_TICKS_PER_REV = 128;
	
	//Drive encoders
	public static final Unit DRIVE_ENCODER_DIST_PER_TICK = new Unit((ROBOT_WHEEL_RADIUS.getValueAs(UnitType.INCHES) * Math.PI)/(DRIVE_TICKS_PER_REV), UnitType.INCHES);
	public static final Unit DRIVE_SPEED_REDUCER_MULTIPLIER = new Unit(0.3d, UnitType.INCHES);
	
	//Elevator encoders
	public static final double FRONTELEVATOR_ENCODER_DIST_PER_TICK = (30/1963959.0);
	public static final double GRABBER_ENCODER_ANGLE_PER_TICK = (90/92819.0);
	
	public static final double ElevatorManualSpeed	 = 1;
	public static final double GrabberManualSpeed	 = 1;
	
	
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
	
	// Motion Values for Pathfinder
	// Not currently in the Unit class, as that currently handles only units of length
	public static final double PATHFINDER_MAX_VEL   = 0.5; // m/s (probably)
	public static final double PATHFINDER_MAX_ACCEL = 0.5; // m/s2 (probably)
	public static final double PATHFINDER_MAX_JERK  = 0.5; // m/s3 (probably)
	public static final double PATHFINDER_KP = 1.0;
	public static final double PATHFINDER_KI = 0.0;
	public static final double PATHFINDER_KD = 1.0;
}