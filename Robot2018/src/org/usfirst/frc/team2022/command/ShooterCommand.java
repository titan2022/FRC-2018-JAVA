package org.usfirst.frc.team2022.command;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystem.ShooterSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterCommand extends Command {
	
	ShooterSubsystem shooterSubsystem = Robot.shooterSubsystem;
//	AutoShooterSpeedCommand autoShooterCommand = new AutoShooterSpeedCommand(31000);
	
//	CommandGroup autoShooterCommandGroup = new CommandGroup();
	
	XboxMap xboxMap = new XboxMap();
	OI oi = Robot.oi;
	
	NetworkTable sd = NetworkTable.getTable("Preferences");
	
	public ShooterCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(shooterSubsystem);
    }
	
	// Called just before this Command runs the first time
    protected void initialize() {
    }
		
    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	
//    	shooterSubsystem.setShooterSpeed(sd.getNumber("speed", 0));
    	SmartDashboard.putNumber("Shooter Speed", shooterSubsystem.getShooterSpeed());
//    	shooterSubsystem.setShooterSpeed(oi.xbox.GetRightTriggers());
    	//53.5
    	//Manual shooting
    	if(xboxMap.startManualShooterCommand())
    	{
//    		autoShooterCommand = new AutoShooterSpeedCommand(ConstantsMap.SHOOTING_SPEED);
//	   		autoShooterCommand.start();
    	}
	   	
	   	//Autonomous shooting
	   	
	   	if(xboxMap.stopSystem()){
//		   	autoShooterCommand.cancel();
	   	}
	   		   		   	
	   	SmartDashboard.putNumber("Shooter Encoder Rate", shooterSubsystem.getShooterSpeed());
	   	
	  
   	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	 // Called once after isFinished returns true
    protected void end() {
    	shooterSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	shooterSubsystem.stop();
    }

}


