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
import org.usfirst.frc.team2231.robot.commands.ClimbRope;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Climber extends Subsystem {
    private final CANTalon motor = RobotMap.climberMotor;
    private static final double SENSITIVITY_VALUE = 1 * 0.2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new ClimbRope());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void climbRope() {
    	if(Math.abs(Robot.oi.getButtonStick().getRawAxis(1)) > SENSITIVITY_VALUE){
    		motor.set(Robot.oi.getButtonStick().getRawAxis(1));
    	} else {
    		motor.set(0);
    	}
    }
}

