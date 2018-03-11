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
	double outputSpeed = 0;
	int degreeNum;

	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	OI oi = Robot.oi;
	PIDController rotatePid;
	int degreeToTurn;
	PIDOutput angle = new PIDOutput() {
		
		@Override
		public void pidWrite(double output) {
			SmartDashboard.putNumber("Output",output);
			//driveSubsystem.setRightSpeed(output);

		}
	};
	
	public AutoDriveTurnCommand(int degreeToTurn){
		// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveSubsystem);
    	
    	this.degreeToTurn = degreeToTurn;
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	
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

    	
    	

    //	driveSubsystem.enableBrake();
    	driveSubsystem.enableBrake();
    	
    	//Reset gyro to 0
    	driveSubsystem.resetGyro();
    	driveSubsystem.resetEncoders();
    	rotatePid.enable();
    	
    }
    
    protected void execute() {
    	SmartDashboard.putData("Rotate Turn PID",rotatePid);
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
    	System.out.println("Finished Auto Turn");
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
