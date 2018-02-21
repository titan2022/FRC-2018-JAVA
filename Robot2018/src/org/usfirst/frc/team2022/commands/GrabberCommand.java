package org.usfirst.frc.team2022.commands;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.command.Command;


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
    	
//    	if(xboxMap.controlUpperGrabberOut() && System.currentTimeMillis() - lastPressed > 200){
//    		innerSwitch = !innerSwitch;
//    		lastPressed = System.currentTimeMillis();
//    	}
//    	
//    	if(innerSwitch){
//    		speed = -1;
//    		grabberSubsystem.setMotorSpeed(speed);
//    	}
//    	
    	speed = xboxMap.controlUpperGrabberOut() - xboxMap.controlUpperGrabberIn(); 
    	
    	grabberSubsystem.setMotorSpeed(speed);
    	
 //   	SmartDashboard.putBoolean("Box Grabbed: ", grabberSubsystem.getBoxSwitch());
    	
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
