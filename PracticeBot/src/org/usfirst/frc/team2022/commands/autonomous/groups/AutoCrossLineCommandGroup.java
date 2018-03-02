package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCrossLineCommandGroup extends CommandGroup{

	public AutoCrossLineCommandGroup(){
		System.out.println("AutoLineGroup");
		Timer.delay(1);
		addSequential(new AutoDriveStraightCommand(45));
		addSequential(new AutoDriveTurnCommand(90));
		addSequential(new AutoDriveStraightCommand(37.5));
		addSequential(new AutoDriveTurnCommand(-90));
		addSequential(new AutoDriveStraightCommand(54));
	}
}
