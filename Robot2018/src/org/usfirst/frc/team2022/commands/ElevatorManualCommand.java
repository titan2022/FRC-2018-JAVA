package org.usfirst.frc.team2022.commands;

import org.usfirst.frc.team2022.robot.ConstantsMap;
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
	double position;
    public ElevatorManualCommand() {
        requires(elevatorSubsystem);
        elevatorSubsystem.setOutputRange(-ConstantsMap.ELEVATOR_MAX_SPEED, ConstantsMap.ELEVATOR_MAX_SPEED);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevatorSubsystem.setSetpoint(elevatorSubsystem.getEncoderDistance());
    	elevatorSubsystem.enable();
    	position = elevatorSubsystem.getEncoderDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double displacement = xboxMap.controlFrontElevator();
    	displacement *= ConstantsMap.ElevatorManualSpeed;
    	position += displacement;
    	if(position <= 0) {
    		position = 0;
    	}
    	if(position >= ConstantsMap.FrontElevatorTravel) {
    		position = ConstantsMap.FrontElevatorTravel;
    	}
    	if(elevatorSubsystem.isSwitchSet()) {
    		elevatorSubsystem.stop();
    		elevatorSubsystem.resetEncoderPosition();
    		position = 0;
    	}
    	else if(elevatorSubsystem.getEncoderDistance() > ConstantsMap.FrontElevatorTravel) {
    		elevatorSubsystem.stop();
    	}
    	else {	    	

	    	elevatorSubsystem.setSetpoint(position);
    	}
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
    	
    	
    	
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevatorSubsystem.disable();
    	elevatorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	elevatorSubsystem.disable();
    	elevatorSubsystem.stop();
    }
}
