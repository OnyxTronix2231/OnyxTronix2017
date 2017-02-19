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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class GearHolder extends Subsystem {
    private final DoubleSolenoid lowerPiston = RobotMap.gearHolderLowerPiston;    
    private final DoubleSolenoid upperPiston = RobotMap.gearHolderUpperPiston;
    private final DigitalInput microSwitch = RobotMap.gearHolderMicroSwitch;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public boolean isGearInPlace() {
    	return microSwitch.get();
    }
    
    public void setGearHolderPosition(Value value) {
    	lowerPiston.set(value);
    	upperPiston.set(value);
    }
}

