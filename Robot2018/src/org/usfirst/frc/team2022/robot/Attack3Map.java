package org.usfirst.frc.team2022.robot;

public class Attack3Map {
	OI oi = Robot.oi;
	
	//Drive commands
	public double getSpeedRightWheel(){ 
		return oi.attack3_R.getYAxis();
	}
	
	public double getSpeedLeftWheel() {
		return oi.attack3_L.getYAxis();
	}
	
	public boolean startAutoBrakerSystem(){
		return oi.attack3_R.get2Value();
	}
	
	public boolean controlDriverGear() {
		return oi.attack3_L.get2Value();
	}
	public boolean turtleButton (){
		
		return oi.attack3_L.get3Value();
	}
}