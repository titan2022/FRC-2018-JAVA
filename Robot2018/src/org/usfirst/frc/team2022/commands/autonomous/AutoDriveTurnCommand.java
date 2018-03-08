package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.CustomPIDController;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDriveTurnCommand extends Command{
	private boolean finished = false;
	private double degreeToTurn; //True: 90, false: -90
	double outputSpeed = 0;
	int degreeNum;

	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	OI oi = Robot.oi;
	PIDController rotatePid;
	PIDOutput angle = new PIDOutput() {
		
		@Override
		public void pidWrite(double output) {
			//driveSubsystem.setRightSpeed(output);
			
		}
	};
	
	public AutoDriveTurnCommand(double degreeToTurn){
		// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveSubsystem);
    	this.degreeToTurn = degreeToTurn;
 
    	
    	rotatePid = new PIDController(
				ConstantsMap.KP_DRIVE_TURN,
				ConstantsMap.KI_DRIVE_TURN,
				ConstantsMap.KD_DRIVE_TURN,
				ConstantsMap.KF_DRIVE_TURN,
				driveSubsystem.getGyro(),
				angle
				);
		rotatePid.setSetpoint(degreeToTurn);				
		rotatePid.setAbsoluteTolerance(ConstantsMap.TURN_ERR_TOLERANCE);
		

		rotatePid.setOutputRange(ConstantsMap.TURN_MIN_SPEED,ConstantsMap.TURN_MAX_SPEED);
		//lpid.setPercentTolerance(ConstantsMap.DRIVE_ERR_BUFTOLERANCE);
    	driveSubsystem.resetEncoders();
    	//rpid.enable();
    	SmartDashboard.putData("Rotate PID",rotatePid);
    	
    	

    	driveSubsystem.enableBrake();
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	driveSubsystem.enableBrake();
    	
    	//Reset gyro to 0
    	driveSubsystem.resetGyro();
    	driveSubsystem.resetEncoders();
    	rotatePid.enable();
    }
    
    protected void execute() {
    	
    	double speed = rotatePid.get();
//    	double newSpeed = 0.2;
    		driveSubsystem.tankDrive(speed,-speed);		
    }
	
	// Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return rotatePid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	rotatePid.disable();
    	driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	rotatePid.disable();
    	end();
    }
}
