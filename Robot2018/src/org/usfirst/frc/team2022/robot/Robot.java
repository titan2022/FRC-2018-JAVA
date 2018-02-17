package org.usfirst.frc.team2022.robot;


import org.usfirst.frc.team2022.commands.ElevatorCommand;
import org.usfirst.frc.team2022.commands.DriveCommand;
import org.usfirst.frc.team2022.commands.GrabberCommand;
import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;
import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
	public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
	public static final GrabberSubsystem grabberSubsystem = new GrabberSubsystem();
	public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();

//	public static final LightSubsystem lights = new LightSubsystem();
	
	//Create References to commands
	public DriveCommand driveCommand;
	public GrabberCommand grabberCommand;
	public ElevatorCommand elevatorCommand;
	
	//Create reference to OI
	public static OI oi;
	public XboxMap xboxMap = new XboxMap();
	public Attack3Map attack3Map = new Attack3Map();
	
	//Initialization code ran when you turn on the robot
    public void robotInit() {    	

    	//Instantiate OI
    	oi = new OI();
    	
    	//Instantiate Commands
    	driveCommand = new DriveCommand();
    	grabberCommand = new GrabberCommand();
    	elevatorCommand = new ElevatorCommand();
//    	lightCommand = new LightCommand(0);
    	
    }
    
    
    //This starts the methods for autonomous
    public void autonomousInit() {
//    	try{
//    		
//    	}
//    	catch(Exception ex){
//    		System.out.println(ex);
//    	}
    	autonomousCommand.start();
    	
    }
    
    //This starts the methods for teleop and stops methods for autonomous
	public void teleopInit() {
    	driveCommand.start();
//    	lightCommand.start();
    }
    
    //This stops the methods for autonomous
	public void disabledInit() {
		driveCommand.cancel();
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