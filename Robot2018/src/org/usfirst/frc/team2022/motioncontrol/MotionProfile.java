package org.usfirst.frc.team2022.motioncontrol;

import java.util.ArrayList;

import com.ctre.phoenix.motion.TrajectoryPoint;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class MotionProfile {
	// feet * conversionFactor = rotations
	static final float conversionFactor = 60;
	
	double maxV;
	TalonSRX[] motors;
	
	public MotionProfile(TalonSRX[] motors, double maxV) {
		this.maxV = maxV * conversionFactor;
		this.motors = motors;
	}
	
	public void runProfile(double distance) {
		// TODO: error handling
		for (TrajectoryPoint tp : generateProfile(distance)) {
			for (TalonSRX motor : motors) {
				motor.pushMotionProfileTrajectory(tp);
			}
		}
		
		for (TalonSRX motor : motors) {
			motor.processMotionProfileBuffer();
		}
	}
	
	public TrajectoryPoint[] generateProfile(double distance) {
		// TODO: handle cases where 128 points aren't enough
		//       allow for modified interval between points
		//       is the interval between trajectorypoints even 10ms????
		ArrayList<TrajectoryPoint> ls = new ArrayList<>();
		int time = (int) ((15 * distance * conversionFactor)/(8 * maxV)); // time in ms
		for (int t = 0; t <= time; t += 10) {
			TrajectoryPoint tp = new TrajectoryPoint();
			tp.position = position(distance, t/1000);
			tp.velocity = velocity(distance, t/1000);
			ls.add(tp);
		}
		ls.get(0).zeroPos = true;
		ls.get(ls.size() - 1).isLastPoint = true;
		return (TrajectoryPoint[]) ls.toArray();
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
