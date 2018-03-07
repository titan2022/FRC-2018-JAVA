package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchCommandGroup extends CommandGroup{

	public CenterSwitchCommandGroup(String side){
  		if(side.charAt(0) == 'L'){
  			addSequential(new AutoDriveStraightCommand(40));
  			Timer.delay(1);
    		addSequential(new AutoDriveTurnCommand(-90));
    		Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(65));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(90));
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(12));
  		}
  		else{
  			addSequential(new AutoDriveStraightCommand(40));
  			Timer.delay(1);
    		addSequential(new AutoDriveTurnCommand(90));
    		Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(65));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(-90));
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(12));
  		}
	}
}
