package org.usfirst.frc.team2022.subsystems;

import org.usfirst.frc.team2022.commands.GrabberCommand;
import org.usfirst.frc.team2022.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2022.robot.ConstantsMap;

public class GrabberSubsystem extends PIDSubsystem {
	
	private WPI_TalonSRX leftMotor, rightMotor, upMotor;
	
	private Counter counter;
	private DigitalInput boxSwitch,upSwitch;
	
	Solenoid armin, armout;
	
	
	public GrabberSubsystem() {
		super("GRABBER",ConstantsMap.KP_GRABBER,ConstantsMap.KI_GRABBER,ConstantsMap.KD_GRABBER);
		//Instantiate motors		
		leftMotor = new WPI_TalonSRX(RobotMap.INNERLEFT_GRABBER_PORT);
		rightMotor = new WPI_TalonSRX( RobotMap.INNERRIGHT_GRABBER_PORT);	
		upMotor = new WPI_TalonSRX(RobotMap.UPMOTOR_PORT);
		upMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		//upMotor.gets
		leftMotor.setInverted(true);
		rightMotor.setInverted(false);
		upMotor.setInverted(true);
		
		setInputRange(0, 90);
		setOutputRange(-ConstantsMap.GRABBER_MAX_SPEED, ConstantsMap.GRABBER_MAX_SPEED);
		setAbsoluteTolerance(ConstantsMap.ELEVATOR_ERR_TOLERANCE);
		
		boxSwitch = new DigitalInput(RobotMap.BOX_SWITCH);
		upSwitch = new DigitalInput(RobotMap.UP_SWITCH);
//		counter = new Counter(boxSwitch);
		enableBrake();
		
		armin = new Solenoid(0);
		armout = new Solenoid(1);
		SmartDashboard.putNumber("Grabbee Encoder",getEncoderTicks());
		SmartDashboard.putData("Box Limit", boxSwitch);
		SmartDashboard.putData("Up Limit", upSwitch);
		SmartDashboard.putData("Grabber PID",this.getPIDController());
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GrabberCommand());
    }
    public boolean isUpSet() {
		return upSwitch.get();
	}
    public boolean isBoxSet() {
		return boxSwitch.get();
	}
    public void initializeCounter() {
        counter.reset();
    }
    
    public void in() {
    	armin.set(true);
    	armout.set(false);
    }
    public void out() {
    	armin.set(false);
    	armout.set(true);
    	
    }
    
    public void actuate(double value) {
    	//if(upSwitch.get()) {
    		upMotor.set(0);
    	//}
    	//else {
    		upMotor.set(value);
    //	}
    	
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
    
	public void setMotorSpeed(double speed){
		leftMotor.set(speed);
		rightMotor.set(speed);
	}
	
	public double getEncoderAngle(){
	    	return upMotor.getSelectedSensorPosition(0)*-1* ConstantsMap.GRABBER_ENCODER_ANGLE_PER_TICK;
	    }
    public double getEncoderTicks(){
    	return upMotor.getSelectedSensorPosition(0);
    }
    
    
    public double getEncoderVelocity(){
    	return upMotor.getSelectedSensorVelocity(0);
    }
    
    public void resetEncoderPosition(){
    	upMotor.getSensorCollection().setQuadraturePosition(0, 0);
    }
    

	public void stopMotors(){
		setMotorSpeed(0);
	}
	
	public void stop(){
		stopMotors();
	}
	 
	 public void enableBrake(){
		leftMotor.setNeutralMode(NeutralMode.Brake);
		rightMotor.setNeutralMode(NeutralMode.Brake);
	 }
		
	 public void disableBrake(){
		leftMotor.setNeutralMode(NeutralMode.Coast);
		rightMotor.setNeutralMode(NeutralMode.Coast);
	 }

	 @Override
		protected double returnPIDInput() {
			// TODO Auto-generated method stub
			return getEncoderAngle();
		}

		@Override
		protected void usePIDOutput(double output) {
			upMotor.pidWrite(output);
			
		}
}
