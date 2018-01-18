
package org.usfirst.frc.team2022.robot;

import org.usfirst.frc.team2022.command.DriveCommand;
import org.usfirst.frc.team2022.command.ShooterCommand;
import org.usfirst.frc.team2022.subsystem.DriveSubsystem;
import org.usfirst.frc.team2022.subsystem.ShooterSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
	public static final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
	
	//LIGHTS!!
//	public static final LightSubsystem lights = new LightSubsystem();
	
	//Create References to commands
	public DriveCommand driveCommand;
	public ShooterCommand shooterCommand;
	//Create reference to OI
	public static OI oi;
	public XboxMap xboxMap = new XboxMap();
	//Initialization code ran when you turn on the robot
    public void robotInit() {
    	//Instantiate OI
    	oi = new OI();
    	
    	//Instantiate Commands
    	driveCommand = new DriveCommand();
    	shooterCommand = new ShooterCommand();
    }
    
	
    //This starts the methods for autonomous
    public void autonomousInit() {
    	
    }
    
    //This starts the methods for teleop and stops methods for autonomous
    @Override
	public void teleopInit() {
    	driveCommand.start();
    	shooterCommand.start();
    }
    
    //This stops the methods for autonomous	
	@Override
	public void disabledInit() {

	}
    
	//Methods below this line do not need to be edited/////////////////////////////////////////////////////////////////////////
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
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
    	LiveWindow.run();
    }


	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
}
