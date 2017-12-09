// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class ToggleGearHold extends ConditionalCommand {

	private boolean state;
    public ToggleGearHold(boolean state) {
    	super(new OpenGearHolder(state), new CloseGearHolder(state));
    	this.state = state;
    }

    protected boolean condition(){
    	if (state)
    		return RobotMap.gearHolderLowerPiston.get() != Value.kForward;
    	else
    		return RobotMap.gearHolderUpperPiston.get() != Value.kForward;
    }
}
