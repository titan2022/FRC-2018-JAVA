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
	public boolean controlUpperGrabberOut(){
		return oi.xbox.getAValue();
	}
	
	public double controlUpperGrabberIn(){
		return oi.xbox.getRightTriggers();
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
		return oi.xbox.getYValue();
	}
}