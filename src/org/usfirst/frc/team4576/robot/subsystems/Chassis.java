package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {

	double rpm = 0;

	public Chassis() {
		tsrxL2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxL2.set(tsrxL.getDeviceID());
		tsrxR2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxR2.set(tsrxR.getDeviceID());
	}

	boolean manualOverride = false;

	public CANTalon tsrxL = new CANTalon(RobotMap.LEFT_MASTER);
	public CANTalon tsrxR = new CANTalon(RobotMap.RIGHT_MASTER);
	public CANTalon tsrxL2 = new CANTalon(RobotMap.LEFT_SLAVE);
	public CANTalon tsrxR2 = new CANTalon(RobotMap.RIGHT_SLAVE);

	// This defines the talons used to drive.
	RobotDrive drive = new RobotDrive(tsrxL, tsrxR);
	// These lines declare the axes for turning
	public static final int FORWARD_AXIS = 1;
	public static final int TURN_AXIS = 4;

	PowerDistributionPanel pdp = new PowerDistributionPanel();

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}

	// This defines whether a talon is on the right or left.
	public void setLeftRight(double left, double right) {
		tsrxL.set(left);
		tsrxR.set(right);

	}

	public void disable() {
		tsrxR.disable();
		tsrxL.disable();

	}

	public void initAuto() {
		drive.setSafetyEnabled(false);
	}

	public void initTeleop() {
		drive.setSafetyEnabled(false);
	}

	// This declares that for driving only the assigned axes are used.
	public void normalDrive() {
		rpm = Robot.shooter.tsrxS.getSpeed();

		SmartDashboard.putNumber("RPM", rpm);
		drive.arcadeDrive(Robot.driveStick.getRawAxis(FORWARD_AXIS), Robot.driveStick.getRawAxis(TURN_AXIS));
	}
}
