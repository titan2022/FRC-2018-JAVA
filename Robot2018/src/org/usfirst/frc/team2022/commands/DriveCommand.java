package org.usfirst.frc.team2022.commands;
import org.usfirst.frc.team2022.robot.Attack3Map;
import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveCommand extends Command {
	
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	XboxMap xboxMap = new XboxMap();
	Attack3Map attack3Map = new Attack3Map();
	OI oi = Robot.oi;
		
	boolean brakeState = false;
	long lastPressed = 0;
	
    public DriveCommand() {
    	requires(driveSubsystem);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {   
    	//Normal Driving
    	double speedLeft = attack3Map.getSpeedLeftWheel();   
    	if(Math.abs(speedLeft) < 0.05){
    		speedLeft = 0;
    	}
    	
    	double speedRight = attack3Map.getSpeedRightWheel();
    	if(Math.abs(speedRight) < 0.05){
    		speedRight = 0; 
    	}
    	
    	driveSubsystem.setLeftSpeed(speedLeft);
    	driveSubsystem.setRightSpeed(speedRight);

    	//Auto Brake Mode
    	if(attack3Map.startAutoBrakerSystem() && (System.currentTimeMillis() - lastPressed) > 200){  
    		brakeState = !brakeState;
    		lastPressed = System.currentTimeMillis();
    	}
    	if(brakeState){
			driveSubsystem.enableBrake();
		}
		else if(!brakeState){
			driveSubsystem.disableBrake();
		}
    	
    	//Putting Data up
    	displayData();

    }

    protected void displayData(){
    	SmartDashboard.putNumber("Right Encoder: ", driveSubsystem.getRightEncoderCount());
    	SmartDashboard.putNumber("Left Encoder: ", driveSubsystem.getLeftEncoderCount());
    	SmartDashboard.putNumber("Right Encoder Distance: ", driveSubsystem.getRightEncoderDistance());
    	SmartDashboard.putNumber("Left Encoder Distance: ", driveSubsystem.getLeftEncoderDistance());
 //   	SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
    	SmartDashboard.putBoolean("AutoBrake", brakeState);
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    protected boolean getBrakeState(){
    	return brakeState;
    }
    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveSubsystem.stop();
    }
}