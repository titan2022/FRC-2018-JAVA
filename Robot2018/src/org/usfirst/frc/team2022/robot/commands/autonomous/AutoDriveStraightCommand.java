package org.usfirst.frc.team2022.robot.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class AutoDriveStraightCommand extends Command{
	private boolean finished = false;
	private double inchesToDrive = 0;
	private double fieldSize = 0;
	private double rotateToAngleRate = 0;
	private double speed = 0;
	double rotateToAngle = 0;
		
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	OI oi = Robot.oi;
	boolean limitSwitch = false;
	
	public AutoDriveStraightCommand (double inchesToDrive){
		requires(driveSubsystem);
		this.inchesToDrive = inchesToDrive;
		driveSubsystem.resetEncoders();
		driveSubsystem.resetGyro();
	}
	
	public AutoDriveStraightCommand(){
    	requires(driveSubsystem);
    	inchesToDrive = fieldSize;
    	limitSwitch = true;
    	driveSubsystem.resetEncoders();
    	driveSubsystem.resetGyro();
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	driveSubsystem.enableBrake();
    	
    	//Reset gyro to 0
    	driveSubsystem.resetGyro();
    	driveSubsystem.resetEncoders();
    }
    
    protected void execute() {
    	
		driveSubsystem.tankDrive(-0.5 * (speed + rotateToAngleRate), 0.5 * (speed - rotateToAngleRate));
		if(limitSwitch){
			if(driveSubsystem.getLimitSwitch()){
				finished = true;
				end();
			}
		}
		
    }
	
	// Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
