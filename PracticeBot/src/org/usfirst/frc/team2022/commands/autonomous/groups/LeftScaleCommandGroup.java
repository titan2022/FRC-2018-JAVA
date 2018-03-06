package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScaleCommandGroup extends CommandGroup{

	public LeftScaleCommandGroup(String side,boolean defer){
		System.out.println("AutoLeftSwitch");
  		if((side.charAt(1) == 'L')){
  			//only goes forward turns then directly to plate 
  			//319 is distance from back to middle of scale
  			addSequential(new AutoDriveStraightCommand(319));
  			Timer.delay(1);
  			addSequential(new AutoDriveTurnCommand(90));
  			Timer.delay(1);
  			addSequential(new AutoDriveStraightCommand(12));
  			//this value will change based off starting pos of robot
  			
  			
  		}
  		else if(!defer) {
  			System.out.println("Doing Opposite Switch");
  		}
  		else{
  			//do switch if on our side
  			if(side.charAt(0) == 'L') {
  				addSequential(new AutoDriveStraightCommand(110));
  				addSequential(new AutoDriveTurnCommand(90));
  				addSequential(new AutoDriveTurnCommand(12));

  			}
  			else {
  				//only do auto
  				addSequential(new AutoDriveStraightCommand(163));
  			}
  			
  		}
	}
}
