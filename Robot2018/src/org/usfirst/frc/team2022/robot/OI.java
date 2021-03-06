package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.controller.Attack3;
import org.usfirst.frc.team2022.controller.Xbox;

/**
* This class is the glue that binds the controls on the physical operator
* interface to the commands and command groups that allow control of the robot.
*/
public class OI {
	//User interface Constants
	public double attackThrottleSensitivity=.1;
	//Controllers
	public Xbox xbox,ps4;

	public Attack3 attack3_L, attack3_R;

	public OI(){
		xbox = new Xbox(0);
		ps4 = new Xbox(1);

		//attack3_L = new Attack3(3);
		//attack3_R = new Attack3(4);

	}
}