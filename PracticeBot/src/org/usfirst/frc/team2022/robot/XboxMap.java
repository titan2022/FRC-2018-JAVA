package org.usfirst.frc.team2022.robot;

public class XboxMap {
	OI oi = Robot.oi;
	
	public double getSpeedRightWheel()
	{
		return oi.xbox.getRightY();
	}
	
	public double getSpeedLeftWheel()
	{
		return oi.xbox.getLeftY();
	}
	
}
