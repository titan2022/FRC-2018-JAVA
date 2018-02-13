package org.usfirst.frc.team2022.robot.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.robot.subsystems.DriveSubsystem; 

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDriveTurnCommand extends Command{
	private boolean finished = false;
	private boolean degreeToTurn; //True: 90, false: -90
	double outputSpeed = 0;
	int degreeNum;
	
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	OI oi = Robot.oi;
	XboxMap xboxMap = new XboxMap();
	
	PIDController pidController;
	
	public AutoDriveTurnCommand(boolean degreeToTurn){
		// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveSubsystem);
    	this.degreeToTurn = degreeToTurn;
    	if (degreeToTurn) {
    		degreeNum = 90;
    	}
    	else {
    		degreeNum = -90;
    	}
    	
    	pidController = new PIDController(ConstantsMap.KP_DRIVE_TURN, ConstantsMap.KI_DRIVE_TURN, ConstantsMap.KD_DRIVE_TURN, ConstantsMap.KF_DRIVE_TURN, null, null);
    	pidController.setInputRange(-180, 180);
    	pidController.setAbsoluteTolerance(1);
    	pidController.setOutputRange(-ConstantsMap.KSPEED_DRIVE_TURN, ConstantsMap.KSPEED_DRIVE_TURN);
    	pidController.setSetpoint(degreeNum);
    	
    	driveSubsystem.resetGyro();
    	driveSubsystem.enableBrake();
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	driveSubsystem.enableBrake();
    	
    	//Reset gyro to 0
    	driveSubsystem.resetGyro();
    	driveSubsystem.resetEncoders();
    }
    
    protected void execute() {
    	
    	double newSpeed = pidController.getOutput(driveSubsystem.getGyroAngle()); //Implement LoPass
//    	double newSpeed = 0.2;
		if (degreeNum == -90)	{
    		driveSubsystem.setLeftSpeed(-0.2);
			driveSubsystem.setRightSpeed(0.2);
		}
		if (degreeNum == 90)	{
    		driveSubsystem.setLeftSpeed(0.2);
			driveSubsystem.setRightSpeed(-0.2);
		}
		if(xboxMap.stopSystem() || Math.abs(Math.abs(degreeNum) - Math.abs(driveSubsystem.getGyroAngle())) < 1){
			finished = true;
    		end();
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
