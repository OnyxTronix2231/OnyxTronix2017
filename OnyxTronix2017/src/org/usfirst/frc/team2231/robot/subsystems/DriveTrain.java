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

import org.usfirst.frc.team2231.robot.Buttons.Button;
import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;

import OnyxTronix.Debug;
import vision.PIDVisionSourceType;
import vision.VisionSensor;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import Configuration.GripConfiguration;
import GripVision.AngleCalculation;
import GripVision.GripVisionStrategy;
import GripVision.VisionSensorGrip;
import OnyxTronix.Debug;
import OnyxTronix.OnyxPipeline;
import OnyxTronix.OnyxTronixPIDController;
import OnyxTronix.PIDBalancer;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
	public static final double ROTATION_PID_P = 0.002;
	public static final double ROTATION_PID_I = 0.00001;
	public static final double ROTATION_PID_D = 0.035;
	public static final double ROTATION_PID_F = 0.21;
	public static final double ROTATION_ABSOLUTE_TOLERANCE = 10;
	public static final double ANGLE_TO_FLOOR = 31;
    public static final double CAMERA_HEIGHT = 40; //In meter.
    public static final double BOILER_HEIGHT = 70; //In meter.
    public static final double LIFT_HEIGHT = 20; //In meter.
    public static final double VERTICAL_APERTURE_ANGLE = 35;
    public static final double HORIZONTAL_APERTURE_ANGLE = 67;
	public static final double DRIVE_PID_P = 0.06;
	public static final double DRIVE_PID_I = 0.001;
	public static final double DRIVE_PID_D = 4;
	public static final double DRIVE_PID_F = 0.12;
	public static final double DRIVE_PID_TOLEEANCE = 0.5;
	public static final double DRIVE_PID_AUTONOMOUS_OUTPUT_RANGE = 1;
	public static final double DRIVE_PID_DEFAULT_OUTPUT_RANGE = 1;
	public static final double BALANCE_PID_P = 0;
	public static final double BALANCE_PID_I = 0;
	public static final double BALANCE_PID_D = 0;
	public static final double BALANCE_PID_F = 0;
	public static final double BALANCE_PID_TOLEEANCE = 0.005;
	public static final double BALANCE_PID_DEFAULT_OUTPUT_RANGE = 1;
	public static final double BALANCE_PID_SETPOINT = 1;

    private final CANTalon firstLeft = RobotMap.driveTrainFirstLeft;
    private final CANTalon secondLeft = RobotMap.driveTrainSecondLeft;
    private final CANTalon firstRight = RobotMap.driveTrainFirstRight;
    private final CANTalon secondRight = RobotMap.driveTrainSecondRight;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final AnalogGyro gyro = RobotMap.driveTrainGyro;
    private final OnyxTronixPIDController rotationPidControllerRight = RobotMap.driveTrainRotationRightPIDController;
    private final OnyxTronixPIDController rotationPidControllerLeft = RobotMap.driveTrainRotationLeftPIDController;
    private final VisionSensorGrip visionSensor = RobotMap.visionSensor;
    private final AngleCalculation angleCalculation = RobotMap.angleCalculation;
    private final OnyxTronixPIDController driveLeftPIDController = RobotMap.driveTrainDriveLeftPIDController;
    private final OnyxTronixPIDController driveRightPIDController = RobotMap.driveTrainDriveRightPIDController;
    private final OnyxTronixPIDController balancerPIDController = RobotMap.balancerPIDController;
    private final PIDBalancer pidBalancer = RobotMap.pidBalancer;
    private final DoubleSolenoid shifter = RobotMap.driveTrainShifter;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new DriveByJoystick());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void arcadeDrive(Joystick stick){
    	robotDrive.arcadeDrive(stick.getRawAxis(1), stick.getRawAxis(4));
    }
    
    public void arcadeDrive(double moveValue, double rotateValue){
    	robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    public void switchToStrengthGear() {
    	shifter.set(Value.kReverse);
    }
    
    public void switchToSpeedGear() {
    	shifter.set(Value.kForward);
    }

    public void setSlaveTalons(){
    	secondLeft.changeControlMode(TalonControlMode.Follower);
    	secondRight.changeControlMode(TalonControlMode.Follower);    	
    	secondLeft.set(firstLeft.getDeviceID());
    	secondRight.set(firstRight.getDeviceID());
    	firstLeft.setInverted(true);
    }
    
    public void setRotateSlaveTalons(){
    	secondLeft.changeControlMode(TalonControlMode.Follower);
    	secondRight.changeControlMode(TalonControlMode.Follower);    	
    	secondLeft.set(firstLeft.getDeviceID());
    	secondRight.set(firstRight.getDeviceID());
    	firstLeft.setInverted(true);
    	firstRight.setInverted(true);
    }
    
    public void setPIDSourceType(PIDSourceType sourceType){ 
    	firstLeft.setPIDSourceType(sourceType);
    	firstRight.setPIDSourceType(sourceType);
    }
    
    public void resetGyro() {
    	gyro.reset();
    }
    
    public void stopDrivePID() {
    	driveLeftPIDController.stop();
    	driveRightPIDController.stop();
    	
    }
    
    public boolean isDriveOnTarget(){
    	return driveLeftPIDController.onTarget() && driveRightPIDController.onTarget();
    }
    
    public double getEfficientAngle(double angle) {
    	angle %= 360;
    	if (angle >= 180) {
    		angle -= 360;
    	} 
    	return angle;
    }
    
    public void resetSlaveTalons() {
    	firstRight.changeControlMode(TalonControlMode.PercentVbus);
    	firstLeft.changeControlMode(TalonControlMode.PercentVbus);
    	secondLeft.changeControlMode(TalonControlMode.PercentVbus);
    	secondRight.changeControlMode(TalonControlMode.PercentVbus);
    	firstLeft.setInverted(false);
    	firstRight.setInverted(false);
    }

	public void resetEncoders() {
		firstLeft.setPosition(0);
		firstRight.setPosition(0);
	}

	public void changePIDType() {
		firstLeft.setPIDSourceType(PIDSourceType.kDisplacement);
		firstRight.setPIDSourceType(PIDSourceType.kDisplacement);
		pidBalancer.setPIDSourceType(PIDSourceType.kDisplacement);
	}

	public void initDrivePID(double setPoint) {
		System.out.println("Is left initialized: " + driveLeftPIDController.init(setPoint, DRIVE_PID_TOLEEANCE));
		System.out.println("Is right initialized: " + driveRightPIDController.init(setPoint, DRIVE_PID_TOLEEANCE));
		System.out.println("Is balance initialized: " + balancerPIDController.init(BALANCE_PID_SETPOINT, DRIVE_PID_TOLEEANCE));
	}
	
    public void setOutputRange(double output) {
    	driveLeftPIDController.setOutputRange(-output, output);
    	driveRightPIDController.setOutputRange(-output, output);
    }
    
    public void initRotatePID(double setPoint) {
    	rotationPidControllerLeft.init(setPoint, ROTATION_ABSOLUTE_TOLERANCE);
    	rotationPidControllerRight.init(setPoint, ROTATION_ABSOLUTE_TOLERANCE);
    }
    
    public void setPIDSetPoint(double setPoint) {
    	rotationPidControllerLeft.setSetpoint(setPoint);
    	rotationPidControllerRight.setSetpoint(setPoint);
    }
    
    public void stopRotatePID() {
    	rotationPidControllerLeft.stop();
    	rotationPidControllerRight.stop();
    	balancerPIDController.stop();
    }
    
    public boolean isRotateOnTarget(){
    	return rotationPidControllerRight.onTarget() && rotationPidControllerLeft.onTarget();
    }
    
    public void setVisionOperation(GripConfiguration<OnyxPipeline> config, GripVisionStrategy strategy) {
    	visionSensor.setConfiguration(config);
    	visionSensor.setStrategy(strategy);
    }
    
    public double getVisionValueBySetPoint(double setPoint) {
    	return visionSensor.getValueBySetPoint(setPoint);
    }
    
    public double getError() {
    	return rotationPidControllerRight.getError();
    }
    
    public boolean isVisionOnTarget(double setPoint) {
    	return Math.abs(Robot.driveTrain.getVisionValueBySetPoint(setPoint)) < DriveTrain.ROTATION_ABSOLUTE_TOLERANCE;
    }
}

