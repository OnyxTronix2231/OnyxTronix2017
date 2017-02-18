package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.RobotMap;

import Configuration.GripConfiguration;
import OnyxTronix.OnyxPipeline;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CenterByVision extends InstantCommand {
	private double setPoint;
	private GripConfiguration<OnyxPipeline> config;
	
    public CenterByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setPoint = setPoint;
    }

    // Called once when the command executes
    protected void initialize() {
    	new ActByVision(setPoint, config, new RotateByAngle(0), RobotMap.angleCalculation).start();
    }

}
