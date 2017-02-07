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

import onyxNiVision.OnyxTronixPIDController;

import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;

import vision.PIDVisionSourceType;
import vision.VisionSensor;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    public static final double PID_P = 0.5;
    public static final double PID_I = 0;
    public static final double PID_D = 0;
    public static final double PID_F = 0;
    public static final double PID_TOLERANCE = 10;
    public static final double ANGLE_TO_FLOOR = 10;
    public static final double CAMERA_HIEGHT = 20;//meters
    public static final double TARGET_HEIGHT = 60;//meters
    public static final double VERTICAL_APERTURE_ANGLE = 20;
    
    private final DoubleSolenoid shifter = RobotMap.driveTrainShifter;
    private final CANTalon firstLeft = RobotMap.driveTrainFirstLeft;
    private final CANTalon secondLeft = RobotMap.driveTrainSecondLeft;
    private final CANTalon firstRight = RobotMap.driveTrainFirstRight;
    private final CANTalon secondRight = RobotMap.driveTrainSecondRight;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final OnyxTronixPIDController visionRotationPIDController = RobotMap.visionRotationPIDController;
    private final VisionSensor visionSensor = RobotMap.visionSensor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new DriveByJoystick());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void arcadeDrive(Joystick stick){
    	robotDrive.arcadeDrive(stick.getY(Hand.kLeft), stick.getX(Hand.kRight));
    }
    public void closeShifter() {
    	shifter.set(Value.kReverse);
    }
    public void openShifter() {
    	shifter.set(Value.kForward);
    }
    
    public boolean  isOnTarget() {
    	return visionRotationPIDController.onTarget() ;
    }
    
    public void stopPID() {
	    visionRotationPIDController.stop();
    }
    
    public void setRotationSlaveTalons() {
    	secondLeft.changeControlMode(TalonControlMode.Follower);
    	secondRight.changeControlMode(TalonControlMode.Follower);
    	secondLeft.set(firstLeft.getDeviceID());
    	secondRight.set(firstRight.getDeviceID());
    }
    
    public void setDriveSlaveTalons() {
    	secondLeft.changeControlMode(TalonControlMode.Follower);
    	secondRight.changeControlMode(TalonControlMode.Follower);
    	firstLeft.changeControlMode(TalonControlMode.Follower);
    	secondLeft.set(firstRight.getDeviceID());
    	secondRight.set(firstRight.getDeviceID());
    	firstLeft.set(firstRight.getDeviceID());
    	
    }
    
    public void resetSlaveTalons() {
    	firstRight.changeControlMode(TalonControlMode.PercentVbus);
    	firstLeft.changeControlMode(TalonControlMode.PercentVbus);
    	secondLeft.changeControlMode(TalonControlMode.PercentVbus);
    	secondRight.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void initPID(double setPoint, PIDVisionSourceType pidVisionSourceType) {
    	visionSensor.setPidVisionSourceType(pidVisionSourceType);
    	visionRotationPIDController.init(setPoint, PID_TOLERANCE);
    }
}

