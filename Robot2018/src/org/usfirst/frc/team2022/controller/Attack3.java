package org.usfirst.frc.team2022.controller;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Attack3 extends Joystick{
	
	//Buttons
	private static final int TRIGGER = 1;
	private static final int BUTTON_2 = 2;
	private static final int BUTTON_3 = 3;
	private static final int BUTTON_4 = 4;
	private static final int BUTTON_5 = 5;
	private static final int START_BUTTON = 8;
	private static final int STOP_BUTTON = 9;
	
	/**
	 * Construct an instance of a Logitech Attack3 joystick (The kind in the
	 * KoP).
	 *Initialize Button6 and Button 7 for controlling the pickup relays
	 * @param port The port on the driver station that the joystick is plugged
	 * into.
	 * @return
	 */
	public Attack3(int port) {
		super(port);
	} 
	
	public double getXAxis(){
		return getX();
//		return getAxis(Joystick.AxisType.kX);
	}
	
	public double getYAxis(){
		return getY();
//		return getAxis(Joystick.AxisType.kY);
	}
	/**
	 * Return the value of the Twist axis for this joystick This value is always
	 * 0 since there is no twist axis.
	 * @return 0 since there is no twist axis
	 */
	public double getTwist() {
		return 0;
	} 
	/**
	 * Get a JoystickButton for the Command Subsystem OI Class
	 *
	 * @param button The button as an integer
	 * @return JoystickButton
	 */
	public JoystickButton getJoystickButton(int button) {
		return (new JoystickButton(this, button));
	}
	
	public boolean getButton(int button) {
		return (new JoystickButton(this, button)).get();
	}
	
	public boolean getTriggerValue() {
		return (getRawButton(1));
	}
	
	public boolean get2Value() {
		return (getRawButton(2));
	}
	
	public boolean get3Value() {
		return (getRawButton(3));
	}
	
	public boolean get4Value() {
		return (getRawButton(4));
	}
	
	public boolean get5Value() {
		return (getRawButton(5));
	}
	
	public boolean getStartValue() {
		return (getRawButton(8));
	}
	
	public boolean getStopValue() {
		return (getRawButton(9));
	}
	
	/**
	 * Get the raw axes of the controller, to be used by other functions.
	 *
	 * The axis on the controller follow this mapping 1: Left Stick X Axis
	 * -Left:Negative ; Right: Positive 2: Left Stick Y Axis -Up: Negative ;
	 * Down: Positive 3: Triggers -Left: Positive ; Right: Negative 4: Right
	 * Stick X Axis -Left: Negative ; Right: Positive 5: Right Stick Y Axis -Up:
	 * Negative ; Down: Positive 6: Directional Pad (Not recommended, buggy)
	 *
	 * @param axis The axis to get the value of. Range 1-6.
	 * @return The value of the axis from -1 to 1.
	 */
	public float getRawAxis(int axis) {
		return (float) (super.getRawAxis(axis));
	}
	
	////////////////Get Raw Button Methods to be used by Command/Subsystem Interface
	/**
	 * Get Trigger Button
	 *
	 * @param
	 * @return X Button
	 */
	public JoystickButton getAttackTrigger() {
		return (new JoystickButton(this, TRIGGER));
	}
	
	/**
	 * Get 2 Button
	 *
	 * @param
	 * @return
	 * @return 2 Button
	 */
	public JoystickButton getButton2() {
		return (new JoystickButton(this, BUTTON_2));
	}

	/**
	 * Get 3 Button
	 *
	 * @param
	 * @return
	 * @return 3 Button
	 */
	public JoystickButton getButton3() {
		return (new JoystickButton(this, BUTTON_3));
	}

	/**
	 * Get 4 Button
	 *
	 * @param
	 * @return
	 * @return 4 Button
	 */
	public JoystickButton getButton4() {
		return (new JoystickButton(this, BUTTON_4));
	}
	
	/**
	 * Get 5 Button
	 *
	 * @param
	 * @return
	 * @return 5 Button
	 */
	public JoystickButton getButton5() {
		return (new JoystickButton(this, BUTTON_5));
	}

	/**
	 * Get Start Button
	 *
	 * @param
	 * @return Start Button
	 */
	public JoystickButton getStartButton() {
		return (new JoystickButton(this, START_BUTTON));
	}
	
	/**
	 * Get Stop Button
	 *
	 * @param
	 * @return Start Button
	 */
	public JoystickButton getStopButton() {
		return (new JoystickButton(this, STOP_BUTTON));
	}

	
	////////////////End Raw Button Methods for Command/Subsystem Interface
	/**
	* Get the buttons of the controller, to be used by other functions.
	*
	* The buttons on the controller follow this mapping 1: Trigger 2: 2 3: 3 4: 4 5:
	* 5 6: 6 7: 7 8: Start 9: Stop
	* Joystick
	*
	* @param button The button to get the value of. Range 1-9.
	* @return The state of the button.
	*/
	public boolean getRawButton(int button) {
	return (super.getRawButton(button));
	}
}
