package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDelayCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightScaleCommandGroup extends CommandGroup{

	public RightScaleCommandGroup(String side,boolean defer){
		System.out.println("AutoLeftScale");
  		if((side.charAt(1) == 'R')){
  			//only goes forward turns then directly to plate 
  			//319 is distance from back to middle of scale
  			addSequential(new AutoDriveStraightCommand(305));
  			addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveTurnCommand(-90));
  			addSequential(new AutoDelayCommand(1000));
  			addParallel(new ElevatorMoveToCommand(75));
  			
  			//this value will change based off starting pos of robot
  			
	  		addSequential(new AutoGrabberCommand());;
  			
  		}
  		else if(!defer) {
  			//doing scale even if not on our side
  			addSequential(new AutoDriveStraightCommand(200));
  			addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveTurnCommand(-90));
  			addSequential(new AutoDelayCommand(1000));
  			addSequential(new AutoDriveStraightCommand(60));
  			addSequential(new AutoDelayCommand(1000));
  			addParallel(new ElevatorMoveToCommand(75));
  			addSequential(new AutoDriveTurnCommand(90));
  			
	  		addSequential(new AutoGrabberCommand());;
  		}
  		else{
  			//do switch if on our side
  			if(side.charAt(0) == 'R') {
  				addSequential(new AutoDriveStraightCommand(110));
  				addSequential(new AutoDriveTurnCommand(-90));
  				addSequential(new AutoDriveTurnCommand(12));
  				addParallel(new ElevatorMoveToCommand(36));
  		  		addSequential(new AutoGrabberCommand());;

  			}
  			else {
  				//only do auto
  				addSequential(new AutoDriveStraightCommand(163));
  			}
  			
  		}
	}
}
