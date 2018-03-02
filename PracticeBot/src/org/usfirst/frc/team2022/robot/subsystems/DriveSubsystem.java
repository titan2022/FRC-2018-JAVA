/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2022.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2022.robot.ConstantsMap;
import org.usfirst.frc.team2022.robot.RobotMap;
import org.usfirst.frc.team2022.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogGyro;
//import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */

public class DriveSubsystem extends Subsystem {
	private static final NeutralMode NeutralMode = null;
	
	Talon left1,left2,left3,right1,right2, right3;
	private Encoder leftEncoder, rightEncoder;

	private AHRS ahrs;

	public DriveSubsystem() {
		//Instantiate motors		
		left1 = new Talon(RobotMap.LEFT_DRIVE_PORT_1);
		left2 = new Talon(RobotMap.LEFT_DRIVE_PORT_2);
		left3 = new Talon(RobotMap.LEFT_DRIVE_PORT_3);
		right1 = new Talon(RobotMap.RIGHT_DRIVE_PORT_1);		
		right2 = new Talon(RobotMap.RIGHT_DRIVE_PORT_2);
		right3 = new Talon(RobotMap.RIGHT_DRIVE_PORT_3);
		
		//Invert Motors
		//left1.setInverted(true);
		//left2.setInverted(true);
		//left3.setInverted(true);
		right1.setInverted(true);
		right2.setInverted(true);
		right3.setInverted(true);

		//Instantiate Encoders
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_PORT_A, RobotMap.LEFT_ENCODER_PORT_B, false);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_PORT_A, RobotMap.RIGHT_ENCODER_PORT_B, false);
		
		
		
		try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }

		//		//Set encoder distance per pulse
		leftEncoder.setDistancePerPulse(ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK);
		rightEncoder.setDistancePerPulse(ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK);
		resetEncoders();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
    	setDefaultCommand(new DriveCommand());
    }
   
	public void setLeftSpeed(double speed) {
			left1.set(speed);
			left2.set(speed);
			left3.set(speed);
	}	
	
	public void setRightSpeed (double speed) {
			right1.set(speed);
			right2.set(speed);		
			right3.set(speed);
	}
	
	public double getLeftSpeed() {		
		return left1.getSpeed();
	}	
	
	public double getRightSpeed() {		
		return right1.getSpeed();	
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed){
		setLeftSpeed(leftSpeed);
		setRightSpeed(rightSpeed);
	}
	
	public void enableBrake(){
//		left1.setNeutralMode(NeutralMode.Brake);
//		left2.setNeutralMode(NeutralMode.Brake);
//		left3.setNeutralMode(NeutralMode.Brake);
//		right1.setNeutralMode(NeutralMode.Brake);
//		right2.setNeutralMode(NeutralMode.Brake);
//		right3.setNeutralMode(NeutralMode.Brake);
		
	}
	
	public void disableBrake(){
//		left1.setNeutralMode(NeutralMode.Coast);
//		left2.setNeutralMode(NeutralMode.Coast);
//		left3.setNeutralMode(NeutralMode.Coast);
//		right1.setNeutralMode(NeutralMode.Coast);
//		right2.setNeutralMode(NeutralMode.Coast);
//		right3.setNeutralMode(NeutralMode.Coast);
	}
	 
	public Encoder getRightEncoder(){
		return rightEncoder;
	}
	
	public Encoder getLeftEncoder(){
		return leftEncoder;
	}
	
	//Get Encoder Distances
	public double getRightEncoderDistance(){
		return rightEncoder.getDistance();
	}	
	public double getLeftEncoderDistance(){
		return leftEncoder.getDistance();
	}
	
	//Get Encoder counts
	public int getLeftEncoderCount(){
		return leftEncoder.get();
	}	
	public int getRightEncoderCount(){
		return rightEncoder.get();
	}
	
	//Get Encoder Rates
	public double getRightEncoderRate(){
		return rightEncoder.getRate();
	}	
	public double getLeftEncoderRate(){
		return leftEncoder.getRate();
	}
	
	//reset encoders
	public void resetEncoders(){
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public AHRS getGyro(){
		return ahrs;
	}
	
	public double getGyroAngle(){
		return ahrs.getAngle(); 
	}

	public void resetGyro() {
		ahrs.reset();;
	}

	public void stop() {
		left1.set(0);
		left2.set(0);
		left3.set(0);
		right1.set(0);
		right2.set(0);
		right3.set(0);
	}
    
}