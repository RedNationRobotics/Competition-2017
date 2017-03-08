package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem {

	public Agitator() {
	}

	CANTalon tsrxA = new CANTalon(RobotMap.AGITATOR_TALON);

	protected void initDefaultCommand() {

	}

	public void agitatorGo() {
		tsrxA.set(1);
	}


	public void agitatorStop() {
		tsrxA.set(0);

	}

}