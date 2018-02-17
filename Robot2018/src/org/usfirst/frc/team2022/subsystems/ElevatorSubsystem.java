package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.commands.ClimberCommand;
import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {
	
	private static final NeutralMode NeutralMode = null;
	
	private WPI_TalonSRX climberMotor;
	
	private boolean isAttatched;		//Determines if the climber functioned correctly
	private boolean movingDown;
	
	public ClimberSubsystem() {
		//Instantiate motors
		climberMotor = new WPI_TalonSRX(RobotMap.CLIMBER_MOTOR_PORT);
		
		isAttatched = false;
		movingDown = false;
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ClimberCommand());
    }
	
	public void setClimberSpeed(double speed) {
		climberMotor.set(speed);
	}
	
	public void stopClimber(){
		climberMotor.set(0);
	}
	
	public void enableStop(){
		climberMotor.setNeutralMode(NeutralMode.Brake);	
	}
	public void disableStop(){
		climberMotor.setNeutralMode(NeutralMode.Coast);
	}
	
	public void stop() {
		climberMotor.set(0);
		isAttatched = false;
		movingDown = false;
	}
	
}
