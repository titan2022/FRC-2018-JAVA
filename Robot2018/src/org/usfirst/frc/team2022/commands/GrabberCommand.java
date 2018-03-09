package org.usfirst.frc.team2022.commands;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class GrabberCommand extends Command{
	GrabberSubsystem grabberSubsystem = Robot.grabberSubsystem;
	XboxMap xboxMap = new XboxMap();
	OI oi = Robot.oi;
	
	private boolean innerSwitch = false;
	
	private double lastPressed = 0;
	
    public GrabberCommand() {
    	requires(grabberSubsystem);
    }
    
    protected void initialize() {
    }

    protected void execute() {    	
	
    	double speed;
    	speed = xboxMap.controlUpperGrabberOut() - xboxMap.controlUpperGrabberIn(); 
    	
    	if(grabberSubsystem.isSwitchSet()) {
    		grabberSubsystem.stopMotors();
    		if(speed > 0) {
    			grabberSubsystem.setMotorSpeed(speed);
    		}
    	}
    	else {
    		grabberSubsystem.setMotorSpeed(speed);
    	}
    	
    	
    	SmartDashboard.putBoolean("Box Grabbed: ", grabberSubsystem.isSwitchSet());
    	
    	if(xboxMap.stopSystem()){
    		end();
    	}
    }
 
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	grabberSubsystem.stop();
    }

    protected void interrupted() {
    	grabberSubsystem.stop();
    }
}
