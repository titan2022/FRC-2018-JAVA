package org.usfirst.frc.team2022.robot.subsystems;

import org.usfirst.frc.team2022.robot.commands.GrabberCommand;
import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
/**
*
*/
public class GrabberSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static final NeutralMode NeutralMode = null;
	
	private WPI_TalonSRX left1,left2,right1,right2;
	
	private DigitalInput limitSwitch, gearSwitch;
	private DoubleSolenoid solenoid;
	
	private boolean isShooting;
	
//	private boolean switchUrMom = false;

	/**
	 * 
	 */
	public GrabberSubsystem() {
		//Instantiate motors		
		left1 = new WPI_TalonSRX(RobotMap.SHOOTER_MOTOR_PORT1);
		left2 = new WPI_TalonSRX(RobotMap.SHOOTER_MOTOR_PORT2);
		right1 = new WPI_TalonSRX(RobotMap.SHOOTER_MOTOR_PORT3);		
		right2 = new WPI_TalonSRX(RobotMap.SHOOTER_MOTOR_PORT4);		
		
		right1.setInverted(true); //Setup
		right2.setInverted(true);
		isShooting = false;		  //Receiving at start
		
		solenoid = new DoubleSolenoid(1,2);				//change ports
		solenoid.set(DoubleSolenoid.Value.kOff);
		//solenoid.set(DoubleSolenoid.Value.kForward);
		//solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GrabberCommand());
    }
    
    public boolean getLimitSwitch(){
    	return limitSwitch.get();
    }

    //Determines if it is shooting
    public void invertWheels() {
    	right1.setInverted(true);
    	right2.setInverted(true);
   		left1.setInverted(true);
   		left2.setInverted(true);
		if (isShooting) {
			isShooting = false;
		}
		else {
			isShooting = true;
		}
    }
    
    public void shootCube() {
    	if (!isShooting) {
    		invertWheels();
    	}
    }
    
    public void takeCube() {
    	if (isShooting) {
    		invertWheels();
    	}
    }
    
	// Setter methods for each side.
	public void setLeftSpeed(double speed) {
//		if(switchUrMom == false) {
			left1.set(speed);
			left2.set(speed);
//		} else {
//			right1.set(-speed);
//			right2.set(-speed);
//		}		
	}	
	public void setRightSpeed (double speed) {
//		if(switchUrMom) {
			right1.set(speed);
			right2.set(speed);		
//		} else {
//			left1.set(-speed);
//			left2.set(-speed);
//		}
	}
	
//	public void switchTheSwitchySwitch () {
//		switchUrMom = !switchUrMom;
//	}
	
	// Getter method for each side.
	public double getLeftSpeed() {		
		return left1.getSelectedSensorVelocity(0);
	}	
	public double getRightSpeed() {		
		return right1.getSelectedSensorVelocity(0);		
	}
	
	public void solinoidForward(){
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void enableStop(){
		left1.setNeutralMode(NeutralMode.Brake);
		left2.setNeutralMode(NeutralMode.Brake);
		right1.setNeutralMode(NeutralMode.Brake);
		right2.setNeutralMode(NeutralMode.Brake);		
	}
	public void disableStop(){
		left1.setNeutralMode(NeutralMode.Coast);
		left2.setNeutralMode(NeutralMode.Coast);
		right1.setNeutralMode(NeutralMode.Coast);
		right2.setNeutralMode(NeutralMode.Coast);
	}
	
	public void stop() {
		left1.set(0);
		left2.set(0);
		right1.set(0);
		right2.set(0);
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
}
