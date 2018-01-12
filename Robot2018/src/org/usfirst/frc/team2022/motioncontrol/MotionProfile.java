package org.usfirst.frc.team2022.motioncontrol;

import java.util.ArrayList;

import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MotionProfile {
	// feet * conversionFactor = rotations
	static final float conversionFactor = 60;
	
	double maxV;
	TalonSRX motor;
	
	public MotionProfile(TalonSRX motor, double maxV) {
		this.maxV = maxV * conversionFactor;
		this.motor = motor;
	}
	
	public double position(double distance, double time) {
		return rotPos(distance * conversionFactor, time);
	}
	
	public double velocity(double distance, double time) {
		return rotVel(distance * conversionFactor, time);
	}
	
	// position function, all args in rotations
	private double rotPos(double distance, double time) {
		return (1024 * time*time*time * maxV*maxV*maxV * (64 * time*time * maxV*maxV
				                                        - 300 * distance * time * maxV
				                                        + 375 * distance*distance))/
				(253125 * distance*distance*distance*distance);
	}
	
	// velocity function, all args in rotations
	private double rotVel(double distance, double time) {
		return (5120 * time*time * maxV*maxV*maxV * (64 * time*time * maxV*maxV
				                             - 240*distance*time*maxV
				                             + 225 * distance*distance))/
				(253125 * distance*distance*distance*distance);
	}
}
