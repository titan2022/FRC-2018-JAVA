/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.robot.triggers.Attack3;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//User interface Constants
	public double attackThrottleSensitivity=.1;
	//Controllers

	public Attack3 attack3_L, attack3_R;

	public OI(){
		attack3_L = new Attack3(0);
		attack3_R = new Attack3(1);

	}
}
