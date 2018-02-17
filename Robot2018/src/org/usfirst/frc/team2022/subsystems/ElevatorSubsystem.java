//package org.usfirst.frc.team2022.subsystems;
//
////import org.usfirst.frc.team2022.commands.ElevatorManualCommand;
//import org.usfirst.frc.team2022.robot.ConstantsMap;
//import org.usfirst.frc.team2022.robot.RobotMap;
//
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.command.Subsystem;
//
//public class ElevatorSubsystem extends Subsystem {
//	public int extensionLimit;
//	
//	private static final NeutralMode NeutralMode = null;
//	
//	private WPI_TalonSRX elevatorMotor;
//	
//	private Encoder encoder;
//	
//	private boolean front;
//	
//	public ElevatorSubsystem(boolean useFront, int extensionLimit) {
//		front = useFront;
//		this.extensionLimit = extensionLimit;
//		
//		if (front) {
//			elevatorMotor = new WPI_TalonSRX(RobotMap.FRONT_ELEVATOR_PORT);
//			encoder = new Encoder(RobotMap.FRONT_ENCODER_PORT_A, RobotMap.FRONT_ENCODER_PORT_B, false);
//		} else {
//			elevatorMotor = new WPI_TalonSRX(RobotMap.FRONT_ELEVATOR_PORT);
//			encoder = new Encoder(RobotMap.BACK_ENCODER_PORT_A, RobotMap.BACK_ENCODER_PORT_B, false);
//		}
//		
//		elevatorMotor.setInverted(true);
//		
//		//Set encoder distance per pulse
//		encoder.setDistancePerPulse(ConstantsMap.DRIVE_ENCODER_DIST_PER_TICK);
//	}
//	
//	public void initDefaultCommand() {
//    	setDefaultCommand(new ElevatorManualCommand(front));
//    }
//	
//	public void setElevatorSpeed(double speed) {
//		elevatorMotor.set(speed);
//	}
//	
//	public void stopElevator(){
//		elevatorMotor.set(0);
//	}
//	
//	public void enableStop(){
//		elevatorMotor.setNeutralMode(NeutralMode.Brake);
//	}
//	public void disableStop(){
//		elevatorMotor.setNeutralMode(NeutralMode.Coast);
//	}
//	
//	//Get Encoders
//	public Encoder getEncoder(){
//		return encoder;
//	}
//	
//	//Get Encoder Distances
//	public double getEncoderDistance(){
//		return encoder.getDistance();
//	}	
//	
//	
//	//Get Encoder counts
//	public int getEncoderCount(){
//		return encoder.get();
//	}
//	
//	//Get Encoder Rates
//	public double getEncoderRate(){
//		return encoder.getRate();
//	}
//	
//	//reset encoders
//	public void resetEncoders(){
//		encoder.reset();
//	}
//	
//	public void stop() {
//		stopElevator();
//	}
//	
//}
