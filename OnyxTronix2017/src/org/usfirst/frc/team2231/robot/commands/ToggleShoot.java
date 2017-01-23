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

import edu.wpi.first.wpilibj.command.ConditionalCommand;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

/**
 *
 */
public class ToggleShoot extends ConditionalCommand {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ToggleShoot() {
	super(new StartShoot(), new StopShoot());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR

    }

    protected boolean condition(){
        return (Robot.shooter.getFirstWheel() == 0) && (Robot.shooter.getSecondWheel() == 0);
    }
}
