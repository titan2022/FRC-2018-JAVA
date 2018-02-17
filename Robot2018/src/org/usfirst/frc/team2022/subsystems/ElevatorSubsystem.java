package org.usfirst.frc.team2022.subsystems;

import org.usfirst.frc.team2022.commands.ElevatorCommand;
import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {
	
	private static final NeutralMode NeutralMode = null;
	
	private WPI_TalonSRX frontElevatorMotor, backElevatorMotor;
	
	private Encoder backEncoder, frontEncoder;
	
	public ElevatorSubsystem() {
		frontElevatorMotor = new WPI_TalonSRX(RobotMap.FRONT_ELEVATOR_PORT);
		backElevatorMotor = new WPI_TalonSRX(RobotMap.BACK_ELEVATOR_PORT);
		
		frontEncoder = new Encoder(RobotMap.FRONT_ENCODER_PORT_A, RobotMap.FRONT_ENCODER_PORT_B, false);
		backEncoder = new Encoder(RobotMap.BACK_ENCODER_PORT_A, RobotMap.BACK_ENCODER_PORT_B, false);
		
		//Set encoder distance per pulse
		frontEncoder.setDistancePerPulse(ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK);
		backEncoder.setDistancePerPulse(ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK);
	}
	
	public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorCommand());
    }
	
	public void setFrontElevator(double speed) {
		frontElevatorMotor.set(speed);
	}
	
	public void setBackElevator(double speed) {
		backElevatorMotor.set(speed);
	}
	
	public void stopFrontElevator(){
		frontElevatorMotor.set(0);
	}
	
	public void stopBackElevator(){
		backElevatorMotor.set(0);
	}
	
	public void enableStop(){
		frontElevatorMotor.setNeutralMode(NeutralMode.Brake);	
		backElevatorMotor.setNeutralMode(NeutralMode.Brake);
	}
	public void disableStop(){
		frontElevatorMotor.setNeutralMode(NeutralMode.Coast);	
		backElevatorMotor.setNeutralMode(NeutralMode.Coast);
	}
	
	//Get Encoders
	public Encoder getFrontEncoder(){
		return frontEncoder;
	}
	public Encoder getBackEncoder(){
		return backEncoder;
	}
	
	//Get Encoder Distances
	public double getFrontEncoderDistance(){
		return frontEncoder.getDistance();
	}	
	public double getBackEncoderDistance(){
		return backEncoder.getDistance();
	}
	
	//Get Encoder counts
	public int getFrontEncoderCount(){
		return frontEncoder.get();
	}	
	public int getBackEncoderCount(){
		return backEncoder.get();
	}
	
	//Get Encoder Rates
	public double getFrontEncoderRate(){
		return frontEncoder.getRate();
	}	
	public double getBackEncoderRate(){
		return backEncoder.getRate();
	}
	
	//reset encoders
	public void resetEncoders(){
		frontEncoder.reset();
		backEncoder.reset();
	}
	public void stop() {
		stopFrontElevator();
		stopBackElevator();
	}
	
}
