package org.usfirst.frc.team2022.robot;


import org.usfirst.frc.team2022.commands.DriveCommand;
import org.usfirst.frc.team2022.commands.ElevatorManualCommand;
import org.usfirst.frc.team2022.commands.autonomous.groups.AutoCrossLineCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.AutoTestGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.CenterSwitchCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.LeftScaleCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.LeftSwitchCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.RightScaleCommandGroup;
import org.usfirst.frc.team2022.commands.autonomous.groups.RightSwitchCommandGroup;
import org.usfirst.frc.team2022.commands.GrabberCommand;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;
import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//Instantiate Subsystems
	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final GrabberSubsystem grabberSubsystem = new GrabberSubsystem(RobotMap.INNERLEFT_GRABBER_PORT, RobotMap.INNERRIGHT_GRABBER_PORT);
	public static final ElevatorSubsystem frontElevatorSubsystem = new ElevatorSubsystem(RobotMap.FRONT_ELEVATOR_PORT);

	//Create References to commands
	public DriveCommand driveCommand;
	public GrabberCommand grabberCommand;
	public ElevatorManualCommand elevatorCommand;
	
	//Create reference to OI
	public static OI oi;
	public XboxMap xboxMap = new XboxMap();
	public Attack3Map attack3Map = new Attack3Map();
	PowerDistributionPanel pdp;
	
	public double position;
	
	//Autonomous
	CommandGroup autonomousCommand = new CommandGroup();
	SendableChooser<String> autoTypeChooser;
	SendableChooser<String> actionTypeChooser;
	
	//Initialization code ran when you turn on the robot
    public void robotInit() {    	
    	//pdp = new PowerDistributionPanel();
    	//Instantiate OI
    	oi = new OI(); 
    	System.out.println("Start");
    	//Instantiate Commands	
    	driveCommand = new DriveCommand();
    	grabberCommand = new GrabberCommand();
    	elevatorCommand = new ElevatorManualCommand();
    	
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
    	actionTypeChooser.addObject("Test", "test");
    	
    	SmartDashboard.putData("Auto Chooser",autoTypeChooser);
    	SmartDashboard.putData("Auto Type",actionTypeChooser);
    	//SmartDashboard.putData("PDP",pdp);
    	SmartDashboard.putData("Gyro", driveSubsystem.getGyro());
    	SmartDashboard.putData("Left Encoder",driveSubsystem.getLeftEncoder());
    	SmartDashboard.putData("Right Encoder",driveSubsystem.getRightEncoder());
    	SmartDashboard.putData("autocommand", autonomousCommand);
    	SmartDashboard.putData("Elevator", driveSubsystem);
    }
    
    
    //This starts the methods for autonomous
    public void autonomousInit() {
    	String gameData;
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	System.out.println("Selected: " + actionTypeChooser.getSelected());
    	//System.out.println();
    	if(actionTypeChooser.getSelected() == "switch") {
			if(autoTypeChooser.getSelected() == "left"){
				System.out.println("Switch Left");
				autonomousCommand = new LeftSwitchCommandGroup(gameData);
			}
			else if(autoTypeChooser.getSelected() == "right") {
				System.out.println("Switch Right");
				autonomousCommand = new RightSwitchCommandGroup(gameData);
			}
			else {
				System.out.println("Switch Center");
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
		else if(actionTypeChooser.getSelected() == "line"){
			autonomousCommand = new AutoCrossLineCommandGroup();
		}
    	else{
			autonomousCommand = new AutoTestGroup();
		}
		
    	SmartDashboard.putData("autocommand", autonomousCommand);
    	autonomousCommand.start(); 
 
    }
    
    //This starts the methods for teleop and stops methods for autonomous
	public void teleopInit() {
		autonomousCommand.cancel();
    	driveCommand.start();
    	grabberCommand.start();
    	elevatorCommand.start();
    }
    
    //This stops the methods for autonomous
	public void disabledInit() {
		autonomousCommand.cancel();
		driveCommand.cancel();
		grabberCommand.cancel();
		elevatorCommand.cancel();
	}
    
	//Methods below this line do not need to be edited/////////////////////////////////////////////////////////////////////////
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    @Override
	public void robotPeriodic() {
		// TODO Auto-generated method stub
    	Scheduler.getInstance().run();
//    	SmartDashboard.putNumber("Heading", driveSubsystem.getGyro().getAngle());
	}
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {    	
    	Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	//LiveWindow.run();
    }


	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
}