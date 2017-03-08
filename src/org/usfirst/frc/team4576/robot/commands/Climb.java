package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {
	private boolean in = true;

	public Climb(boolean in) {
		this.in = in;
		requires(Robot.climber);
	}

	protected void initialize() {
		if (in) {
			Robot.climber.climb();
		} else {
			Robot.climber.stop();
		}
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {

	}

}
