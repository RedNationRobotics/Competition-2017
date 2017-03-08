package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoMiddleGear extends Command {

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		//-,- to turn right, +,+ to turn left
		
		//Forward
				Robot.chassis.setLeftRight(-1, 1);
				Timer.delay(2);
				//Open Gear
				Robot.pneumatics.gearUp();
				//Stop
				Robot.chassis.setLeftRight(0, 0);
				Timer.delay(1);
				//Reverse
				Robot.chassis.setLeftRight(1,-1);
				Timer.delay(1.5);
				
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);
		

	}

	@Override
	protected void interrupted() {

	}

}