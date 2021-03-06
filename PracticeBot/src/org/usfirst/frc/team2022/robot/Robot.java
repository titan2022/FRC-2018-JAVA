/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2022.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2022.commands.autonomous.groups.AutoCrossLineCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.CenterSwitchCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.LeftScaleCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.LeftSwitchCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.RightScaleCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.RightSwitchCommandGroup;
import org.usfirst.frc.team2022.robot.commands.DriveCommand;
import org.usfirst.frc.team2022.robot.commands.GrabberCommand;
import org.usfirst.frc.team2022.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2022.robot.subsystems.GrabberSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;
	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public DriveCommand driveCommand;
	public GrabberCommand grabberCommand;
	public static GrabberSubsystem grabberSubsystem = new GrabberSubsystem(RobotMap.LEFT_GRABBER_PORT, RobotMap.RIGHT_GRABBER_PORT);
	CommandGroup autonomousCommand;
	SendableChooser<String> autoTypeChooser;
	SendableChooser<String> actionTypeChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();		
		
		
		
		driveCommand = new DriveCommand();
		grabberCommand = new GrabberCommand();
		autoTypeChooser = new SendableChooser<String>();
    	autoTypeChooser.addDefault("Left Position", "left"); 
     	autoTypeChooser.addObject("Center Postion", "center"); 
    	autoTypeChooser.addObject("Right Position", "right");
    	actionTypeChooser = new SendableChooser<String>();
    	actionTypeChooser.addDefault("Switch", "switch");
    	actionTypeChooser.addObject("Switch Defer Scale", " switch defer"); 
    	actionTypeChooser.addObject("Scale", "scale");
    	actionTypeChooser.addObject("Scale Defer ", "scale defer");    	
    	actionTypeChooser.addObject("AutoLine", "line"); 
    	actionTypeChooser.addObject("AutoLineWait", "waitline");
    	
    	SmartDashboard.putData("Auto Chooser",autoTypeChooser);
    	SmartDashboard.putData("Auto Type",actionTypeChooser);
    	
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		if(actionTypeChooser.getSelected() == "switch") {
			if(autoTypeChooser.getSelected() == "left"){
				autonomousCommand = new LeftSwitchCommandGroup(gameData);
			}
			else if(autoTypeChooser.getSelected() == "right") {
				autonomousCommand = new RightSwitchCommandGroup(gameData);
			}
			else {
				autonomousCommand = new CenterSwitchCommandGroup(gameData);
			}
		}
		else if(actionTypeChooser.getSelected() == "scale") {
			if(autoTypeChooser.getSelected() == "left"){
				autonomousCommand = new LeftScaleCommandGroup(gameData,false);
			}
			else if(autoTypeChooser.getSelected() == "right") {
				autonomousCommand = new RightScaleCommandGroup(gameData,false);
			}
		}
		else if(actionTypeChooser.getSelected() == "scale defer") {
			if(autoTypeChooser.getSelected() == "left"){
				autonomousCommand = new LeftScaleCommandGroup(gameData,true);
			}
			else if(autoTypeChooser.getSelected() == "right") {
				autonomousCommand = new RightScaleCommandGroup(gameData,true);
			}
		}
		else{
			autonomousCommand = new AutoCrossLineCommandGroup();
		}
  	
		autonomousCommand.start(); 
			
    }
	

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		driveCommand.start();
		grabberCommand.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
