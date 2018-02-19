package org.usfirst.frc.team2022.subsystems;

import org.usfirst.frc.team2022.commands.ElevatorManualCommand;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {
	public int extensionLimit;
	private static final NeutralMode NeutralMode = null;
	private WPI_TalonSRX elevatorMotor;
	
	public ElevatorSubsystem(int motorPort1) {
		elevatorMotor = new WPI_TalonSRX(motorPort1);
		elevatorMotor.setInverted(true);
	}
	
	public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorManualCommand());
    }
	
	public void setElevatorSpeed(double speed) {
		elevatorMotor.set(speed);
	}
	
	public void stopElevator(){
		elevatorMotor.set(0);
	}
	
	public void enableStop(){
		elevatorMotor.setNeutralMode(NeutralMode.Brake);
	}
	public void disableStop(){
		elevatorMotor.setNeutralMode(NeutralMode.Coast);
	}
	
	public void stop() {
		stopElevator();
	}
	
    public double getEncoderDistance(){
    	return elevatorMotor.getSensorCollection().getQuadraturePosition();
    }
    
    public double getEncoderVelocity(){
    	return elevatorMotor.getSensorCollection().getQuadratureVelocity();
    }
    
    public void resetEncoderPosition(){
    	elevatorMotor.getSensorCollection().setQuadraturePosition(0, 0);
    }
    
	public void enableBrake(){
		elevatorMotor.setNeutralMode(NeutralMode.Brake);
	}
			
	public void disableBrake(){
		elevatorMotor.setNeutralMode(NeutralMode.Coast);
	}
}
