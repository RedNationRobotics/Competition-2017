package org.usfirst.frc.team4576.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Talon IDs:
	public static int LEFT_MASTER = 0;
	public static int RIGHT_MASTER = 1;
	public static int LEFT_SLAVE = 2;
	public static int RIGHT_SLAVE = 3;
	public static int CLIMBER_TALON = 4;
	public static int SHOOTER_TALON = 5;
	public static int AGITATOR_TALON = 6;

	// Solenoid IDs:
	public static int SHIFT_SOLENOID = 0;
	public static int GEAR_SOLENOID = 1;
	public static int BALL_SOLENOID1 = 2;
	public static int BALL_SOLENOID2 = 3;

	// Random Values
	public static int SHOOTER_SPEED = 4000;

}
