package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.CustomPIDController;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMoveToCommand extends Command {
	ElevatorSubsystem elevator = Robot.frontElevatorSubsystem;
	int location;

	
    public ElevatorMoveToCommand(boolean useFront, int location) {
//    	if (useFront) elevator = Robot.frontElevatorSubsystem;
//    	else elevator = Robot.backElevatorSubsystem;
    	
        requires(elevator);
        this.location = location;
        elevator.setSetpoint(location);
        elevator.setAbsoluteTolerance(ConstantsMap.ELEVATOR_ERR_TOLERANCE);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(elevator.isSwitchSet()) {
    		elevator.stop();
    		elevator.resetEncoderPosition();
    		
    	}
    	else if(elevator.getEncoderDistance() >= ConstantsMap.FrontElevatorTravel) {
    		elevator.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.disable();
    	elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
