package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.CustomPIDController;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GrabberMoveToCommand extends Command {
	GrabberSubsystem grabberSubsystem = Robot.grabberSubsystem;
	int location;

	
    public GrabberMoveToCommand(int location) {
//    	if (useFront) elevator = Robot.frontgrabberSubsystem;
//    	else elevator = Robot.backgrabberSubsystem;
    	if(location > ConstantsMap.FrontElevatorTravel) {
    		location = (int) ConstantsMap.FrontElevatorTravel;
    		
    	}
    	this.location = location;
        requires(grabberSubsystem);
       
       
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	grabberSubsystem.setAbsoluteTolerance(.95);
    	grabberSubsystem.setSetpoint(location);
    	grabberSubsystem.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(grabberSubsystem.isUpSet()) {
    		grabberSubsystem.stop();
    		grabberSubsystem.resetEncoderPosition();
    		
    	}
    	else if(grabberSubsystem.getEncoderAngle() >= ConstantsMap.FrontElevatorTravel) {
    		grabberSubsystem.stop();
    	}
    	SmartDashboard.putNumber("Grabber Anglw", grabberSubsystem.getEncoderAngle());

    	SmartDashboard.putBoolean("Grabber Up Limit",grabberSubsystem.isUpSet());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return grabberSubsystem.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	grabberSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
