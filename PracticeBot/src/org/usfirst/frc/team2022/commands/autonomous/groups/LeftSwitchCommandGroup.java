package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.FollowPathCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Waypoint;

public class LeftSwitchCommandGroup extends CommandGroup{

	public LeftSwitchCommandGroup(String side){
		System.out.println("AutoLeftSwitch");
  		if(side.charAt(0) == 'L'){
  			addSequential(new FollowPathCommand(new Waypoint[] {
  					// 0.0254 is inches-to-meters conversion factor
  					new Waypoint(0,0,0),
  					new Waypoint(0,168*0.0254,0),
  					new Waypoint(12*0.0254,168*0.0254,0)
  			}));
//  			//only goes forward turns then directly to plate 
//  			//168 is distance from back to middle of switch
//  			addSequential(new AutoDriveStraightCommand(168));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(90));
//  			Timer.delay(1);
//  			//this value will change based off starting pos of robot
//  			addSequential(new AutoDriveStraightCommand(12));
  			
  		}
  		else{
  			addSequential(new FollowPathCommand(new Waypoint[] {
  					// 0.0254 is inches-to-meters conversion factor
  					new Waypoint(0,0,0),
  					new Waypoint(0,48*0.0254,0),
  					new Waypoint(153*0.0254,48*0.0254,0)
  			}));
//  			//168 is distance from back to middle of switch
//  			//
//  			addSequential(new AutoDriveStraightCommand(48));
//  			Timer.delay(1);
//  			addSequential(new AutoDriveTurnCommand(90));
//  			Timer.delay(1);
//  			//this value will change based off starting pos of robot
//  			addSequential(new AutoDriveStraightCommand(153));
  		}
	}
}
