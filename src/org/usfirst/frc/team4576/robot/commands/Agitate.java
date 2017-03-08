package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Agitate extends Command {
	private boolean in = true;

	public Agitate(boolean in) {
		this.in = in;
		requires(Robot.agitator);
	}

	protected void initialize() {
		if (in) {
			Robot.agitator.agitatorGo();
		} else {
			Robot.agitator.agitatorStop();
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
