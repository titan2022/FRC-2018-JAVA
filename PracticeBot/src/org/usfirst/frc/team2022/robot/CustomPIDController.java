package org.usfirst.frc.team2022.robot;

import edu.wpi.first.wpilibj.PIDInterface;

public class CustomPIDController implements PIDInterface{
	// TODO: documentation, numerical integration, actually make controller work
	
	// amount error is "damped" by the lpf
	// higher = more damping
	public static final double lowPassConstant = .5;
	
	// proportional, integral, derivative, and constant terms respectively
	private double kp, ki, kd, kf;
	
	// error values. `err` is used to compute `modErr`, which is used in the main control loop
	public double err;
	public double modErr;
	private double lastModErr = 1;
	private double lastLocation = 0;
	private double tolerance;
	private double accumulation = 0.0;
	
	// approximate integral of error
	public double iErr = 0;
	
	// minimum and maximum output
	private double min;
	private double max;
	
	private double setpoint;
	
	// dt fields
	private double lastTime;
	
	public CustomPIDController(double kp, double ki, double kd, double kf, double tolerance, double min, double max) {
		
		this.tolerance = tolerance;
		this.min = min;
		this.max = max;
		this.lastTime = System.nanoTime();
	}
	
	public double update(double location) {
		double currentTime = System.nanoTime();
		double dt = currentTime - lastTime;
		
		getErr(location,dt);
		lastTime = currentTime;
		iErr = (modErr + lastModErr) * dt / 2;
		
		lastLocation = location;
		
		double rawOutput = ki * iErr + kp * modErr + kd * (modErr - lastModErr)/dt;
		double output = rawOutput > max ? max : (rawOutput < min ? min : rawOutput);
		
		return output;
	}
	
	//Still need to fix this. It only works for error=100 and the constant = .5.
	public boolean isFinished() {
		return Math.abs(lastLocation - setpoint) <= this.tolerance;
	}
	
	private void getErr(double location, double dt) {
			err = setpoint - lastLocation;
			//modErr = (CustomPIDController.lowPassConstant * lastModErr + err)/(CustomPIDController.lowPassConstant + 1);
			modErr = lastModErr + CustomPIDController.lowPassConstant  * accumulation;
			accumulation += lastModErr;
	}

	@Override
	public void setPID(double p, double i, double d) {
		this.kp = p;
		this.ki = i;
		this.kd = d;
	}

	@Override
	public double getP() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getI() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getD() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSetpoint() {
		
		return 0;
	}

	@Override
	public double getError() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
		err = 0.0;
		lastTime = System.nanoTime();
		
	}
}