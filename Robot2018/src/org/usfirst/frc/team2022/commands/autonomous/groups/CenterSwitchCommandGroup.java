package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDelayCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;
import org.usfirst.frc.team2022.commands.autonomous.FollowPathCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Waypoint;

public class CenterSwitchCommandGroup extends CommandGroup{

	public CenterSwitchCommandGroup(String side){
		if(side.charAt(0) == 'L'){
  			addSequential(new FollowPathCommand(new Waypoint[] {
  					// 0.0254 is inches-to-meters conversion factor
  					new Waypoint(0,0,0),
  					new Waypoint(0,40*0.0254,0),
  					new Waypoint(-65*0.0254,40*0.0254,0),
  					new Waypoint(-65*0.0254,52*0.0254,0)
  			}));
//  			addSequential(new AutoDriveStraightCommand(40));
//  			Timer.delay(1);
//    			addSequential(new AutoDriveTurnCommand(-90));
//    			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(65));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(90));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(12));
  		}
  		else{
  			addSequential(new FollowPathCommand(new Waypoint[] {
  					// 0.0254 is inches-to-meters conversion factor
  					new Waypoint(0,0,0),
  					new Waypoint(0,40*0.0254,0),
  					new Waypoint(65*0.0254,40*0.0254,0),
  					new Waypoint(65*0.0254,52*0.0254,0)
  			}));
//  			addSequential(new AutoDriveStraightCommand(40));
//  			Timer.delay(1);
//    			addSequential(new AutoDriveTurnCommand(90));
//    			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(65));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(-90));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveStraightCommand(12));
  		}
	}
}
