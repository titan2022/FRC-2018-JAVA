package org.usfirst.frc.team2022.commands.autonomous.groups;

import org.usfirst.frc.team2022.commands.autonomous.AutoGrabberCommand;
import org.usfirst.frc.team2022.commands.autonomous.ElevatorMoveToCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTestGroup extends CommandGroup{

	public AutoTestGroup(){
		System.out.println("AutoTest");
		addSequential(new AutoGrabberCommand());
		
	}
}
