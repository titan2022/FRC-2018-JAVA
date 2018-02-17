//package org.usfirst.frc.team2022.commands;
//import org.usfirst.frc.team2022.robot.ConstantsMap;
//import org.usfirst.frc.team2022.robot.OI;
//import org.usfirst.frc.team2022.robot.Robot;
//import org.usfirst.frc.team2022.robot.XboxMap;
//import org.usfirst.frc.team2022.subsystems.GrabberSubsystem;
//
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
//
//public class GrabberCommand extends Command{
//	GrabberSubsystem grabberSubsystem = Robot.grabberSubsystem;
//	XboxMap xboxMap = new XboxMap();
//	OI oi = Robot.oi;
//	
//	private double outterGrabberSpeed = ConstantsMap.OUTTER_GRABBER_SPEED;
//	private double innerGrabberSpeed = ConstantsMap.INNER_GRABBER_SPEED;
//	
//	private boolean outterSwitch = false;
//	private boolean innerSwitch = false;
//	private boolean pistonSwitch = false;
//	
//	private double lastPressed = 0;
//	
//    public GrabberCommand() {
//    	requires(grabberSubsystem);
//    }
//    
//    protected void initialize() {
//    }
//
//    protected void execute() {    	
//	
//    	if(xboxMap.controlOutterMotors() && System.currentTimeMillis() - lastPressed > 200){
//    		outterSwitch = !outterSwitch;
//    		lastPressed = System.currentTimeMillis();
//    	}
//    	if(xboxMap.controlInnerMotors() && System.currentTimeMillis() - lastPressed > 200){
//    		innerSwitch = !innerSwitch;
//    		lastPressed = System.currentTimeMillis();
//    	}
//    	if(xboxMap.controlPiston() && System.currentTimeMillis() - lastPressed > 200){
//    		pistonSwitch = !pistonSwitch;
//    		lastPressed = System.currentTimeMillis();
//    	}
//    	
//    	if(outterSwitch){
//    		grabberSubsystem.setOutterGrabberSpeed(outterGrabberSpeed);
//    	}
//    	if(innerSwitch){
//    		grabberSubsystem.setOutterGrabberSpeed(innerGrabberSpeed);
//    	}
//    	
////    	if(pistonSwitch){
////    		grabberSubsystem.solinoidForward();
////    	}
////    	else{
////    		grabberSubsystem.solinoidReverse();
////    	}
//    	
//    	SmartDashboard.putBoolean("Grabber Pistion Position: ", grabberSubsystem.getBoxSwitch());
//    	SmartDashboard.putBoolean("Box Grabbed: ", grabberSubsystem.getBoxSwitch());
//    }
// 
//    protected boolean isFinished() {
//        return false;
//    }
//
//    protected void end() {
//    	grabberSubsystem.stop();
//    }
//
//    protected void interrupted() {
//    	grabberSubsystem.stop();
//    }
//}
