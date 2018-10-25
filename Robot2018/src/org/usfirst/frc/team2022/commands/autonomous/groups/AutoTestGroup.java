package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.FollowPathCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.Trajectory.Config;
import jaci.pathfinder.modifiers.TankModifier;

public class AutoTestGroup extends CommandGroup{

	public AutoTestGroup(){
		
		Waypoint[] points =  new Waypoint[] {
				new Waypoint(4, 0, Pathfinder.d2r(0)),
				new Waypoint(0, 0, 0)				
				};
 
    	addSequential(new FollowPathCommand(points));
		
	}
}
