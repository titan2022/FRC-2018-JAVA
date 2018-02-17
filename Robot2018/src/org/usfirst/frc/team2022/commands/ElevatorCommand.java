package org.usfirst.frc.team2022.commands;
import org.usfirst.frc.team2022.robot.OI;
import org.usfirst.frc.team2022.robot.Robot;
import org.usfirst.frc.team2022.robot.XboxMap;
import org.usfirst.frc.team2022.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorCommand extends Command{
	ElevatorSubsystem elevatorSubsystem = Robot.elevatorSubsystem;
	XboxMap xboxMap = new XboxMap();
	OI oi = Robot.oi;
	
	double frontElevatorMotorSpeed = -0.3;
	
	private boolean frontElevatorSwitch = false;
	
	private double lastPressed = 0;
	
	protected void execute() {  
		//Front Elevator
		if(xboxMap.controlFrontElevator() && System.currentTimeMillis() - lastPressed > 200){
			frontElevatorSwitch = !frontElevatorSwitch ;
    		lastPressed = System.currentTimeMillis();
    	}
		if(frontElevatorSwitch){
    		frontElevatorMotorSpeed *= -1;
    		elevatorSubsystem.setFrontElevator(frontElevatorMotorSpeed);
    	}
		
		//Back Elevator
		double backElevatorMotorSpeed;
		backElevatorMotorSpeed = xboxMap.controlBackElevatorGoUp(); 
    	if(Math.abs(backElevatorMotorSpeed) < 0.1){
    		backElevatorMotorSpeed = 0;
    	}
    	
    	backElevatorMotorSpeed = -1 * xboxMap.controlBackElevatorGoDown(); 
    	if(Math.abs(backElevatorMotorSpeed) < 0.1){
    		backElevatorMotorSpeed = 0;
    	}
    	elevatorSubsystem.setBackElevator(backElevatorMotorSpeed);
    	
    	
    	
    	
    	
    	SmartDashboard.putNumber("Front Encoder Distance: ", elevatorSubsystem.getFrontEncoderDistance());
    	SmartDashboard.putNumber("Back Encoder Distance: ", elevatorSubsystem.getBackEncoderDistance());
   	}
	
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	elevatorSubsystem.stopFrontElevator();
    	elevatorSubsystem.stopBackElevator();
    }

    protected void interrupted() {
    	
    }
}
