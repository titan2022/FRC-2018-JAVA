package org.usfirst.frc.team2022.commands;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorManualCommand extends Command {
	OI oi = Robot.oi;
	XboxMap xboxMap = new XboxMap();
	
	ElevatorSubsystem elevatorSubsystem = Robot.frontElevatorSubsystem;
	
	boolean brakeState = true;
	long lastPressed = 0;
	
    public ElevatorManualCommand() {
        requires(elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = xboxMap.controlFrontElevator();
    	
    	elevatorSubsystem.setElevatorSpeed(speed);
    	
    	//Auto Brake Mode
    	if(xboxMap.startAutoElevatorBrakerSystem() && (System.currentTimeMillis() - lastPressed) > 200){  
    		brakeState = !brakeState;
    		lastPressed = System.currentTimeMillis();
    	}
    	if(brakeState){
			elevatorSubsystem.enableBrake();
		}
		else if(!brakeState){
			elevatorSubsystem.disableBrake();
		}
    	
    	if(xboxMap.stopSystem()){
    		end();
    	}
    	
    	SmartDashboard.putNumber("Encoder Distance: ", elevatorSubsystem.getEncoderDistance());
    	SmartDashboard.putNumber("Encoder Velocity: ", elevatorSubsystem.getEncoderVelocity());
    	SmartDashboard.putBoolean("Elevator Auto Brake: ", brakeState);
    	SmartDashboard.putNumber("Elevator Speed: ", speed);
    }
    
    protected void displayData(){
    	SmartDashboard.putNumber("Encoder Distance: ", elevatorSubsystem.getEncoderDistance());
    	SmartDashboard.putNumber("Encoder Velocity: ", elevatorSubsystem.getEncoderVelocity());
    	SmartDashboard.putBoolean("Elevator Auto Brake: ", brakeState);
    	//SmartDashboard.putNumber("Elevator Speed: ", elevatorSubsystem.getSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevatorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	elevatorSubsystem.stop();
    }
}
