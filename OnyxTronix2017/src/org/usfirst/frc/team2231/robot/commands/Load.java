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
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

/**
 *
 */
public class Load extends Command {
    private double m_maxSpeed;
 
    public Load(double maxSpeed) {
        m_maxSpeed = maxSpeed;
     
        requires(Robot.loader);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.loaderWheel.set(m_maxSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.loaderWheel.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
