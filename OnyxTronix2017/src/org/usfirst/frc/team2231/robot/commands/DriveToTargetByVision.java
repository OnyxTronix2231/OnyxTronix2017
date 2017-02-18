package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import Configuration.GripConfiguration;
import OnyxTronix.OnyxPipeline;
import vision.PIDVisionSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToTargetByVision extends Command {
	private double m_setPoint;
	private GripConfiguration<OnyxPipeline> config;
    public DriveToTargetByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.config = config;
    	m_setPoint = setPoint;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setVisionSensorConfig(config);
    	Robot.driveTrain.setDriveSlaveTalons();
    	Robot.driveTrain.initPID(m_setPoint, PIDVisionSourceType.DistanceFromTarget);
    	
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
