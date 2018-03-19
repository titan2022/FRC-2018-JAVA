

package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.controller.Attack3;
import org.usfirst.frc.team2022.controller.Xbox;

public class OI {
	//User interface Constants
	public double attackThrottleSensitivity=.1;
	//Controllers

	public Attack3 attack3_L, attack3_R;
	
	public Xbox xbox;

	public OI(){
		attack3_L = new Attack3(0);
		attack3_R = new Attack3(1);
		
		xbox = new Xbox(2);

	}
}
