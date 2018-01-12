package org.usfirst.frc.team2022.motioncontrol;

public class Util {
	// feet * conversionFactor = rotations
	static final float conversionFactor = 60;
	
	
	public static double position(double maxV, double distance, double time) {
		return rotPos(maxV * conversionFactor, distance * conversionFactor, time);
	}
	
	public static double velocity(double maxV, double distance, double time) {
		return rotVel(maxV * conversionFactor, distance * conversionFactor, time);
	}
	
	// position function, all args in rotations
	private static double rotPos(double maxV, double distance, double time) {
		return (1024 * time*time*time * maxV*maxV*maxV * (64 * time*time * maxV*maxV
				                                        - 300 * distance * time * maxV
				                                        + 375 * distance*distance))/
				(253125 * distance*distance*distance*distance);
	}
	
	// velocity function, all args in rotations
	private static double rotVel(double maxV, double distance, double time) {
		return (5120 * time*time * maxV*maxV*maxV * (64 * time*time * maxV*maxV
				                             - 240*distance*time*maxV
				                             + 225 * distance*distance))/
				(253125 * distance*distance*distance*distance);
	}
}
