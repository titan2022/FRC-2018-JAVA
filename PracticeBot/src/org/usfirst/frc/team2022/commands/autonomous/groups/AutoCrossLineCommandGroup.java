package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCrossLineCommandGroup extends CommandGroup{

	public AutoCrossLineCommandGroup(){
		System.out.println("AutoLineGroup");
		Timer.delay(1);
		addSequential(new AutoDriveStraightCommand(30));
	}
}
