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
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import onyxNiVision.OnyxTronixPIDController;


/**
 *
 */
public class DriveTrain extends Subsystem {
	public static final double ROTATION_PID_P = 0.5;
	public static final double ROTATION_PID_I = 0;
	public static final double ROTATION_PID_D = 0;
	public static final double ROTATION_PID_F = 0;
	public static final double ROTATION_ABSOLUTE_TOLERANCE = 5;
	
    private final CANTalon firstLeft = RobotMap.driveTrainFirstLeft;
    private final CANTalon secondLeft = RobotMap.driveTrainSecondLeft;
    private final CANTalon firstRight = RobotMap.driveTrainFirstRight;
    private final CANTalon secondRight = RobotMap.driveTrainSecondRight;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final AnalogGyro gyro = RobotMap.driveTrainGyro;
    private final OnyxTronixPIDController rotationPidControllerRight = RobotMap.driveTrainRotationRightPIDController;
    private final OnyxTronixPIDController rotationPidControllerLeft = RobotMap.driveTrainRotationLeftPIDController;
    private final DoubleSolenoid shifter = RobotMap.driveTrainShifter;

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
    
    public void setSlaveTalons(){
    	secondLeft.changeControlMode(TalonControlMode.Follower);
    	secondRight.changeControlMode(TalonControlMode.Follower);    	
    	
    	secondLeft.set(firstLeft.getDeviceID());
    	secondRight.set(firstRight.getDeviceID());
    }
    
    public void setPIDSourceType(PIDSourceType sourceType){ 
    	firstLeft.setPIDSourceType(sourceType);
    	firstRight.setPIDSourceType(sourceType);
    }
    
    public void resetSlaveTalons(){
    	firstLeft.changeControlMode(TalonControlMode.PercentVbus);
    	secondLeft.changeControlMode(TalonControlMode.PercentVbus);
    	firstRight.changeControlMode(TalonControlMode.PercentVbus);
    	secondRight.changeControlMode(TalonControlMode.PercentVbus);

    }
    
    public void PIDInit(double setPoint) {
    	rotationPidControllerLeft.init(setPoint, ROTATION_ABSOLUTE_TOLERANCE);
    	rotationPidControllerRight.init(setPoint, ROTATION_ABSOLUTE_TOLERANCE);
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    
    public void stopPID() {
    	rotationPidControllerLeft.stop();
    	rotationPidControllerRight.stop();
    }
    
    public boolean isOnTarget(){
    	return rotationPidControllerRight.onTarget() && rotationPidControllerLeft.onTarget();
    }
    
    public double getEfficientAngle(double angle) {
    	if (angle >= 180) {
    		angle -= 360;
    	} 
    	return angle;
    }
}

