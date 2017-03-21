package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
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
	private boolean started = false;
	
    public CenterByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setPoint = setPoint;
    	this.config = config;
    	requires(Robot.driveTrain);
    }

    // Called once when the command executes
    protected void initialize() {
    	started = false;
    	actByVision = new ActByVision(setPoint, config, new RotateByAngle(setPoint, true), RobotMap.angleCalculation, true);
    	actByVision.start();
    	started = true;
    }

	@Override
	protected boolean isFinished() {
		if(started && actByVision != null) { 
			return actByVision.isFinished();
		}
		return false;
	}
	
	@Override
	protected void interrupted() {
		actByVision.cancel();
	}

}
