package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import vision.PIDVisionSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterByVision extends Command {
	private double m_setPoint;

    public CenterByVision(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_setPoint = setPoint;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setRotationSlaveTalons();
    	Robot.driveTrain.initPID(m_setPoint, PIDVisionSourceType.NormalizedDistanceFromCenter);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.isOnTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.resetSlaveTalons();
    	Robot.driveTrain.stopPID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
