package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitchCommandGroup extends CommandGroup{

	public LeftSwitchCommandGroup(String side){
		System.out.println("AutoLeftSwitch");
  		if(side.charAt(0) == 'L'){
  			//only goes forward turns then directly to plate 
  			//168 is distance from back to middle of switch
  			addSequential(new AutoDriveStraightCommand(150));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(90));
  			Timer.delay(1);
  			//this value will change based off starting pos of robot
  			addSequential(new AutoDriveStraightCommand(12));
  			
  		}
  		else{
  			//168 is distance from back to middle of switch
  			//
  			addSequential(new AutoDriveStraightCommand(48));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(90));
  			Timer.delay(1);
  			//this value will change based off starting pos of robot
  			addSequential(new AutoDriveStraightCommand(153));
  		}
	}
}
