package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
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

	boolean limitSwitch = false;
	PIDController rotatePid;

	PIDOutput angle = new PIDOutput() {
		
		@Override
		public void pidWrite(double output) {

		}
	};
	PIDOutput lspeed = new PIDOutput() {
		
		@Override
		public void pidWrite(double output) {
	
		}
	};
		
	public AutoDriveStraightCommand (double inchesToDrive){

		requires(driveSubsystem);
		//this.ticksToDrive = inchesToDrive / ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK;
		ticksToDrive = inchesToDrive;
		
		driveSubsystem.enableBrake();
   		rotatePid = new PIDController(
				ConstantsMap.KP_DRIVESTRAIGHT_TURN,
				ConstantsMap.KI_DRIVESTRAIGHT_TURN,
				ConstantsMap.KD_DRIVESTRAIGHT_TURN,
				ConstantsMap.KF_DRIVESTRAIGHT_TURN,
				driveSubsystem.getGyro(),
				angle
				);
		rotatePid.setSetpoint(0);				
		rotatePid.setAbsoluteTolerance(1);
		rotatePid.setInputRange(-180, 180);
		rotatePid.setContinuous();

		rotatePid.setOutputRange(-.05,.05);
		
		
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
		
		rpid = new PIDController(
				ConstantsMap.KP_DRIVE_SPEED,
				ConstantsMap.KI_DRIVE_SPEED,
				ConstantsMap.KD_DRIVE_SPEED,
				ConstantsMap.KF_DRIVE_SPEED,
				driveSubsystem.getRightEncoder(),
				lspeed
				);
		rpid.setSetpoint(ticksToDrive);				
		rpid.setAbsoluteTolerance(ConstantsMap.DRIVE_ERR_ABSTOLERANCE);

		rpid.setOutputRange(ConstantsMap.DRIVE_MIN_SPEED,ConstantsMap.DRIVE_MAX_SPEED);
	}

	// Called just before this Command runs the first time
	    protected void initialize() {
   		
		//lpid.setPercentTolerance(ConstantsMap.DRIVE_ERR_BUFTOLERANCE);
    	driveSubsystem.resetEncoders();    	
    	
    	//Reset gyro to 0
    	driveSubsystem.resetGyro();
    	//rpid.enable();
     	
    	lpid.enable();
    	rpid.enable();
    	rotatePid.enable();
    	
    }
    
    protected void execute() {
    	//System.out.println("exec");
    	double lout = lpid.get();
    	double rout = rpid.get();
    	double tout = rotatePid.get();
    	driveSubsystem.tankDrive((lout+tout),(rout-tout));
    	SmartDashboard.putNumber("Output Left",lout);
    	SmartDashboard.putNumber("Output Right",lout);
    	SmartDashboard.putNumber("Output Rotate",tout);
    	SmartDashboard.putData("LPID",lpid);
    	SmartDashboard.putData("RPID",rpid);
    	SmartDashboard.putData("RotatePID",rotatePid);

    	//displayData();
    	
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
    	
    	SmartDashboard.putData("LPID",lpid);
    	SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
    }
    
	// Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
    	
    	//System.out.println("Finished: " + lpid.onTarget());
        return lpid.onTarget() && rpid.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("AutoStraight finished");
    	lpid.disable();
    	rpid.disable();
    	rotatePid.disable();
    //	rpid.disable();
    	driveSubsystem.stop();
    	//Scheduler.getInstance().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("autodrivestart interupt");
    	rotatePid.disable();
    	lpid.disable();
    	rpid.disable();
    	//rpid.disable();
    	end();
    }


}
