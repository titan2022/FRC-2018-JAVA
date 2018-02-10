package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorManualCommand extends Command {
	int slowdownThreshold = 1; // clicks around top/bottom to slow down 
	ElevatorSubsystem elevator = Robot.elevatorSubsystem;
	OI oi = Robot.oi;
	
    public ElevatorManualCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = oi.xbox.getLeftX();
    	double y = oi.xbox.getLeftY();
    	double speed;
    	
    	if (Math.abs(y) > Math.abs(x))
    		speed = 1.0;
    	else
    		speed = 0.0;
    	
    	if (y < 0)
    		speed = -speed;
    	
    	if (elevator.getEncoderPos() - slowdownThreshold <= 0)
    		elevator.setElevatorSpeed(0.5 * speed);
    	else if (elevator.getEncoderPos() + slowdownThreshold >= elevator.extensionLimit)
    		elevator.setElevatorSpeed(0.5 * speed);
    	else
    		elevator.setElevatorSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.getEncoderPos() >= elevator.extensionLimit || oi.xbox.getLeftY() == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.setElevatorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	elevator.setElevatorSpeed(0);
    }
}
