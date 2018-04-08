package org.usfirst.frc.team2022.robot.commands;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.robot.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.command.Command;


public class GrabberCommand extends Command{
	GrabberSubsystem grabberSubsystem = Robot.grabberSubsystem;
	XboxMap xboxMap = new XboxMap();
	OI oi = Robot.oi;
	
	private boolean closed = true;
	
	private long lastPressed = 0;
	
    public GrabberCommand() {
    	requires(grabberSubsystem);
    }
    
    protected void initialize() {
    }

    protected void execute() {    	
    	if(xboxMap.piston() &&(System.currentTimeMillis() - lastPressed) > 500) {
    		lastPressed = System.currentTimeMillis();
    		if(closed) {
    			grabberSubsystem.in();
    			closed = !closed;
    		}
    		else {
    			grabberSubsystem.out();
    			closed = !closed;
    		}
    	}
    	double actuate = xboxMap.actuate();
    	double speed  = xboxMap.Grab();
    	/*if(speed > .1) {
    		grabberSubsystem.inTake();
    	}
    	else if(speed < .1) {
    		grabberSubsystem.outTake();
    	}
    	else {
    		grabberSubsystem.stopTake();
    	}*/
    	
    	if(Math.abs(actuate) < 0.1){
    		actuate = 0; 
    	}
    	grabberSubsystem.actuate(actuate*.5);
    	
    	if(xboxMap.inTake()) {
    		grabberSubsystem.inTake();
    	}
    	else if(xboxMap.outTake()) {
    		grabberSubsystem.outTake();
    	}
    	else {
    		grabberSubsystem.stopTake();
    	}
    	/*double speed;
    	//speed = xboxMap.controlUpperGrabberOut() - xboxMap.controlUpperGrabberIn(); 
    	
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
    }*/
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
