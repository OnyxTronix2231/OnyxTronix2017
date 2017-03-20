package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import Configuration.GripConfiguration;
import OnyxTronix.OnyxPipeline;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToTargetByVision extends Command {
	private double setPoint;
	private GripConfiguration<OnyxPipeline> config;
	private ActByVision actByVision;

    public DriveToTargetByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.config = config;
    	this.setPoint = setPoint;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	actByVision = new ActByVision(setPoint, config, new DriveByDistance(setPoint, true), RobotMap.distanceCalculation, false);
    }

	@Override
	protected boolean isFinished() {
		return actByVision.isRunning();
	}
	
	@Override
	protected void end() {
	}
	
	@Override
	protected void interrupted() {
		actByVision.cancel();
	}
}
