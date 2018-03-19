package org.usfirst.frc.team2022.commands;

import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;
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
	boolean preset = false;
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
  

    		
	    	if(xboxMap.switchPreset()) {	    		
	    		preset = !preset;
	    		if(preset) {
	    			position = ConstantsMap.ElevatorSwitchHeight;
	    		}
	    		
	    	}
	    	else if(xboxMap.scaleNormalPreset()) {
	    		preset = !preset;
	    		if(preset) {
	    			position = ConstantsMap.ElevatorScaleNormalHeight;
	    		}
	    	}
	    	else if(xboxMap.switchPreset()) {
	    		preset = !preset;
	    		if(preset) {
	    			position = ConstantsMap.ElevatorScaleHighHeight;
	    		}
	    	}
	    	else {
		    	
		    	double displacement = xboxMap.controlFrontElevator();
		    	
		    	if(Math.abs( displacement) < 0.1){
		    		 displacement = 0; 
		    	}
		    	displacement *= ConstantsMap.ElevatorManualSpeed;
		    	position += displacement;
		    	if(10 <position-elevatorSubsystem.getEncoderDistance()) {
		    		position = 10 + elevatorSubsystem.getEncoderDistance();
		    	}
		    	else if(10 <elevatorSubsystem.getEncoderDistance()-position) {
		    		position = elevatorSubsystem.getEncoderDistance()-10;
		    	}
		    	if(position < 0) {
		    		position = 0;
		    	}
		    	if(position >= ConstantsMap.FrontElevatorTravel) {
		    		position = ConstantsMap.FrontElevatorTravel;
		    	}
		    	
		    	//Hardware stop
		    	if(elevatorSubsystem.isSwitchSet() && (-2 < elevatorSubsystem.getEncoderDistance() || (elevatorSubsystem.getEncoderDistance()) < 2)){
		    		elevatorSubsystem.stop();
		    		elevatorSubsystem.resetEncoderPosition();
		    		if(position > 0) {
		    			elevatorSubsystem.setSetpoint(position);
		    		}
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
	    	SmartDashboard.putNumber("Elevator Encoder", elevatorSubsystem.getEncoderDistance()); 
	    	SmartDashboard.putNumber("Elevator Set Position", position); 
	    	SmartDashboard.putBoolean("Bottom Elevator",elevatorSubsystem.isSwitchSet());
	    	
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
    public double mapStages(double carriage) {
    	return ((16.2/(37.4))*carriage);
    }
}
