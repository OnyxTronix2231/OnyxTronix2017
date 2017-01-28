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
import org.usfirst.frc.team2231.robot.StaticField;
import org.usfirst.frc.team2231.robot.commands.*;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import onyx.OnyxCANTalon;
import onyxNiVision.OnyxTronixPIDController;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon firstLeft = RobotMap.driveTrainFirstLeft;
    private final CANTalon secondLeft = RobotMap.driveTrainSecondLeft;
    private final CANTalon firstRight = RobotMap.driveTrainFirstRight;
    private final CANTalon secondRight = RobotMap.driveTrainSecondRight;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    private final AnalogGyro gyro = RobotMap.driveTrainGyro;
    private final OnyxTronixPIDController pidControllerRight = RobotMap.driveTrainRightPIDController;
    private final OnyxTronixPIDController pidControllerLeft = RobotMap.driveTrainLeftPIDController;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveByJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void arcadeDrive(Joystick stick){
    	robotDrive.arcadeDrive(-stick.getRawAxis(1), stick.getRawAxis(4));
    }
    public void changeControlModeToFollow(){
    	secondLeft.changeControlMode(TalonControlMode.Follower);
    	secondRight.changeControlMode(TalonControlMode.Follower);    	
    	
    	secondLeft.set(firstLeft.getDeviceID());
    	secondRight.set(firstRight.getDeviceID());
    }
    public void setPIDSourceType(PIDSourceType sourceType){ 
    	firstLeft.setPIDSourceType(sourceType);
    	firstRight.setPIDSourceType(sourceType);
    }
    public void resetTalonControlMode(){
    	firstLeft.changeControlMode(TalonControlMode.PercentVbus);
    	secondLeft.changeControlMode(TalonControlMode.PercentVbus);
    	firstRight.changeControlMode(TalonControlMode.PercentVbus);
    	secondRight.changeControlMode(TalonControlMode.PercentVbus);

    }
    public void PIDInit(double setPoint) {
    	pidControllerRight.init(setPoint, StaticField.ABSOLUTE_TOLERANCE_ROTATION);
    	pidControllerLeft.init(setPoint, StaticField.ABSOLUTE_TOLERANCE_ROTATION);
    }
    public void resetGyro() {
    	gyro.reset();
    }
    public void stopPID() {
    	pidControllerLeft.stop();
    	pidControllerRight.stop();
    }
    public boolean isOnTarget(){
    	return RobotMap.driveTrainRightPIDController.onTarget() && RobotMap.driveTrainLeftPIDController.onTarget();
    }
    
    public double getEfficientAngle(double angle) {
    	if (angle >= 180) {
    		angle -= 360;
    	} 
    	return angle;
    }
}

