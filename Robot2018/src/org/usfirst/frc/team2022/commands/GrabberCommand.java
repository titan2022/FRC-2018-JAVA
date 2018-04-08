package org.usfirst.frc.team2022.commands;
import org.usfirst.frc.team2022.robot.ConstantsMap;
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
	
	private boolean closed = true;
	double position;
	private double lastPressed = 0;
	
    public GrabberCommand() {
    	requires(grabberSubsystem);
    }
    
    protected void initialize() {
    	grabberSubsystem.resetEncoderPosition();
    	grabberSubsystem.setSetpoint(grabberSubsystem.getEncoderAngle());
    	grabberSubsystem.enable();
    	position = grabberSubsystem.getEncoderAngle();
    	position = 0;
    }

    protected void execute() {    	
    	SmartDashboard.putNumber("Grabbeeee Encoder",grabberSubsystem.getEncoderAngle());
    
    	if(xboxMap.piston() && (System.currentTimeMillis() - lastPressed) > 500) {
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
    	
    	
    	/*double actuate = xboxMap.actuate();
    	//actuate = -Math.abs(actuate);
    	if(!grabberSubsystem.isUpSet()) {
    		grabberSubsystem.actuate(actuate);
        	
    	}*/
    	
    	
    	
    	double actuate = xboxMap.actuate();
    	//double speed = xboxMap.Grab();
    	
    	if(Math.abs(actuate) < .1) {
    		actuate = 0;
    	}
    	//grabberSubsystem.actuate(actuate *.5);
    	//actuate *= ConstantsMap.GrabberManualSpeed;
    	position += actuate;
    /*	if(10 <position-grabberSubsystem.getEncoderAngle()) {
    		position = 10 + grabberSubsystem.getEncoderAngle();
    	}
    	else if(10 <grabberSubsystem.getEncoderAngle()-position) {
    		position = grabberSubsystem.getEncoderAngle()-10;
    	}*/
    	if(position < 0) {
    		position = 0;
    	}
    	if(position >= 75) {
    		position = 75;
    	}
    	/*if(grabberSubsystem.isUpSet() && (grabberSubsystem.getEncoderAngle()) < 5){
    		grabberSubsystem.stop();
    		grabberSubsystem.resetEncoderPosition();
    		System.out.println("Hit Box limit");
    		if(position > 0) {
    			grabberSubsystem.setSetpoint(position);
    		}
    	}*/
    	/*if(grabberSubsystem.getEncoderAngle() > 60) {
    		grabberSubsystem.stop();
    	}
    	if(grabberSubsystem.getEncoderAngle() < 0) {
    		grabberSubsystem.stop();
    	}*/
    	else {	    	

	    	grabberSubsystem.setSetpoint(position);
    	}
    	SmartDashboard.putNumber("Position", position);
    	
    	
    	
    	if(xboxMap.inTake()) {
    		//if(!grabberSubsystem.isBoxSet()) {
    			grabberSubsystem.inTake();
    		//}
    	}
    	else if(xboxMap.outTake()) {
    		grabberSubsystem.outTake();
    	}
    	else {	
    		grabberSubsystem.stopTake();
    	}
    	if(xboxMap.override()) {
    		position = 0;
    		grabberSubsystem.resetEncoderPosition();
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
