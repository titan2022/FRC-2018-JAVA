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

	//Drivebase Motor Ports 
	public static final int LEFT_DRIVE_PORT_1 = 4;
	public static final int LEFT_DRIVE_PORT_2 = 5;
	public static final int LEFT_DRIVE_PORT_3 = 6;
	public static final int RIGHT_DRIVE_PORT_1 = 7;
	public static final int RIGHT_DRIVE_PORT_2 = 8;
	public static final int RIGHT_DRIVE_PORT_3 = 9;
	
	//Encoder ports for drive base
	public static final int LEFT_ENCODER_PORT_A = 0;
	public static final int LEFT_ENCODER_PORT_B = 1;
	public static final int RIGHT_ENCODER_PORT_A = 2;
	public static final int RIGHT_ENCODER_PORT_B = 3;
	
}
