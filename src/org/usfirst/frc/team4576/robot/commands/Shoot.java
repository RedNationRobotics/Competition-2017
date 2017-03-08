package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Shoot extends Command {
	private boolean in = true;

	public Shoot(boolean in) {
		this.in = in;
		requires(Robot.shooter);
	}

	protected void initialize() {
		if (in) {
			Robot.shooter.shoot();
		} else {
			Robot.shooter.stop();
		}
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		// changed to true to check issues
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {

	}

}
