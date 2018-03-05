package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchCommandGroup extends CommandGroup{

	public CenterSwitchCommandGroup(String side){
  		if(side.charAt(0) == 'L'){
//  		addSequential(new AutoDriveTurnCommand(-90));
  			addSequential(new AutoDriveStraightCommand(150));
//  		addSequential(new AutoDriveTurnCommand(90));
  			addSequential(new AutoDriveStraightCommand(150));
  		}
  		else{
//  		addSequential(new AutoDriveTurnCommand(90));
  			addSequential(new AutoDriveStraightCommand(10));
//  		addSequential(new AutoDriveTurnCommand(-90));
  			addSequential(new AutoDriveStraightCommand(150));
  		}
	}
}
