package org.usfirst.frc.team2022.robot;

public class CustomPIDController {
	// TODO: documentation, numerical integration, actually make controller work
	
	// amount error is "damped" by the lpf
	// higher = more damping
	public static final int lowPassConstant = 10;
	
	// proportional, integral, derivative, and constant terms respectively
	private double kp, ki, kd, kf;
	
	// error values. `err` is used to compute `modErr`, which is used in the main control loop
	private double err;
	private double modErr;
	private double lastModErr = 0;
	private double lastLocation = 0;
	
	// approximate integral of error
	private double iErr = 0;
	
	// minimum and maximum output
	private double min;
	private double max;
	
	private double setpoint;
	
	public CustomPIDController(double kp, double ki, double kd, double kf, double min, double max) {
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
		this.kf = kf;
		this.min = min;
		this.max = max;
	}
	
	public double update(double location) {
		err = setpoint - location;
		lowPassErr();
		
		double rawOutput = ki * iErr + kp * modErr + kd * (modErr - lastModErr);
		double output = rawOutput > max ? max : (rawOutput < min ? min : rawOutput);
		
		return output;
	}
	
	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
		err = setpoint - lastLocation;
	}
	
	private void lowPassErr() {
		modErr = (CustomPIDController.lowPassConstant * lastModErr + err)/(CustomPIDController.lowPassConstant + 1);
	}
	
	//calculates the integral for the PID system with the x axis being the encoder click interval and the y axis being the error/distance
	private void integral(double encoderClickInterval) {
		iErr = (modErr + lastModErr) * encoderClickInterval / 2;
	}
	
	
	
}