package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDelayCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterSwitchCommandGroup extends CommandGroup{

	public CenterSwitchCommandGroup(String side){
  		if(side.charAt(0) == 'L'){
  			addSequential(new AutoDriveStraightCommand(45));
  			addSequential(new AutoDelayCommand(1000));
    		addSequential(new AutoDriveTurnCommand(-90));
    		addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveStraightCommand(50));
  			addSequential(new AutoDelayCommand(1000));
  			addParallel(new ElevatorMoveToCommand(36),1000);
  			addSequential(new AutoDriveTurnCommand(90));
  			
  			addSequential(new AutoDelayCommand(1000));		
  			
  			addSequential(new AutoDriveStraightCommand(50),2000);  			
  			addSequential(new AutoGrabberCommand(false));
  			
//  			addSequential(new AutoDriveStraightCommand(45));
//  			addSequential(new AutoDelayCommand(1000));
//  			addSequential(new AutoDriveTurnCommand(-45));
//  			addSequential(new AutoDelayCommand(1000));
//  			addSequential(new AutoDriveStraightCommand(87));
//  			addSequential(new AutoDriveTurnCommand(30),2000);
//  			addSequential(new AutoGrabberCommand(false));
  		}	
  		else{
  			addSequential(new AutoDriveStraightCommand(45));
  			addSequential(new AutoDelayCommand(1000));
    		addSequential(new AutoDriveTurnCommand(90));
    		addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveStraightCommand(40));
  			addSequential(new AutoDelayCommand(1000));
  			addParallel(new ElevatorMoveToCommand(36),1000);
  			addSequential(new AutoDriveTurnCommand(-90));
  			addSequential(new AutoDelayCommand(1000));	  			
  			addSequential(new AutoDriveStraightCommand(50),2000);  			
  			addSequential(new AutoGrabberCommand(false));
  		}
	}
}
