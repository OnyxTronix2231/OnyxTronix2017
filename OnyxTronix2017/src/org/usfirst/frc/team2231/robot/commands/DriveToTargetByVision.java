package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import Configuration.GripConfiguration;
import GripVision.DistanceCalculation;
import OnyxTronix.OnyxPipeline;
import vision.PIDVisionSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class DriveToTargetByVision extends InstantCommand {
	private double setPoint;
	private GripConfiguration<OnyxPipeline> config;
    public DriveToTargetByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.config = config;
    	this.setPoint = setPoint;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	new ActByVision(setPoint, config, new DriveByDistance(setPoint), RobotMap.distanceCalculation);
    }
}
