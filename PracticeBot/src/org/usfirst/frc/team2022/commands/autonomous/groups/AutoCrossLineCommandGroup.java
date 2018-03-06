package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCrossLineCommandGroup extends CommandGroup{

	public AutoCrossLineCommandGroup(){
		addSequential(new AutoDriveStraightCommand(200));
	}
}
