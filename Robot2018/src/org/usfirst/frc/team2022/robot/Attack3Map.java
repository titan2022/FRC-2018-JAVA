package org.usfirst.frc.team2022.robot;

public class Attack3Map {
	OI oi = Robot.oi;
	
	//Drive commands
	public double getSpeedRightWheel(){ 
		return oi.attack3Right.getY();
	}
	
	public double getSpeedLeftWheel() {
		return oi.attack3Left.getY();
	}
}