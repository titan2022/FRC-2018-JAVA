//package org.usfirst.frc.team2022.commands.autonomous;
//
//import org.usfirst.frc.team2022.robot.ConstantsMap;
//import org.usfirst.frc.team2022.robot.CustomPIDController;
//import org.usfirst.frc.team2022.robot.OI;
//import org.usfirst.frc.team2022.robot.Robot;
//import org.usfirst.frc.team2022.robot.XboxMap;
//import org.usfirst.frc.team2022.subsystems.DriveSubsystem;
//
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
//
//// I don't think this drives straight but ok
//public class AutoDriveStraightCommand extends Command{
//	private boolean finished = false;
//	private double ticksToDrive;
//	private double fieldSize = 0;
//	private double speed = 0;
//	double rotateToAngle = 0;
//	CustomPIDController rpid;
//	CustomPIDController lpid;
//	
//	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
//	OI oi = Robot.oi;
//	boolean limitSwitch = false;
//	
//	public AutoDriveStraightCommand (double inchesToDrive){
//		requires(driveSubsystem);
//		this.ticksToDrive = inchesToDrive / ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK;
//		driveSubsystem.resetEncoders();
//		driveSubsystem.resetGyro();
//		rpid = new CustomPIDController(ConstantsMap.KP_DRIVE_SPEED,ConstantsMap.KI_DRIVE_SPEED,ConstantsMap.KD_DRIVE_SPEED,ConstantsMap.KF_DRIVE_SPEED,
//        		ConstantsMap.DRIVE_ERR_TOLERANCE, -ConstantsMap.DRIVE_MAX_SPEED,ConstantsMap.DRIVE_MAX_SPEED);
//		rpid.setSetpoint(ticksToDrive);
//		lpid = new CustomPIDController(ConstantsMap.KP_DRIVE_SPEED,ConstantsMap.KI_DRIVE_SPEED,ConstantsMap.KD_DRIVE_SPEED,ConstantsMap.KF_DRIVE_SPEED,
//        		ConstantsMap.DRIVE_ERR_TOLERANCE, -ConstantsMap.DRIVE_MAX_SPEED,ConstantsMap.DRIVE_MAX_SPEED);
//		lpid.setSetpoint(ticksToDrive);
//	}
//	
//	public AutoDriveStraightCommand(){
//    	requires(driveSubsystem);
//    	ticksToDrive = fieldSize / ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK;
//    	limitSwitch = true;
//    	driveSubsystem.resetEncoders();
//    	driveSubsystem.resetGyro();
//    	rpid = new CustomPIDController(ConstantsMap.KP_DRIVE_SPEED,ConstantsMap.KI_DRIVE_SPEED,ConstantsMap.KD_DRIVE_SPEED,ConstantsMap.KF_DRIVE_SPEED,
//        		ConstantsMap.DRIVE_ERR_TOLERANCE, -ConstantsMap.DRIVE_MAX_SPEED,ConstantsMap.DRIVE_MAX_SPEED);
//		rpid.setSetpoint(ticksToDrive);
//		lpid = new CustomPIDController(ConstantsMap.KP_DRIVE_SPEED,ConstantsMap.KI_DRIVE_SPEED,ConstantsMap.KD_DRIVE_SPEED,ConstantsMap.KF_DRIVE_SPEED,
//        		ConstantsMap.DRIVE_ERR_TOLERANCE, -ConstantsMap.DRIVE_MAX_SPEED,ConstantsMap.DRIVE_MAX_SPEED);
//		lpid.setSetpoint(ticksToDrive);
//    }
//	
//	// Called just before this Command runs the first time
//    protected void initialize() {
//    	
//    	driveSubsystem.enableBrake();
//    	
//    	//Reset gyro to 0
//    	driveSubsystem.resetGyro();
//    	driveSubsystem.resetEncoders();
//    }
//    
//    protected void execute() {
//    	driveSubsystem.tankDrive(lpid.update(driveSubsystem.getLeftEncoderDistance()),rpid.update(driveSubsystem.getRightEncoderDistance()));
//    }
//	
//	// Make this return true when this Command no longer needs to run execute()
//    public boolean isFinished() {
//        return lpid.isFinished() && rpid.isFinished();
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	driveSubsystem.stop();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	end();
//    }
//
//}
