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
	XboxMap xboxMap = new XboxMap();
	OI oi = Robot.oi;
	
	boolean finished = false;
    public AutoGrabberCommand() {
    	requires(grabberSubsystem);
    }
    
    protected void initialize() {
    	grabberSubsystem.setMotorSpeed(-ConstantsMap.AutoGrabSpeed);
    	Timer.delay(1);
    	grabberSubsystem.stop();
    	finished = true;
    }

    protected void execute() {    	
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
