/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2022.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Drivebase Motor Ports 
	public static final int LEFT_DRIVE_PORT_1 = 2;
	public static final int LEFT_DRIVE_PORT_2 = 4;
	public static final int LEFT_DRIVE_PORT_3 = 3;
	public static final int RIGHT_DRIVE_PORT_1 = 8;
	public static final int RIGHT_DRIVE_PORT_2 = 9;
	public static final int RIGHT_DRIVE_PORT_3 = 10;
	
	//Encoder ports for drive base
	public static final int LEFT_ENCODER_PORT_A = 0;
	public static final int LEFT_ENCODER_PORT_B = 1;
	public static final int RIGHT_ENCODER_PORT_A = 2;
	public static final int RIGHT_ENCODER_PORT_B = 3;
	
}