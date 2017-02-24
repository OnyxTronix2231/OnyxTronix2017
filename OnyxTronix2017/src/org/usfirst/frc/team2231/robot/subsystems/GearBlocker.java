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
import org.usfirst.frc.team2231.robot.commands.GearBlockerAxisControl;

import OnyxTronix.Debug;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class GearBlocker extends Subsystem {
	public static final double TOLERANCE = 0.0001;
	public static final double BLOCKER_OPEN_POSIION = 0.1177;
	public static final double BLOCKER_CLOSE_POSIION = 0.1058;
	public static final double MOTOR_SPEED = 0.25;
	
    private final CANTalon motor = RobotMap.gearBlockerMotor;
    private final AnalogPotentiometer potentiometer = RobotMap.gearBlockerPotentiometer;

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GearBlockerAxisControl());
    }
    
    public void openGearBlocker() {
    	if(potentiometer.get() > BLOCKER_OPEN_POSIION) {
        	motor.set(MOTOR_SPEED);
    	}
    }
    
    public void setGearBlocker(double setPointAngle) {
    	if(potentiometer.get() > setPointAngle) {
        	motor.set(-MOTOR_SPEED);
    	}else {
        	motor.set(MOTOR_SPEED);
    	}
    }
    
    public boolean isOnTarget(double setPointAngle) {
    	Debug.getInstance().log(this, "Error: " + (setPointAngle - potentiometer.get()));
    	return Math.abs(setPointAngle - potentiometer.get()) < TOLERANCE;
    }

	public void stopMotor() {
		motor.set(0);		
	}
}

 