package org.usfirst.frc.team2022.robot.commands;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.robot.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
*
*/
public class GrabberCommand extends Command{
	GrabberSubsystem grabberSubsystem = Robot.grabberSubsystem;
	XboxMap xboxMap = new XboxMap();
	OI oi = Robot.oi;
		
	boolean brakeState = true;
	long lastPressed = 0;
	double turtleSpeed = 0.3;
	boolean turtle = false;
	
    public GrabberCommand() {
        // Use requires() here o declare subsystem dependencies
        // eg. requires(chassis);
    	requires(grabberSubsystem);
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
    	
    	SmartDashboard.putBoolean("Limit Switch", grabberSubsystem.getLimitSwitch());

//    	if(xboxMap.switchySwitch()) {
//    		grabberSubsystem.switchTheSwitchySwitch();
//    	}
    	
    	//Autonomous gear
//    	if(xboxMap.startAutoGearAlignment()){
//    		Timer.delay(1);
//    		
//        	double pegAngle = VisionTable.getPegAngle();
//      		AutoDriveTurnCommand autoDriveTurnCommand = new AutoDriveTurnCommand(pegAngle-6);
//      		autoDriveTurnCommand.start();
//    	}
    	
    	if(oi.xbox.getPOV() == 90){ //Joystick up, shoot cube
    		grabberSubsystem.setLeftSpeed(turtleSpeed);
        	grabberSubsystem.setRightSpeed(turtleSpeed);
        	grabberSubsystem.shootCube();
    	}
    	else if (oi.xbox.getPOV() == 270){ //Joystick down, accept cube
    		grabberSubsystem.setLeftSpeed(turtleSpeed);
        	grabberSubsystem.setRightSpeed(turtleSpeed);
        	grabberSubsystem.takeCube();
    	}
    	else if(turtle){
    		grabberSubsystem.setLeftSpeed(speedLeft * turtleSpeed);
        	grabberSubsystem.setRightSpeed(speedRight * turtleSpeed);

    	}
    	else{
    		grabberSubsystem.setLeftSpeed(speedLeft);
        	grabberSubsystem.setRightSpeed(speedRight);

    	}
    	
    	if(xboxMap.stopSystem()){
 		
    	}
    	
    	//Brake
//    	if(brakeState){
//			grabberSubsystem.enableBrake();
//		}
//		else if(!brakeState){
//			grabberSubsystem.disableBrake();
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
    	grabberSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	grabberSubsystem.stop();
    }
}
