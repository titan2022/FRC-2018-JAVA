package org.usfirst.frc.team2022.robot;

public class Attack3Map {
	OI oi = Robot.oi;
	
	//Drive commands
	public double getSpeedRightWheel(){ 
		return oi.attack3.getYAxis();
	}
	
	public double getSpeedLeftWheel() {
		return oi.attack3.getY();
	}
	
//	public boolean startAutoBrakerSystem(){
//		return oi.xbox.GetRightBumperValue();
//	}
	
	/*public boolean switchySwitch(){
		return oi.attack3.GetRightBumperValue();
	}*/
	
	public boolean startAutoGearAlignment(){
		if(oi.attack3.getPOV() == 180){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	//Shooter commands	
	public boolean alignShooter(){
		return oi.attack3.Get2Value();
	}
	
	/*public boolean startManualShooterCommand(){
		//return oi.attack3.GetXValue(); 			Change! 
	}*/

//	public boolean openGate() {
//		return oi.xbox.GetBackValue();
//	}
	
	//Climber commands
	/*public double getManualClimberSpeed(){
		return oi.attack3.GetLeftTriggers();		Change!
	}*/
	
	
	//Camera command
	public boolean switchCamera(){
		return oi.attack3.GetStartValue();
	}
	
	
	//Universal stop command
	public boolean stopSystem() {
		return oi.attack3.GetStopValue();
	}

	/*public boolean moveToShooter() {
		// TODO Auto-generated method stub
		return oi.attack3.GetAValue();
	}*/
}