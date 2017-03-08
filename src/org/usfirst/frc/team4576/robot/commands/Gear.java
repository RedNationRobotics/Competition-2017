package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Gear extends Command {
	public Gear(){
		
		requires(Robot.pneumatics);
        
	}

	protected void initialize() {
		Robot.pneumatics.gear();
		
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
