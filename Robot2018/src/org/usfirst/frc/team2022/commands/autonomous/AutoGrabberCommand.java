package org.usfirst.frc.team2022.commands.autonomous;
import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class AutoGrabberCommand extends Command{
	GrabberSubsystem grabberSubsystem = Robot.grabberSubsystem;
	OI oi = Robot.oi;
	boolean intake;
	boolean finished = false;
    public AutoGrabberCommand(boolean intake) {
    	requires(grabberSubsystem);
    	this.intake = intake;
    }
    
    protected void initialize() {
    	if(!intake) {
    		grabberSubsystem.setMotorSpeed(-ConstantsMap.AutoGrabSpeed);
    		finished = true;
    		Timer.delay(4);
        	grabberSubsystem.stop();
    	}
    	
    	
    }

    protected void execute() {    	
    	if(!grabberSubsystem.isBoxSet()) {
    		grabberSubsystem.setMotorSpeed(ConstantsMap.AutoGrabSpeed);
    	}
    	else {
    		grabberSubsystem.stop();
    		finished = true;
    	}
    }
 
    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    	grabberSubsystem.stop();
    }

    protected void interrupted() {
    	grabberSubsystem.stop();
    }
}
