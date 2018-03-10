package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.CustomPIDController;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorMoveToCommand extends Command {
	ElevatorSubsystem elevatorSubsystem = Robot.frontElevatorSubsystem;
	int location;

	
    public ElevatorMoveToCommand(int location) {
//    	if (useFront) elevator = Robot.frontElevatorSubsystem;
//    	else elevator = Robot.backElevatorSubsystem;
    	if(location > ConstantsMap.FrontElevatorTravel) {
    		location = (int) ConstantsMap.FrontElevatorTravel;
    		
    	}
    	this.location = location;
        requires(elevatorSubsystem);
       
       
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevatorSubsystem.setAbsoluteTolerance(.95);
    	elevatorSubsystem.setSetpoint(location);
    	elevatorSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(elevatorSubsystem.isSwitchSet()) {
    		elevatorSubsystem.stop();
    		elevatorSubsystem.resetEncoderPosition();
    		
    	}
    	else if(elevatorSubsystem.getEncoderDistance() >= ConstantsMap.FrontElevatorTravel) {
    		elevatorSubsystem.stop();
    	}
    	SmartDashboard.putNumber("Elevator Encoder", elevatorSubsystem.getEncoderDistance());

    	SmartDashboard.putBoolean("Bottom Elevator",elevatorSubsystem.isSwitchSet());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevatorSubsystem.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevatorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
