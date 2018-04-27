package org.usfirst.frc.team2022.commands.autonomous;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.subsystems.DriveSubsystem;

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
	final double WHEEL_RADIUS_M = ConstantsMap.ROBOT_WHEEL_RADIUS_INCHES * 0.0254;
	// credit where credit is due: half of this is more or less just the Pathfinder library's example code
	DriveSubsystem driveSubsystem = Robot.driveSubsystem;
	
	EncoderFollower leftFollower;
	EncoderFollower rightFollower;
	public FollowPathCommand(Waypoint[] points) {
        requires(driveSubsystem);
        
        // fit method, sample quantity, time step, max vel, max accl, max jerk
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
        		0.05, 1.7, 2.0, 60.0);
        Trajectory trajectory = Pathfinder.generate(points, config);
        TankModifier modifier = new TankModifier(trajectory).modify(WHEEL_RADIUS_M); // modify (wheel diameter)
        this.leftFollower = new EncoderFollower(modifier.getLeftTrajectory());
        this. rightFollower = new EncoderFollower(modifier.getRightTrajectory());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// current enc distance, ticks/rev, wheel diameter (m)
    	leftFollower.configureEncoder((int) Math.floor(driveSubsystem.getLeftEncoderDistance()),
    			ConstantsMap.DRIVE_TICKS_PER_REV, WHEEL_RADIUS_M);
    	rightFollower.configureEncoder((int) Math.floor(driveSubsystem.getRightEncoderDistance()),
    			ConstantsMap.DRIVE_TICKS_PER_REV, WHEEL_RADIUS_M);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double l = leftFollower.calculate((int) Math.floor(driveSubsystem.getLeftEncoderDistance()));
    	double r = rightFollower.calculate((int) Math.floor(driveSubsystem.getRightEncoderDistance()));
    	
    	double gyroDir = driveSubsystem.getGyroAngle();   // Assuming the gyro is giving a value in degrees
    	double targetDir = Pathfinder.r2d(leftFollower.getHeading());  // Should also be in degrees
    	double angleDifference = Pathfinder.boundHalfDegrees(targetDir - gyroDir);
    	double turn = 0.8 * (-1.0/80.0) * angleDifference;
    	
    	driveSubsystem.tankDrive(l + turn, r - turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return leftFollower.isFinished() && rightFollower.isFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
