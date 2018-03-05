package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitchCommandGroup extends CommandGroup{

	public RightSwitchCommandGroup(String side){
  		if(side.charAt(0) == 'L') {
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(45));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(90));
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(37.5));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(-90));
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(54));
  		}
  		else{
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(45));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(90));
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(37.5));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(-90));
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(54));
  		}
	}
}
