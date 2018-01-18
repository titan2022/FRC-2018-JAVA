package org.usfirst.frc.team2022.command;


import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystem.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class DriveCommand extends Command {
	
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	XboxMap xboxMap = new XboxMap();
	OI oi = Robot.oi;
		
	boolean brakeState = true;
	long lastPressed = 0;
	double turtleSpeed = 0.3;
	boolean turtle = false;
	
    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveSubsystem);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    	
    	double speedLeft = xboxMap.getSpeedLeftWheel();   
    	
    	if(Math.abs(speedLeft) < 0.1){
    		speedLeft = 0;
    	}
    	

    	double speedRight = xboxMap.getSpeedRightWheel();
    	if(Math.abs(speedRight) < 0.1){
    		speedRight = 0; 
    	}
    	
    	if(oi.xbox.GetRightBumperValue() && System.currentTimeMillis() - lastPressed > 200){
    		turtle = !turtle;
    		lastPressed = System.currentTimeMillis();
    	}
    	if(turtle) {
    		driveSubsystem.setLeftSpeed(speedLeft*turtleSpeed);
    		driveSubsystem.setRightSpeed(speedRight*turtleSpeed);
    	}
    	else {
    		driveSubsystem.setLeftSpeed(speedLeft);
    		driveSubsystem.setRightSpeed(speedRight);
    	}
    	
    	/*if(oi.xbox.getPOV() == 0){
    		driveSubsystem.setLeftSpeed(-turtleSpeed);
        	driveSubsystem.setRightSpeed(turtleSpeed);
    	}
    	else if (oi.xbox.getPOV() == 180){
    		driveSubsystem.setLeftSpeed(turtleSpeed);
        	driveSubsystem.setRightSpeed(-turtleSpeed);
    	}
    	else if(turtle){
    		driveSubsystem.setLeftSpeed(speedLeft * turtleSpeed);
        	driveSubsystem.setRightSpeed(speedRight * turtleSpeed);

    	}
    	else{
    		driveSubsystem.setLeftSpeed(speedLeft);
        	driveSubsystem.setRightSpeed(speedRight);

    	}*/
    	
    	if(xboxMap.moveTowardsGear()){
//    		
    	}
    	
    	if(xboxMap.stopSystem()){
 		
    	}
    	
    	//Brake
//    	if(brakeState){
//			driveSubsystem.enableBrake();
//		}
//		else if(!brakeState){
//			driveSubsystem.disableBrake();
//		}
    	
//    	if(xboxMap.startAutoBrakerSystem() && (System.currentTimeMillis()-lastPressed)>200){  
//    		
//    		brakeState = !brakeState;
//    		lastPressed = System.currentTimeMillis();
//    	}
    	    	    	
    
    }

    // Make this return true when this Command no longer needs to run execute()
    
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveSubsystem.stop();
    }
}
