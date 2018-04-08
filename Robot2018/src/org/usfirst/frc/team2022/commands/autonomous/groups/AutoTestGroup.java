package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoDriveTurnCommand;
import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTestGroup extends CommandGroup{

	public AutoTestGroup(){
		System.out.println("AutoTest");
		addSequential(new AutoGrabberCommand(false));
		
	}
}
