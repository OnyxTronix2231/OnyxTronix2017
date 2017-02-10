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

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Collector extends Subsystem {
	public static final double SPEED = 1;
    private final CANTalon wheel = RobotMap.collectorWheel;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void startBallCollector(double speed) {
    	wheel.set(speed);
    }
    
    public void stopBallCollector() {
    	wheel.set(0);
    }
    
    public boolean isCollecting() {
    	return wheel.get() != 0;
    }
}

