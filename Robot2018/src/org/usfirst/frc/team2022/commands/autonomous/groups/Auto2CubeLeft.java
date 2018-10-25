package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDelayCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto2CubeLeft extends CommandGroup {

	public Auto2CubeLeft() {
		
		/*addSequential(new AutoDriveStraightCommand(150));
		addSequential(new AutoDelayCommand(1000));
		//addParallel(new ElevatorMoveToCommand(12),1000);
		addSequential(new AutoDriveTurnCommand(90));  						
		addSequential(new AutoDelayCommand(1000));
		//this value will change based off starting pos of robot
		addSequential(new AutoDriveStraightCommand(20),2000);  			
  		addSequential(new AutoGrabberCommand(false));
		addSequential(new AutoDelayCommand(1000));
		addSequential(new AutoDriveStraightCommand(-20));  
		addSequential(new AutoDelayCommand(1000));
		addSequential(new AutoDriveTurnCommand(-90));  						
		addSequential(new AutoDriveStraightCommand(80));
		addSequential(new AutoDelayCommand(1000));
		addSequential(new AutoDriveTurnCommand(90));  						
		addSequential(new AutoDriveStraightCommand(30));
		addSequential(new AutoDriveTurnCommand(90));  						
		addSequential(new AutoDriveStraightCommand(56));
		//stuff to pick up cube, need to implement the actuate for auto
		addSequential(new AutoDriveStraightCommand(-50));
		addSequential(new AutoDriveTurnCommand(90));  						
		addSequential(new AutoDriveStraightCommand(40));
		addSequential(new AutoDriveTurnCommand(90));  						
		addSequential(new AutoDriveStraightCommand(75));
		addParallel(new ElevatorMoveToCommand(65), 1000);
		addSequential(new AutoDriveTurnCommand(90));  						
		addSequential(new AutoDriveStraightCommand(10));
		//stuff to out take cube, need to implement the actuate for auto
		addSequential(new AutoGrabberCommand(false));*/
		



	}
}
