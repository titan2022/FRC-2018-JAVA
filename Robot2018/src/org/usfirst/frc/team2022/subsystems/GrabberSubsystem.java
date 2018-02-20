package org.usfirst.frc.team2022.subsystems;

import org.usfirst.frc.team2022.commands.GrabberCommand;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabberSubsystem extends Subsystem {
	private static final NeutralMode NeutralMode = null;
	private WPI_TalonSRX leftMotor, rightMotor;
	
	public GrabberSubsystem(int port1, int port2) {
		//Instantiate motors		
		leftMotor = new WPI_TalonSRX(port1);
		rightMotor = new WPI_TalonSRX(port2);	
		
		leftMotor.setInverted(true);
		rightMotor.setInverted(true);
		
//		boxSwitch = new DigitalInput(RobotMap.BOX_SWITCH);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GrabberCommand());
    }

	public void setMotorSpeed(double speed){
		leftMotor.set(speed);
		rightMotor.set(-speed);
	}
	
	public void stopMotors(){
		setMotorSpeed(0);
	}
	
	public void stop(){
		stopMotors();
	}
	
//	public boolean getBoxSwitch(){
//	   return boxSwitch.get();
//	}
	 
	 public void enableBrake(){
		leftMotor.setNeutralMode(NeutralMode.Brake);
		rightMotor.setNeutralMode(NeutralMode.Brake);
	 }
		
	 public void disableBrake(){
		leftMotor.setNeutralMode(NeutralMode.Coast);
		rightMotor.setNeutralMode(NeutralMode.Coast);
	 }
}