package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.Unit.UnitType;
import org.usfirst.frc.team2022.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
/**
 *
 */
public class FollowPathCommand extends Command {
	final double WHEEL_RADIUS_M = ConstantsMap.ROBOT_WHEEL_RADIUS.getValueAs(UnitType.INCHES) * 0.0254;
	// credit where credit is due: half of this is more or less just the Pathfinder library's example code
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	
	EncoderFollower leftFollower;
	EncoderFollower rightFollower;
	Trajectory trajectory;
	TankModifier modifier;
	
	public FollowPathCommand(TankModifier profile) {
        requires(driveSubsystem);
        System.out.println("My name is jeff8");
        modifier = profile;
        System.out.println("created");
    }
	
	public FollowPathCommand(Waypoint[] points) {
        requires(driveSubsystem);
        System.out.println("My name is tim");
        // fit method, sample quantity, time step, max vel, max accl, max jerk
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_FAST,
        		0.05, 1.0, 1.0, 30.0);
        System.out.println("My name is timmy");
        trajectory = Pathfinder.generate(points, config);
        
        System.out.println("My name is timmyeee");
        modifier = new TankModifier(trajectory).modify(ConstantsMap.BASE_WIDTH); // modify (wheel diameter)
        System.out.println("My name is timmieieiei");
       
        System.out.println("created");
		

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// current enc distance, ticks/rev, wheel diameter (m)
    	driveSubsystem.enableBrake();
    	driveSubsystem.resetEncoders();
    	driveSubsystem.resetGyro();
    	leftFollower = new EncoderFollower(modifier.getLeftTrajectory());
        rightFollower = new EncoderFollower(modifier.getRightTrajectory());
    	leftFollower.configureEncoder(driveSubsystem.getLeftEncoderCount(),
    			ConstantsMap.DRIVE_TICKS_PER_REV, WHEEL_RADIUS_M);
    	rightFollower.configureEncoder((driveSubsystem.getRightEncoderCount()),
    			ConstantsMap.DRIVE_TICKS_PER_REV, WHEEL_RADIUS_M);
    	
    	// From https://github.com/JacisNonsense/Pathfinder/wiki/Pathfinder-for-FRC---Java:
    	// The first argument is the proportional gain. Usually this will be quite high
    	// The second argument is the integral gain. This is unused for motion profiling
    	// The third argument is the derivative gain. Tweak this if you are unhappy with the tracking of the trajectory
    	// The fourth argument is the velocity ratio. This is 1 over the maximum velocity you provided in the 
        //     trajectory configuration (it translates m/s to a -1 to 1 scale that your motors can read)
    	// The fifth argument is your acceleration gain. Tweak this if you want to get to a higher or lower speed quicker
    	leftFollower.configurePIDVA(1.0, 0, 0.1, 1 / 1, 0);
    	rightFollower.configurePIDVA(1.0, 0, 0.1, 1 / 1, 0);
    	System.out.println("initialized");

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double l = leftFollower.calculate(driveSubsystem.getLeftEncoderCount());
    	double r = rightFollower.calculate(driveSubsystem.getRightEncoderCount());
    	
    	double gyroDir = driveSubsystem.getGyroAngle();   // Assuming the gyro is giving a value in degrees
    	double targetDir = Pathfinder.r2d(leftFollower.getHeading());  // Should also be in degrees
    	double angleDifference = Pathfinder.boundHalfDegrees(targetDir - gyroDir);
    	double turn = 0.8 * (-1.0/80.0) * angleDifference;
    	
    	System.out.println("l:" + l + " r: " + r + " turn: " + turn + " traj len: " + trajectory.length());
    	
    	driveSubsystem.tankDrive(l + turn, r - turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return leftFollower.isFinished() && rightFollower.isFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}
