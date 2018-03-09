package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDelayCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSwitchCommandGroup extends CommandGroup{

	public RightSwitchCommandGroup(String side){
		if(side.charAt(0) == 'L'){
  			//only goes forward turns then directly to plate 
  			//168 is distance from back to middle of switch
  			
  			addSequential(new AutoDriveStraightCommand(120));
  			addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveTurnCommand(-90));
  			addSequential(new AutoDelayCommand(1000));
  			//this value will change based off starting pos of robot
  			addSequential(new AutoDriveStraightCommand(12));
  			addParallel(new ElevatorMoveToCommand(36));
	  		addSequential(new AutoGrabberCommand());;
  			
  		}
  		else{
  			//168 is distance from back to middle of switch
  			//
  			addSequential(new AutoDriveStraightCommand(120));
  			addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveTurnCommand(-90));
  			addSequential(new AutoDelayCommand(1000));
  			//this value will change based off starting pos of robot
  			addSequential(new AutoDriveStraightCommand(12));
  			addParallel(new ElevatorMoveToCommand(36));
	  		addSequential(new AutoGrabberCommand());;
  		}
	}
}
