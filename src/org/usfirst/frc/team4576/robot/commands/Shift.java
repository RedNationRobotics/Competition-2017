package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command {
	private boolean in = true;

	public Shift(boolean in) {
		this.in = in;
		requires(Robot.pneumatics);
	}

	protected void initialize() {
		if (in) {
			Robot.pneumatics.shiftUp();
		} else {
			Robot.pneumatics.shiftDown();
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
