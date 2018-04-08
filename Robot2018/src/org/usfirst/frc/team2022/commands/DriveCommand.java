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
	boolean turtlemode = false;	
	boolean brakeState = false;
	long lastPressed = 0;
	
    public DriveCommand() {
    	requires(driveSubsystem);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Drive Comand init");
    	driveSubsystem.resetEncoders();
    	driveSubsystem.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {   
    	//Normal Driving
    	/*if(attack3Map.turtleButton()) {
    		turtlemode = !turtlemode;
    	} */
    	
    	double speedLeft = xboxMap.left();
    	speedLeft *= -1;
    	if(Math.abs(speedLeft) < 0.1){
    		speedLeft = 0;
    	}
    	if(xboxMap.shiftHigh()) {
    		driveSubsystem.shiftHigh();
    	}
    	if(xboxMap.shiftLow()) {
    		driveSubsystem.shiftLow();
    	}
    	double speedRight = xboxMap.right();
    	//speedRight *= -1;
    	if(Math.abs(speedRight) < 0.1){
    		speedRight = 0; 
    	}
    	if(turtlemode) {
    		speedLeft *= ConstantsMap.TurtleSpeed;
    		speedRight *= ConstantsMap.TurtleSpeed;
    	}
    	driveSubsystem.setLeftSpeed(speedLeft*ConstantsMap.TurtleSpeed);
    	driveSubsystem.setRightSpeed(speedRight*ConstantsMap.TurtleSpeed);

    	//Auto Brake Mode
    	//attack3Map.startAutoBrakerSystem();
    	if(xboxMap.startAutoBrakerSystem() && (System.currentTimeMillis() - lastPressed) > 200){  
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
    	SmartDashboard.putNumber("Left Encoder Count: ", driveSubsystem.getLeftEncoderCount());
    	SmartDashboard.putNumber("Left Encoder Distance: ", driveSubsystem.getLeftEncoderDistance());
    	SmartDashboard.putNumber("Left Encoder Rate: ", driveSubsystem.getLeftEncoderRate());
    	SmartDashboard.putNumber("Right Encoder Count: ", driveSubsystem.getRightEncoderCount());
    	SmartDashboard.putNumber("Right Encoder Distance: ", driveSubsystem.getRightEncoderDistance());
    	SmartDashboard.putNumber("Right Encoder Rate: ", driveSubsystem.getRightEncoderRate());
    	SmartDashboard.putNumber("Gyro Angle: ", driveSubsystem.getGyroAngle());
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