package org.usfirst.frc.team2022.subsystems;

import org.usfirst.frc.team2022.commands.ElevatorManualCommand;
import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class ElevatorSubsystem extends PIDSubsystem {
	public int extensionLimit;
	private WPI_TalonSRX elevatorMotor;
	private Counter counter;
	private DigitalInput limitSwitch;
	public ElevatorSubsystem(int motorPort1) {
		super("Elevator",ConstantsMap.KP_ELEVATOR,ConstantsMap.KI_ELEVATOR,ConstantsMap.KD_ELEVATOR);
		elevatorMotor = new WPI_TalonSRX(motorPort1);
		elevatorMotor.setInverted(true);
		elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		setInputRange(0, 200);
		setOutputRange(-ConstantsMap.ELEVATOR_MAX_SPEED, ConstantsMap.ELEVATOR_MAX_SPEED);
		setAbsoluteTolerance(ConstantsMap.ELEVATOR_ERR_TOLERANCE);
		
		limitSwitch = new DigitalInput(RobotMap.ELEVATOR_SWITCH);
		counter = new Counter(limitSwitch);		
		
	}
	
	public boolean isSwitchSet() {
		return counter.get() > 0;
	}

    public void initializeCounter() {
        counter.reset();
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
    	return elevatorMotor.getSelectedSensorPosition(0);
    }
    
    public double getEncoderVelocity(){
    	return elevatorMotor.getSelectedSensorVelocity(0);
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

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return elevatorMotor.getSelectedSensorPosition(0);
	}

	@Override
	protected void usePIDOutput(double output) {
		elevatorMotor.pidWrite(output);
		
	}
}
