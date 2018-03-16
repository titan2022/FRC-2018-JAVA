package org.usfirst.frc.team2022.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Xbox extends Joystick{
	
	private static final int LEFT_XAXIS = 0;
	private static final int LEFT_YAXIS = 1;
	private static final int RIGHT_XAXIS = 4;
	private static final int RIGHT_YAXIS = 5;
	
	
	public Xbox(int port)
	{
		super(port);
	}
	
	public double getLeftX()
	{
		return (getRawAxis(LEFT_XAXIS));
	}
	
	public double getLeftY()
	{
		return (getRawAxis(LEFT_YAXIS));
	}
	
	public double getRightX()
	{
		return (getRawAxis(RIGHT_XAXIS));
	}
	
	public double getRightY()
	{
		return (-1 * getRawAxis(RIGHT_YAXIS));
	}
}
