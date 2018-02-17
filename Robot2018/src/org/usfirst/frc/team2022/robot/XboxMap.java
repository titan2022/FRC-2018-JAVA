package org.usfirst.frc.team2022.robot;

public class XboxMap {
	OI oi = Robot.oi;
	

	public boolean startAutoBrakerSystem(){
		return oi.xbox.getRightBumperValue();

	}
	
	public boolean controlDriverGear() {
		return oi.xbox.getLeftBumperValue();
	}
	
	//Grabber commands 
	public boolean controlOutterMotors(){
		return oi.xbox.getAValue();
	}
	

	public boolean controlInnerMotors(){
		return oi.xbox.getBValue();

	}
	

	public boolean controlPiston(){
		return oi.xbox.getXValue();

	}


	//Elevator commands
	public boolean controlFrontElevator(){
		return oi.xbox.getYValue();
	}
	public double controlBackElevatorGoUp(){
		return oi.xbox.getLeftTriggers();

	}

	public double controlBackElevatorGoDown(){
		return oi.xbox.getRightTriggers();

	}
	
	//Universal stop command
	public boolean stopSystem() {
		return oi.xbox.getYValue();
	}

}