package org.usfirst.frc.team2022.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
	// # of encoder clicks that elevator is not allowed to extend past
	public final int extensionLimit = 10;
	
	TalonSRX el;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setElevatorSpeed(double speed) {
    	el.set(ControlMode.Velocity, speed);
    }
    
    public int getEncoderPos() {
    	return el.getSensorCollection().getQuadraturePosition();
    }
    
    // probably not useful but it's there anyway
    public int getEncoderVel() {
    	return el.getSensorCollection().getQuadratureVelocity();
    }
}

