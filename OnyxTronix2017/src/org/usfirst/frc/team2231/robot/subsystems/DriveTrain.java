// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team2231.robot.subsystems;

import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    private final CANTalon firstLeft = RobotMap.driveTrainFirstLeft;
    private final CANTalon secondLeft = RobotMap.driveTrainSecondLeft;
    private final CANTalon firstRight = RobotMap.driveTrainFirstRight;
    private final CANTalon secondRight = RobotMap.driveTrainSecondRight;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final DoubleSolenoid shifterRight = RobotMap.driveTrainShifterRight;
    public static final double angleToFloor = 31;
    public static final double cameraHeight = 40;//The height  is by meter
    public static final double targetHeight = 70;//the height is by meter
    public static final double verticalApertureAngle = 35;
    public static final double PID_P = 5;
    public static final double PID_I = 0;
    public static final double PID_D = 0;
    public static final double PID_F = 0;
    public static final double PID_TOLERNCE = 20;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new DriveByJoystick());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void arcadeDrive(Joystick stick){
    	robotDrive.arcadeDrive(-stick.getRawAxis(1), stick.getRawAxis(4));
    }
    public void closeShifter() {
    	RobotMap.driveTrainShifterRight.set(Value.kReverse);
    }
    public void openShifter() {
    	RobotMap.driveTrainShifterRight.set(Value.kForward);
    }
}

