package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDelayCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitchCommandGroup extends CommandGroup{

	public LeftSwitchCommandGroup(String side){
		System.out.println("AutoLeftSwitch");
		long start = System.currentTimeMillis();
  		if(side.charAt(0) == 'L'){
  			//only goes forward turns then directly to plate 
  			//168 is distance from back to middle of switch
  			
  			addSequential(new AutoDriveStraightCommand(150));
  			addSequential(new AutoDelayCommand(1000));
  			addParallel(new ElevatorMoveToCommand(12),1000);
  			addSequential(new AutoDriveTurnCommand(90));
  			
  			addSequential(new AutoDelayCommand(1000));
  			//this value will change based off starting pos of robot
  			
  			addSequential(new AutoDriveStraightCommand(15),2000);
	  		addSequential(new AutoGrabberCommand(false));;
  			
  		}
  		else{
  			addSequential(new AutoDriveStraightCommand(120));
  			//168 is distance from back to middle of switch
  			/*//
  			addSequential(new AutoDriveStraightCommand(48));
  			addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveTurnCommand(90));
  			addSequential(new AutoDelayCommand(1000));
  			//this value will change based off starting pos of robot
  			addSequential(new AutoDriveStraightCommand(153));
  			addParallel(new ElevatorMoveToCommand(36));
	  		addSequential(new AutoGrabberCommand());;*/
  		}
  		long end = System.currentTimeMillis();
  		System.out.println("Time" + (end-start));
	}
}
