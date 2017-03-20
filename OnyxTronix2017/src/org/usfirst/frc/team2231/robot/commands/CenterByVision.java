package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.RobotMap;

import Configuration.GripConfiguration;
import OnyxTronix.OnyxPipeline;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterByVision extends Command {
	private double setPoint;
	private GripConfiguration<OnyxPipeline> config;
	private ActByVision actByVision;
	
    public CenterByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setPoint = setPoint;
    	this.config = config;
    }

    // Called once when the command executes
    protected void initialize() {
    	actByVision = new ActByVision(setPoint, config, new RotateByAngle(setPoint), RobotMap.angleCalculation, true);
    	actByVision.start();
    }

	@Override
	protected boolean isFinished() {
		if(actByVision != null) { 
			return !actByVision.isRunning();
		}
		return false;
	}
	
	@Override
	protected void interrupted() {
		actByVision.cancel();
	}

}
