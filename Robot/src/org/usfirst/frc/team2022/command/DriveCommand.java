package org.usfirst.frc.team2022.command;

import org.usfirst.frc.team2022.command.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.command.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystem.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveCommand extends Command {
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	XboxMap xboxMap = new XboxMap();
	boolean brakeState = true;
	AutoDriveStraightCommand autoDriveStraightCommand;
	AutoDriveTurnCommand autoDriveTurnCommand;
	
	long lastPressed = 0;
	
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
    	driveSubsystem.setLeftSpeed(speedLeft);

    	double speedRight = xboxMap.getSpeedRightWheel();
    	if(Math.abs(speedRight) < 0.1){

    		speedRight = 0; 
    	}
    	driveSubsystem.setRightSpeed(speedRight);
    	
    	if(xboxMap.startAutoGearPlacement()){
//    		new AutoGearCommandGroup();
    		autoDriveStraightCommand = new AutoDriveStraightCommand(120);
    		autoDriveStraightCommand.start();
//    		autoDriveTurnCommand = new AutoDriveTurnCommand(90, 0.2);
//    		autoDriveTurnCommand.start();
//    		autoDriveTurnCommand = new RealAutoDriveTurnCommand(90, 0.4);
//    		autoDriveTurnCommand.start();
    		
    	}
    	
    	//Brake
    	if(brakeState){
			driveSubsystem.enableBrake();
		}
		else if(!brakeState){
			driveSubsystem.disableBrake();
		}
    	
    	if(xboxMap.startAutoBrakerSystem() && (System.currentTimeMillis()-lastPressed)>200){  
    		
    		brakeState = !brakeState;
    		lastPressed = System.currentTimeMillis();
    	}
    	
    	
    	SmartDashboard.putNumber("Right Encoder Distance", driveSubsystem.getRightEncoderDistance());
    	SmartDashboard.putNumber("Left Encoder Distance", driveSubsystem.getLeftEncoderDistance());
    	SmartDashboard.putNumber("Right Encoder", driveSubsystem.getRightEncoderCount());
    	SmartDashboard.putNumber("Left Encoder", driveSubsystem.getLeftEncoderCount());
    	SmartDashboard.putNumber("Gyro Angle", driveSubsystem.getGyroAngle());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.setLeftSpeed(0);
		driveSubsystem.setRightSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveSubsystem.setLeftSpeed(0);
		driveSubsystem.setRightSpeed(0);
    }
}
