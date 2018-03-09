package org.usfirst.frc.team2022.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDelayCommand extends Command{
	private long time;
	boolean finish = false;
	public AutoDelayCommand(long time) {
		time = this.time;
	}
	
	protected void initialize() {
		Timer.delay(time);
		finish = true;
	}
	@Override
	protected boolean isFinished() {
		
		return finish;
	}

}
