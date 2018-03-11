package org.usfirst.frc.team2022.robot;

public class XboxMap {
	OI oi = Robot.oi;
	
	//Drive commands
	public boolean startAutoBrakerSystem(){
		return oi.xbox.getRightBumperValue();
	}
	
	public boolean controlDriverGear() {
		return oi.xbox.getLeftBumperValue();
	}
	
	//Grabber commands 
	public double controlUpperGrabberOut(){
		return oi.xbox.getRightTriggers();
	}
	
	public double controlUpperGrabberIn(){
		return oi.xbox.getLeftTriggers();
	}

	//Elevator commands
	public double controlFrontElevator(){
		return oi.xbox.getRightY();
	}
	
	public boolean startAutoElevatorBrakerSystem() {
		return oi.xbox.getStartValue();
	}

	//Universal stop command
	public boolean stopSystem() {
		return oi.xbox.getBackValue();
	}
	
	//Presets
	public boolean switchPreset() {
		return oi.xbox.getAValue();
	}
	public boolean scaleNormalPreset() {
		return oi.xbox.getBValue();
	}
	public boolean scaleHighPreset() {
		return oi.xbox.getBValue();
	}
}