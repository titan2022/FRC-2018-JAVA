package org.usfirst.frc.team2022.robot;

public class XboxMap {
	OI oi = Robot.oi;
	
	//Drive commands
	public double getSpeedRightWheel(){ 
		return oi.xbox.getRightY();
	}
	
	public double getSpeedLeftWheel() {
		return oi.xbox.getLeftY();
	}
	
//	public boolean startAutoBrakerSystem(){
//		return oi.xbox.GetRightBumperValue();
//	}
	
	public boolean switchySwitch(){
		return oi.xbox.getRightBumperValue();
	}
	
	public boolean startAutoGearAlignment(){
		if(oi.xbox.getPOV() == 180){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	//Shooter commands	
	public boolean alignShooter(){
		return oi.xbox.getBValue();
	}
	
	public boolean startManualShooterCommand(){
		return oi.xbox.getXValue();
	}

//	public boolean openGate() {
//		return oi.xbox.GetBackValue();
//	}
	
	//Climber commands
	public double getManualClimberSpeed(){
		return oi.xbox.getLeftTriggers();
	}
	
	
	//Camera command
	public boolean switchCamera(){
		return oi.xbox.getStartValue();
	}
	
	
	//Universal stop command
	public boolean stopSystem() {
		return oi.xbox.getYValue();
	}

	public boolean runAgitator() {
		// TODO Auto-generated method stub
		if(oi.xbox.getRightTriggers() > 0.4){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean moveTowardsGear() {
		// TODO Auto-generated method stub
		return oi.xbox2.getAValue();
//		if(oi.xbox.getPOV() == 0){
//			return true;
//		}
//		else{
//			return false;
//		}
	}

	public boolean moveToShooter() {
		// TODO Auto-generated method stub
		return oi.xbox2.getAValue();
	}
}