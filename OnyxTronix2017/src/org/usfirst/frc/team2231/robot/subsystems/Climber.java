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
import org.usfirst.frc.team2231.robot.commands.ClimbRopeByAxis;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Climber extends Subsystem {
    private final CANTalon firstMotor = RobotMap.climberFirstMotor;
    private final CANTalon secondMotor = RobotMap.climberSecondMotor;
    private static final double SENSITIVITY_VALUE = 1 * 0.2;
    public static final int DEFAULT_DIRECTION = 1;
    public int climbDirection = DEFAULT_DIRECTION;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new ClimbRopeByAxis());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void climbRope() {
    	if(Math.abs(Robot.oi.getButtonStick().getRawAxis(1)) > SENSITIVITY_VALUE){
    		double speed = climbDirection * Math.abs(Robot.oi.getButtonStick().getRawAxis(1));
    		firstMotor.set(speed);
    		secondMotor.set(speed);
    	} else {
    		firstMotor.set(0);
    		secondMotor.set(0);
    	}
    }
}

