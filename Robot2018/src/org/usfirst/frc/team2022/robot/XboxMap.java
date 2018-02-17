package org.usfirst.frc.team2022.robot;

public class XboxMap {
	OI oi = Robot.oi;
	
	public boolean startAutoBrakerSystem(){
		return oi.xbox.GetRightBumperValue();
	}
	
	public boolean controlDriverGear() {
		return oi.xbox.GetLeftBumperValue();
	}
	
	//Grabber commands 
	public boolean controlOutterMotors(){
		return oi.xbox.GetAValue();
	}
	
	public boolean controlInnerMotors(){
		return oi.xbox.GetBValue();
	}
	
	public boolean controlPiston(){
		return oi.xbox.GetXValue();
	}
	
	//Elevator commands
	public boolean controlFrontElevator(){
		return oi.xbox.GetYValue();
	}
	public double controlBackElevatorGoUp(){
		return oi.xbox.GetLeftTriggers();
	}
	public double controlBackElevatorGoDown(){
		return oi.xbox.GetRightTriggers();
	}
	
	//Universal stop command
	public boolean stopSystem() {
		return oi.xbox.GetYValue();
	}
}