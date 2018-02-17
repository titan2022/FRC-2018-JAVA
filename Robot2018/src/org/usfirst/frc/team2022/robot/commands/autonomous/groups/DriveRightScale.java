package org.usfirst.frc.team2022.robot.commands.autonomous.groups;

import org.usfirst.frc.team2022.robot.commands.autonomous.AutoDriveStraightCommand;
import org.usfirst.frc.team2022.robot.commands.autonomous.AutoDriveTurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveRightScale extends CommandGroup {

    public DriveRightScale() {
    	addSequential(new AutoDriveStraightCommand(296.85));
    	
    	// may be necessary if power cube does not reach scale
    	//addSequential(new AutoDriveTurnCommand(false));
    	//addSequential(new AutoDriveStraightCommand(5.54));
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
