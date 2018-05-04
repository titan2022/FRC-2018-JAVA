package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.FollowPathCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Waypoint;

public class AutoCrossLineCommandGroup extends CommandGroup{

	public AutoCrossLineCommandGroup(){
		addSequential(new FollowPathCommand(new Waypoint[] {
				// 0.0254 is inches-to-meters conversion factor
				
				new Waypoint(50*0.0254,0,0),
				new Waypoint(0,0,0)
		}));
//		addSequential(new AutoDriveStraightCommand(200));
	}
		

}
