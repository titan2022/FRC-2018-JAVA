package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


// I don't think this drives straight but ok
public class AutoDriveStraightCommand extends Command{
	private boolean finished = false;
	private double ticksToDrive;
	private double fieldSize = 0;
	private double speed = 0;
	double rotateToAngle = 0;
	PIDController rpid;
    PIDController lpid;
	
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	OI oi = Robot.oi;
	private PIDOutput rspeed = new PIDOutput() {
		
		@Override
		public void pidWrite(double output) {
			driveSubsystem.setRightSpeed(output);
			
		}
	};
	private PIDOutput lspeed = new PIDOutput() {
		
		@Override
		public void pidWrite(double output) {
			driveSubsystem.setLeftSpeed(output);
			
		}
	};
	boolean limitSwitch = false;

	
	public AutoDriveStraightCommand (double inchesToDrive){

		requires(driveSubsystem);
		//this.ticksToDrive = inchesToDrive / ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK;
		ticksToDrive = inchesToDrive;
		driveSubsystem.resetEncoders();
		driveSubsystem.resetGyro();

		
		
		
	}
	
	public AutoDriveStraightCommand(){
    	requires(driveSubsystem);
    	//ticksToDrive = fieldSize / ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK;
    	limitSwitch = true;
    	
    	
    	//driveSubsystem.resetGyro();
    	
		
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
   		driveSubsystem.enableBrake();
		rpid = new PIDController(
				ConstantsMap.KP_DRIVE_SPEED,
				ConstantsMap.KI_DRIVE_SPEED,
				ConstantsMap.KD_DRIVE_SPEED,
				ConstantsMap.KF_DRIVE_SPEED,
				driveSubsystem.getRightEncoder(),
				rspeed
				);
		rpid.setSetpoint(ticksToDrive);				
		rpid.setAbsoluteTolerance(ConstantsMap.DRIVE_ERR_ABSTOLERANCE);

		rpid.setOutputRange(ConstantsMap.DRIVE_MIN_SPEED,ConstantsMap.DRIVE_MAX_SPEED);
		rpid.setPercentTolerance(ConstantsMap.DRIVE_ERR_ABSTOLERANCE);
    	//Reset gyro to 0
    	driveSubsystem.resetGyro();
		lpid = new PIDController(
				ConstantsMap.KP_DRIVE_SPEED,
				ConstantsMap.KI_DRIVE_SPEED,
				ConstantsMap.KD_DRIVE_SPEED,
				ConstantsMap.KF_DRIVE_SPEED,
				driveSubsystem.getLeftEncoder(),
				lspeed
				);
		lpid.setSetpoint(ticksToDrive);				
		lpid.setAbsoluteTolerance(ConstantsMap.DRIVE_ERR_ABSTOLERANCE);

		lpid.setOutputRange(ConstantsMap.DRIVE_MIN_SPEED,ConstantsMap.DRIVE_MAX_SPEED);
		//lpid.setPercentTolerance(ConstantsMap.DRIVE_ERR_BUFTOLERANCE);
    	driveSubsystem.resetEncoders();
    	
    	rpid.enable();
     	lpid.enable();
    	
    }
    
    protected void execute() {
    	//System.out.println("exec");
    	double lout = lpid.get();
    	double rout = rpid.get();
    	driveSubsystem.tankDrive(lout,rout);
    	SmartDashboard.putNumber("Output Left",lout);
    	SmartDashboard.putNumber("Output Right",rout);
    	displayData();
    }
	
    protected void displayData(){
    	//SmartDashboard.
    	SmartDashboard.putNumber("Left Encoder Count: ", driveSubsystem.getLeftEncoderCount());
    	SmartDashboard.putNumber("Left Encoder Distance: ", driveSubsystem.getLeftEncoderDistance());
    	SmartDashboard.putNumber("Left Encoder Rate: ", driveSubsystem.getLeftEncoderRate());
    	SmartDashboard.putNumber("Right Encoder Count: ", driveSubsystem.getRightEncoderCount());
    	SmartDashboard.putNumber("Right Encoder Distance: ", driveSubsystem.getRightEncoderDistance());
    	SmartDashboard.putNumber("Right Encoder Rate: ", driveSubsystem.getRightEncoderRate());
    	SmartDashboard.putNumber("Error",lpid.getError());
    	SmartDashboard.putData(lpid);
    	

 //   	SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
    }
    
	// Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
    	//System.out.println("Finished: " + lpid.onTarget());
        return lpid.onTarget() && rpid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("I finished");
    	lpid.disable();
    	rpid.disable();
    	driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("autodrivestart interupt");
    	lpid.disable();
    	rpid.disable();
    	end();
    }

}
