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

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.commands.ControlShooting;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import onyxNiVision.OnyxTronixPIDController;

/**
 *
 */
public class Shooter extends Subsystem {
	public static final double SPEED = 1;
	public static final double PID_SET_POINT = 1000;
	public static final double PID_P = 0.0001;
	public static final double PID_I = 0;
	public static final double PID_D = 0;
	public static final double PID_F = 0;
	public static final double ABSOLUTE_TOLERANCE = 5;
	public boolean isShooting = false;
	
    private final CANTalon upperWheel = RobotMap.shooterUpperWheel;
    private final CANTalon lowerWheel = RobotMap.shooterLowerWheel;
    private final OnyxTronixPIDController PIDController = RobotMap.shooterPIDController;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ControlShooting());
	}
	
	public void startShoot() {
		upperWheel.set(SPEED);
		lowerWheel.set(SPEED);
	}
	
	public void stopShoot() {
		upperWheel.set(0);
		lowerWheel.set(0);
	}
	
	public void setSlaveTalon() {
		lowerWheel.changeControlMode(TalonControlMode.Follower);
		lowerWheel.set(upperWheel.getDeviceID());
		lowerWheel.reverseOutput(true);
	}
	
	public void initPID() {
		PIDController.init(PID_SET_POINT, ABSOLUTE_TOLERANCE);
	}
	
	public void disablePID() {
		PIDController.stop();
	}
	
	public void resetSlaveTalon() {
		lowerWheel.changeControlMode(TalonControlMode.PercentVbus);
		lowerWheel.reverseOutput(false);
	}
	
	public void setPIDSourceType(PIDSourceType PIDSourceType) {
		upperWheel.setPIDSourceType(PIDSourceType);
	}
	
	public boolean isReady(){
		return PIDController.isEnabled() && PIDController.onTarget();
	}
	
	public void toggleIsShooting() {
		isShooting = !isShooting;
	}
	
	public void toggleShooting() {
		if(Robot.shooter.isShooting) {
    		Robot.shooter.startShoot();
    	} else {
    		Robot.shooter.stopShoot();
    	}
	}
}
