/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2022.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2022.robot.Attack3Map;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.robot.subsystems.DriveSubsystem;


/**
 * An example command.  You can replace me with your own command.
 */
public class DriveCommand extends Command {
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	XboxMap xboxMap = new XboxMap();
	Attack3Map attack3Map = new Attack3Map();
	OI oi = Robot.oi;
	
	boolean brakeState = false;
	long lastPressed = 0;
	
	public DriveCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(driveSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		displayData();
		//Normal Driving
    //	double speedLeft = attack3Map.getSpeedLeftWheel();   
		double speedLeft = xboxMap.left();
    	if(Math.abs(speedLeft) < 0.1){
    		speedLeft = 0;
    	}
    	
    	//double speedRight = attack3Map.getSpeedRightWheel();
		double speedRight = xboxMap.right();
    	if(Math.abs(speedRight) < 0.1){
    		speedRight = 0; 
    	}
    	
    	driveSubsystem.setLeftSpeed(speedLeft);
    	driveSubsystem.setRightSpeed(speedRight);

    	//Auto Brake Mode
    	if(attack3Map.startAutoBrakerSystem() && (System.currentTimeMillis() - lastPressed) > 200){  
    		brakeState = !brakeState;
    		lastPressed = System.currentTimeMillis();
    	}
    	if(brakeState){
			driveSubsystem.enableBrake();
		}
		else if(!brakeState){
			driveSubsystem.disableBrake();
		}
    	
	}
	protected void displayData(){
    	SmartDashboard.putNumber("Left Encoder Count: ", driveSubsystem.getLeftEncoderCount());
    	SmartDashboard.putNumber("Left Encoder Distance: ", driveSubsystem.getLeftEncoderDistance());
    	SmartDashboard.putNumber("Left Encoder Rate: ", driveSubsystem.getLeftEncoderRate());
    	SmartDashboard.putNumber("Right Encoder Count: ", driveSubsystem.getRightEncoderCount());
    	SmartDashboard.putNumber("Right Encoder Distance: ", driveSubsystem.getRightEncoderDistance());
    	SmartDashboard.putNumber("Right Encoder Rate: ", driveSubsystem.getRightEncoderRate());
    	//SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
    	SmartDashboard.putBoolean("AutoBrake", brakeState);
    }

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
