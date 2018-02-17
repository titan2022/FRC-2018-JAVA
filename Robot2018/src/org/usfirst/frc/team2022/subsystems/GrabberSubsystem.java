package org.usfirst.frc.team2022.subsystems;

import org.usfirst.frc.team2022.commands.GrabberCommand;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabberSubsystem extends Subsystem {
	
	private WPI_TalonSRX outterLeft, outterRight, innerLeft, innerRight;
	
	private DigitalInput boxSwitch;
	private DoubleSolenoid solenoid, solenoid2;
	
	public GrabberSubsystem() {
		//Instantiate motors		
		outterLeft = new WPI_TalonSRX(RobotMap.OUTTERLEFT_GRABBER_PORT);
		outterRight = new WPI_TalonSRX(RobotMap.OUTTERRIGHT_GRABBER_PORT);
		
		innerLeft = new WPI_TalonSRX(RobotMap.INNERLEFT_GRABBER_PORT);		
		innerRight = new WPI_TalonSRX(RobotMap.INNERRIGHT_GRABBER_PORT);		
		
		outterLeft.setInverted(true);
		outterRight.setInverted(true);
		innerLeft.setInverted(true);
		innerRight.setInverted(true);
		
		solenoid = new DoubleSolenoid(RobotMap.SOLENOID_PORT_1, RobotMap.SOLENOID_PORT_2);
		solenoid2 = new DoubleSolenoid(RobotMap.SOLENOID_PORT_3, RobotMap.SOLENOID_PORT_4);
		
		boxSwitch = new DigitalInput(RobotMap.BOX_SWITCH);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GrabberCommand());
    }

    public boolean getBoxSwitch(){
    	return boxSwitch.get();
    }

	public void setOutterGrabberSpeed(double speed) {
		outterLeft.set(speed);
		outterRight.set(-speed);
	}	
	
	public void setInnerGrabberSpeed (double speed) {
		innerLeft.set(speed);
		innerRight.set(-speed);
	}
	
	public void stopOutterGrabber(){
		outterLeft.set(0);
		outterRight.set(0);
	}
	
	public void stopInnerGrabber(){
		innerLeft.set(0);
		innerRight.set(0);
	}
	
	public void solinoidForward(){
		solenoid.set(DoubleSolenoid.Value.kForward);
		solenoid2.set(DoubleSolenoid.Value.kForward);
	}
	
	public void solinoidReverse(){
		solenoid.set(DoubleSolenoid.Value.kReverse);
		solenoid2.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopPiston() {
		solenoid.set(DoubleSolenoid.Value.kOff);
		solenoid2.set(DoubleSolenoid.Value.kOff);
	}
	
	public void stop(){
		stopOutterGrabber();
		stopInnerGrabber();
		stopPiston();
	}
}
