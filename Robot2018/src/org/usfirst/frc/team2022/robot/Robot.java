package org.usfirst.frc.team2022.robot;


import org.usfirst.frc.team2022.commands.DriveCommand;
import org.usfirst.frc.team2022.commands.ElevatorManualCommand;
import org.usfirst.frc.team2022.commands.autonomous.groups.AutoCrossLineCommandGroup;
import org.usfirst.frc.team2022.commands.GrabberCommand;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;
import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

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
	
	public double position;
	
	//Autonomous
	CommandGroup autonomousCommand = new CommandGroup();
	SendableChooser<String> autoTypeChooser;
	
	//Initialization code ran when you turn on the robot
    public void robotInit() {    	

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
    }
    
    
    //This starts the methods for autonomous
    public void autonomousInit() {
    	String gameData;
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	System.out.println("Auto");

    	try{
    	autonomousCommand = new AutoCrossLineCommandGroup();
//	    	//Left
//	    	if(autoTypeChooser.getSelected().equals("left")){
//	    		if(gameData.charAt(0) == 'L'){
//	    			// left switch
//	    		}
//	    		if(gameData.charAt(0) != 'L' && gameData.charAt(1) == 'L'){
//	    			//left scale
//	    		}
//	    		if(gameData.charAt(0) != 'L' && gameData.charAt(1) != 'L'){
//	    			//cross line
//	    		}
//	    	}
//	    	//Center
//	    	else if(autoTypeChooser.getSelected().equals("center")){
//	    		if(gameData.charAt(0) == 'L'){
//	    			//left switch
//	    		}
//	    		else{
//	    			//right switch
//	    		}
//	    	}
//	    	//Right
//	    	else if(autoTypeChooser.getSelected().equals("right")){
//	    		if(gameData.charAt(0) == 'R'){
//	    			//right switch
//	    		}
//	    		if(gameData.charAt(0) != 'R' && gameData.charAt(1) == 'R'){
//	    			//right scale
//	    		}
//	    		if(gameData.charAt(0) != 'R' && gameData.charAt(1) != 'R'){
//	    			//cross line
//	    		}
//	    	}
    	}
    	catch(Exception ex){
    		System.out.println(ex);
    	}
    	
		autonomousCommand.start();
    }
    
    //This starts the methods for teleop and stops methods for autonomous
	public void teleopInit() {
    	driveCommand.start();
    	grabberCommand.start();
    	elevatorCommand.start();
    }
    
    //This stops the methods for autonomous
	public void disabledInit() {
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