package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import Configuration.GripConfiguration;
import GripVision.GripVisionStrategy;
import OnyxTronix.OnyxPipeline;
import OnyxTronix.SetPointCommand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterByVision extends ActByVision {	

    public CenterByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
    	super(setPoint, config, new RotateByAngleVision(setPoint, true), RobotMap.angleCalculation, true);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }
}
