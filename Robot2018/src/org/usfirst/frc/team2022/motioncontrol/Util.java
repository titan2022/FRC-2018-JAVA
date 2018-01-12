package org.usfirst.frc.team2022.motioncontrol;

import java.util.ArrayList;

public class Util {
	// feet * conversionFactor = rotations
	static final float conversionFactor = 60;
	
	public static float[][] generateProfile(double maxV, double distance) {
		// TODO: handle cases where 128 points aren't enough
		//       allow for modified interval between points
		//       fix time
		
		ArrayList<float[]> ls = new ArrayList<>();
		int time = 1280; // time in ms
		for (int t = 0; t <= time; t += 10) {
			float[] tmp = {(float) position(maxV,distance,t/1000),
				           (float) velocity(maxV,distance,t/1000),
				           (float) 10};
			ls.add(tmp);
		}
		return (float[][]) ls.toArray();
	}
	
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
