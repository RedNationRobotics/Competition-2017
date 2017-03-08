package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbReverse extends Command {
	private boolean in = true;

	public ClimbReverse(boolean in) {
		this.in = in;
		requires(Robot.climber);
	}

	protected void initialize() {
		if (in) {
			Robot.climber.reverse();
		} else {
			Robot.climber.stop();
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
