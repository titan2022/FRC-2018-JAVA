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
//public class AutoDriveTurnCommand extends Command{
//	private boolean finished = false;
//	private boolean degreeToTurn; //True: 90, false: -90
//	double outputSpeed = 0;
//	int degreeNum;
//	
//	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
//	OI oi = Robot.oi;
//	XboxMap xboxMap = new XboxMap();
//	
//	CustomPIDController pid;
//	
//	public AutoDriveTurnCommand(boolean degreeToTurn){
//		// Use requires() here to declare subsystem dependencies
//        // eg. requires(chassis);
//    	requires(driveSubsystem);
//    	this.degreeToTurn = degreeToTurn;
//    	if (degreeToTurn) {
//    		degreeNum = 90;
//    	}
//    	else {
//    		degreeNum = -90;
//    	}
//    	
//    	pid = new CustomPIDController(ConstantsMap.KP_DRIVE_TURN, ConstantsMap.KI_DRIVE_TURN, ConstantsMap.KD_DRIVE_TURN,
//    			ConstantsMap.KF_DRIVE_TURN,1,-ConstantsMap.TURN_MAX_SPEED, ConstantsMap.TURN_MAX_SPEED);
//    	pid.setSetpoint(degreeNum);
//    	
//    	driveSubsystem.resetGyro();
//    	driveSubsystem.enableBrake();
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
//    	
//    	double newSpeed = pid.update(driveSubsystem.getGyroAngle());
////    	double newSpeed = 0.2;
//		if (degreeNum == -90)	{
//    		driveSubsystem.tankDrive(-newSpeed,newSpeed);
//		}
//		if (degreeNum == 90)	{
//			driveSubsystem.tankDrive(newSpeed,-newSpeed);
//		}
//    }
//	
//	// Make this return true when this Command no longer needs to run execute()
//    public boolean isFinished() {
//        return pid.isFinished();
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
//}
