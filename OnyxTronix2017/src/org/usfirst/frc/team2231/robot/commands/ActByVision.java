package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import Configuration.GripConfiguration;
import Configuration.VisionConfiguration;
import GripVision.GripVisionStrategy;
import OnyxTronix.Debug;
import OnyxTronix.OnyxPipeline;
import OnyxTronix.SetPointCommand;
import vision.PIDVisionSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ActByVision extends Command {
	private double m_setPoint;
	private GripConfiguration<OnyxPipeline> config;
	private SetPointCommand setPointCommand;
	private boolean isFinished = false;
	private GripVisionStrategy strategy;
	
    public ActByVision(double setPoint, GripConfiguration<OnyxPipeline> config,
    					  SetPointCommand setPointCommand, GripVisionStrategy strategy) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.config = config;
    	m_setPoint = setPoint;
    	this.setPointCommand = setPointCommand;
    	this.strategy = strategy;
    }
 
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.driveTrain.setVisionOperation(config, strategy);
    	setPointCommand.setSetPoint(Robot.driveTrain.getVisionValueBySetPoint(m_setPoint));
    	setPointCommand.start();
    }
    
    @Override
    protected void execute() {
    	Debug.getInstance().log(this, Robot.driveTrain.getError() + "");
    	if(!setPointCommand.isRunning()) {
			if(Robot.driveTrain.isVisionOnTarget(m_setPoint)) { //vision calc is not accurate, doing calculation until the vision is on target 
				isFinished = true;
			}
			setPointCommand.setSetPoint(Robot.driveTrain.getVisionValueBySetPoint(m_setPoint));
			setPointCommand.start();
    	}
    }

    @Override
	protected boolean isFinished() {
		return isFinished;
	}
}
