package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.GrabberCommand;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabberSubsystem extends Subsystem {
	
	Talon leftMotor;

	private Talon rightMotor,upMotor;
	
	private Counter counter;
	private DigitalInput boxSwitch;
	Solenoid larmin, larmout;
	Solenoid rarmin, rarmout;
	public GrabberSubsystem(int port1, int port2) {
		//Instantiate motors		
		leftMotor = new Talon(port1);
		rightMotor = new Talon(port2);	
		upMotor = new Talon(RobotMap.UP_GRABBER_PORT);	
		
		//boxSwitch = new DigitalInput(RobotMap.BOX_SWITCH);

		//counter = new Counter(boxSwitch);
		//enableBrake();
		larmin = new Solenoid(0);
		larmout = new Solenoid(1);
		
		rarmin = new Solenoid(2);
		rarmout = new Solenoid(3);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GrabberCommand());
    }
    public boolean isSwitchSet() {
		return counter.get() > 0;
	}
    public void in() {
    	larmin.set(true);
    	larmout.set(false);
    	rarmin.set(true);
    	rarmout.set(false);
    }
    public void out() {
    	larmin.set(false);
    	larmout.set(true);
    	rarmin.set(false);
    	rarmout.set(true);
    }
    public void actuate(double value) {
    	upMotor.set(value);
    }
    public void outTake() {
    	leftMotor.set(ConstantsMap.GrabberSpeed);
    	rightMotor.set(ConstantsMap.GrabberSpeed);
    }
    public void inTake() {
    	leftMotor.set(-ConstantsMap.GrabberSpeed);
    	rightMotor.set(-ConstantsMap.GrabberSpeed);
    }
    public void stopTake() {
    	leftMotor.set(0);
    	rightMotor.set(0);
    }
    public void initializeCounter() {
        counter.reset();
    }
	public void setMotorSpeed(double speed){
		leftMotor.set(speed);
		rightMotor.set(speed);
	}
	
	public void stopMotors(){
		setMotorSpeed(0);
	}
	
	public void stop(){
		stopMotors();
	}
	 
	 /*public void enableBrake(){
		leftMotor.
		rightMotor.setNeutralMode(NeutralMode.Brake);
	 }
		
	 public void disableBrake(){
		leftMotor.setNeutralMode(NeutralMode.Coast);
		rightMotor.setNeutralMode(NeutralMode.Coast);
	 }*/
}
