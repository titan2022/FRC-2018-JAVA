package org.usfirst.frc.team2022.robot.commands;

import org.usfirst.frc.team2022.robot.CustomPIDController;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMoveToCommand extends Command {
	ElevatorSubsystem elevator = Robot.elevatorSubsystem;
	int location;
	CustomPIDController pid;
	
    public ElevatorMoveToCommand(int location) {
        requires(elevator);
        this.location = location;
        pid = new CustomPIDController(1.0,1.0,1.0,0.0, 1.0, -2.0,2.0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevator.setElevatorSpeed(pid.update(System.nanoTime(), elevator.getEncoderPos()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return pid.isFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.setElevatorSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
