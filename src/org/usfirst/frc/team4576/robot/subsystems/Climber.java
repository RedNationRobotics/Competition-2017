package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	public Climber() {
	}

	CANTalon tsrxC = new CANTalon(RobotMap.CLIMBER_TALON);

	protected void initDefaultCommand() {

	}

	public void climb() {
		tsrxC.set(.75); 

	}

	public void reverse() {
		tsrxC.set(-.13);
	}

	public void stop() {
		tsrxC.set(0);

	}

}
