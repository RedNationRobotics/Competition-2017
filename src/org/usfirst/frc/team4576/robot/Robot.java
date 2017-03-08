
package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.AutoCrossBaseline;
import org.usfirst.frc.team4576.robot.commands.AutoMiddleGear;
import org.usfirst.frc.team4576.robot.commands.AutoMiddleGearLBaseline;
import org.usfirst.frc.team4576.robot.commands.AutoMiddleGearRBaseline;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Agitator;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Climber;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4576.robot.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static final Agitator agitator = new Agitator();// huhu
	public static final Chassis chassis = new Chassis();
	public static final Climber climber = new Climber();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Shooter shooter = new Shooter();
	public static OI oi;

	public static Joystick driveStick = new Joystick(0);
	public static Joystick secondaryStick = new Joystick(1);
	
	UsbCamera camera = new UsbCamera("cam0", 0);

	Command teleopCommand;
	Command autonomousCommand;
	
	final String defaultAuto = "Default: Cross Base Line";
	final String timedMiddleGear = "Timed Middle Gear, No Baseline";
	final String timedMiddleGearLBaseline = "Timed Middle Gear, Cross Baseline Left"; 
	final String timedMiddleGearRBaseline = "Timed Middle Gear, Cross Baseline Right" ;
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	public void robotInit() {
		chooser = new SendableChooser<>();
		chooser.addDefault("Default Auto: Cross Baseline", defaultAuto);
		chooser.addObject("Middle Gear Auto, No Baseline", timedMiddleGear);
		chooser.addObject("Middle Gear Auto, Cross Baseline Left", timedMiddleGearLBaseline);
		chooser.addObject("Middle Gear Auto, Cross Baseline Right", timedMiddleGearRBaseline);
		SmartDashboard.putData("Auto Choices", chooser);
		System.out.println("RNR 2017 Robot Code Initializing...");
		oi = new OI();

		teleopCommand = new DriveWithJoysticks();
		autonomousCommand = new AutoCrossBaseline();
		autonomousCommand = new AutoMiddleGear();
		autonomousCommand = new AutoMiddleGearLBaseline();
		autonomousCommand = new AutoMiddleGearRBaseline();
		
		camera.setFPS(15);
		camera.setResolution(320, 240);
		CameraServer.getInstance().startAutomaticCapture(camera);
		

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		
		switch (chooser.getSelected()) {
		
		case "timedMiddleGear":
			autonomousCommand = new AutoMiddleGear();
			break;
		case "timedMiddleGearLBaseline":
			autonomousCommand = new AutoMiddleGearLBaseline();
			break;
		case "timedMiddleGearRBaseline":
			autonomousCommand = new AutoMiddleGearRBaseline();
			break;
		default:
			autonomousCommand = new AutoCrossBaseline();
			break;
		}

		if (autonomousCommand != null)

		chassis.initAuto();
		autonomousCommand.start();

	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		teleopCommand.start();

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
