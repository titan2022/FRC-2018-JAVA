//package org.usfirst.frc.team2022.commands;
//
//import org.usfirst.frc.team2022.robot.ConstantsMap;
//import org.usfirst.frc.team2022.robot.CustomPIDController;
//import org.usfirst.frc.team2022.robot.Robot;
//import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class ElevatorMoveToCommand extends Command {
//	ElevatorSubsystem elevator;
//	int location;
//	CustomPIDController pid;
//	
//    public ElevatorMoveToCommand(boolean useFront, int location) {
////    	if (useFront) elevator = Robot.frontElevatorSubsystem;
////    	else elevator = Robot.backElevatorSubsystem;
//    	
//        requires(elevator);
//        this.location = location;
//        pid = new CustomPIDController(ConstantsMap.KP_ELEVATOR,ConstantsMap.KI_ELEVATOR,ConstantsMap.KD_ELEVATOR,ConstantsMap.KF_ELEVATOR,
//        		ConstantsMap.ELEVATOR_ERR_TOLERANCE, -ConstantsMap.ELEVATOR_MAX_SPEED,ConstantsMap.ELEVATOR_MAX_SPEED);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	elevator.setElevatorSpeed(pid.update(elevator.getEncoderDistance()));
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return pid.isFinished();
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	elevator.setElevatorSpeed(0.0);
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
