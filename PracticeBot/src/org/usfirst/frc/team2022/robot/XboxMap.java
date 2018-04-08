package org.usfirst.frc.team2022.robot;

public class XboxMap {
	OI oi = Robot.oi;
	

	//Drive commands
	public boolean piston(){
		return oi.xbox.getLeftBumperValue();
	}

	
	public boolean inTake(){
		return oi.xbox.getAValue();
	}
	public double Grab() {
		return oi.xbox.getLeftY();
	}
	public boolean outTake() {
		return oi.xbox.getBValue();
	}
	public double actuate() {
		return oi.xbox.getRightY();
	}
	public double right() {
		return oi.ps4.getRightY();
	}
	public double left() {
		return oi.ps4.getLeftY();
	}

}

