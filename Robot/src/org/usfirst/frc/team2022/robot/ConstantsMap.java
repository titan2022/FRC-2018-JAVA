package org.usfirst.frc.team2022.robot;

/*
 * Easy place to access variables that need to be easily changed
 */

public class ConstantsMap {

	//Robot dimensions
	public static final double ROBOT_LENGTH_INCHES = 36.5; 

	//Drive encoders
	public static final double DRIVE_ENCODER_DIST_PER_TICK = ((4* Math.PI)/(360));

	//Distance and speeds
	public static final double DIST_TO_SHOOT = 55;
	public static final double SHOOTING_SPEED = 31000;
	public static final double CLIMBER_SPEED = 0; 

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
	public static double KSPEED_DRIVE_TURN = 0.25;
	
	public static double KP_SHOOTER_SPEED = 0.0001;
	public static double KI_SHOOTER_SPEED = 0;
	public static double KD_SHOOTER_SPEED = 0.302;
	public static double KF_SHOOTER_SPEED = 0;

}
