package org.usfirst.frc.team2022.robot;

public class XboxMap {
	OI oi = Robot.oi;
	
	//Drive commands
	public boolean in(){
		return oi.xbox.getRightBumperValue();
	}
	
	public boolean out() {
		return oi.xbox.getLeftBumperValue();
	}
	public boolean inTake(){
		return oi.xbox.getAValue();
	}
	
	public boolean outTake() {
		return oi.xbox.getBValue();
	}
	public double right() {
		return oi.xbox.getRightY();
	}
	public double left() {
		return oi.xbox.getLeftY();
	}

}