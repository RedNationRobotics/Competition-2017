package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;
	public CANTalon tsrxS = new CANTalon(4);

	double motorOutput = tsrxS.getOutputVoltage() / tsrxS.getBusVoltage();

	public Shooter() {

		tsrxS.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		tsrxS.reverseSensor(true);
		tsrxS.changeControlMode(TalonControlMode.Speed);
		tsrxS.configNominalOutputVoltage(+0.0f, -0.0f);
		tsrxS.configPeakOutputVoltage(+12.0f, -0.0f);
		tsrxS.setEncPosition(0);
		/* set closed loop gains in slot0 */
		tsrxS.setProfile(0);
		tsrxS.setF(.0317);
		tsrxS.setP(0);
		tsrxS.setI(0);
		tsrxS.setD(0);
	}

	public void shoot() {
		tsrxS.set(RobotMap.SHOOTER_SPEED);
	}

	public void stop() {
		tsrxS.set(0);
	}

	protected void initDefaultCommand() {

	}

}
