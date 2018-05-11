package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.FollowPathCommand;
import org.usfirst.frc.team2022.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class AutoCrossLineCommandGroup extends CommandGroup{

	public AutoCrossLineCommandGroup(){
		Waypoint[] points =  new Waypoint[] {
				new Waypoint(0, 0, 0),
				new Waypoint(50, 0, Pathfinder.d2r(0))
				};
    	Config config = new Config(
				Trajectory.FitMethod.HERMITE_CUBIC,
				Trajectory.Config.SAMPLES_HIGH, 1, 30.0, 20.0, 240.0);
    	TankModifier profile = new TankModifier(Pathfinder.generate(points, config)).modify(28);
    	
    	addSequential(new FollowPathCommand(profile));
//		addSequential(new AutoDriveStraightCommand(200));
	}
		

}
