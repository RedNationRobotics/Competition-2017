package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

	public Pneumatics() {
		s0 = new Solenoid(RobotMap.SHIFT_SOLENOID);/* Shifting */
		s1 = new Solenoid(RobotMap.GEAR_SOLENOID);/* Gear */
		s2 = new Solenoid(RobotMap.BALL_SOLENOID1);/* Ball Adcancing */
		s3 = new Solenoid(RobotMap.BALL_SOLENOID2);/* Ball Advancing */

	}

	private Compressor c;
	private Solenoid s0, s1, s2, s3;

	protected void initDefaultCommand() {
		c = new Compressor();
	}

	public void setAutoEnabled() {

		c.setClosedLoopControl(true);
	}

	// Shifting
	public void setShift(boolean closed) {
		s0.set(closed);
	}

	public void shiftUp() {
		s0.set(true);

	}

	public void shiftDown() {
		s0.set(false);
	}

	// Ball Advancing
	public void Fire(boolean closed) {
		s2.set(closed);
		s3.set(!closed);
	}

	public void toggleFire() {

		boolean b = !s2.get();
		s2.set(b);
		s3.set(!b);

	}

	// Gear Grabbing
	public void setGear(boolean closed) {
		s1.set(closed);
	}

	public void gear() {
		s1.set(!s1.get());

	}
	public void gearUp() {
		s1.set(true);
	}

	public void gearDown() {
		s1.set(false);
	}

	// Compressor Toggle
/*	public void toggleComp() {
		if (c.enabled())
			c.stop();
		else
			c.start();
	}
*/
	public void startComp() {
		c.start();
	}
	public void stopComp() {
		c.stop();
	}

}
