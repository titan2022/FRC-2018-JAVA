package org.usfirst.frc.team2022.subsystem;zu

import org.usfirst.frc.team2022.command.DriveCommand;
import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private WPI_TalonSRX left1,left2,left3,right1,right2,right3;

	
//	private boolean switchUrMom = false;

	public DriveSubsystem() {
		//Instantiate motors		
		left1 = new WPI_TalonSRX(RobotMap.DRIVE_PORT_1);
		left2 = new WPI_TalonSRX(RobotMap.DRIVE_PORT_2);
		left3 = new WPI_TalonSRX(RobotMap.DRIVE_PORT_3);
		
		right1 = new WPI_TalonSRX(RobotMap.DRIVE_PORT_4);		
		right2 = new WPI_TalonSRX(RobotMap.DRIVE_PORT_5);		
		right3 = new WPI_TalonSRX(RobotMap.DRIVE_PORT_6);		
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }
    
	// Setter methods for each side.
	public void setRightSpeed(double speed) {
			right1.set(speed);
			right2.set(speed);
			right3.set(speed);
			
			
			
	}	
	public void setLeftSpeed(double speed) {
		left1.set(speed);
		left2.set(speed);
		left3.set(speed);	
		
}	

	
	// Getter method for each side.
	public double getRightSpeed() {		
		return right1.getSelectedSensorVelocity(0);
	}	
	public double getLeftSpeed() {		
		return left1.getSelectedSensorVelocity(0);
	
	}
	


	public void stop() {
		left1.set(0);
		left1.set(0);
		left1.set(0);
		right1.set(0);
		right2.set(0);
		right3.set(0);

	}
    
}

	