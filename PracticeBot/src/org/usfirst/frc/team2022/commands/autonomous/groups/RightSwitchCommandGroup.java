package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.FollowPathCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Waypoint;

public class RightSwitchCommandGroup extends CommandGroup{
	public RightSwitchCommandGroup(String side){
  		if(side.charAt(0) == 'L') {
  			addSequential(new FollowPathCommand(new Waypoint[] {
  					// 0.0254 is inches-to-meters conversion factor
  					new Waypoint(0,0,0),
  					new Waypoint(0,45*0.0254,0),
  					new Waypoint(37.5*0.0254,45*0.0254,0),
  					new Waypoint(37.5*0.0254,99*0.0254,0)
  			}));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(45));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(90));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(37.5));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(-90));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(54));
  		}
  		else{
  			addSequential(new FollowPathCommand(new Waypoint[] {
  					// 0.0254 is inches-to-meters conversion factor
  					new Waypoint(0,0,0),
  					new Waypoint(0,45*0.0254,0),
  					new Waypoint(37.5*0.0254,45*0.0254,0),
  					new Waypoint(37.5*0.0254,99*0.0254,0)
  			}));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(45));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(90));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(37.5));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(-90));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(54));
  		}
	}
}
