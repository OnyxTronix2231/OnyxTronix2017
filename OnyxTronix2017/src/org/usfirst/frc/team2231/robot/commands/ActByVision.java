package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import Configuration.GripConfiguration;
import GripVision.GripVisionStrategy;
import OnyxTronix.Debug;
import OnyxTronix.OnyxPipeline;
import OnyxTronix.SetPointCommand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActByVision extends Command {
	private double setPoint;
	private GripConfiguration<OnyxPipeline> config;
	private SetPointCommand setPointCommand;
	private boolean isFinished = false;
	private GripVisionStrategy strategy;
	private boolean isContinues;
	private boolean hasStarted = false;

    public ActByVision(double setPoint, GripConfiguration<OnyxPipeline> config,
    					  SetPointCommand setPointCommand, GripVisionStrategy strategy, boolean isContinues) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.config = config;
    	this.setPoint = setPoint;
    	this.setPointCommand = setPointCommand;
    	this.strategy = strategy;
    	this.isContinues = isContinues;
    }
 
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	isFinished = false;
    	hasStarted = false;
    	Robot.driveTrain.setVisionOperation(config, strategy);
    	setPointCommand.setSetPoint(-Robot.driveTrain.getVisionErrorBySetPoint(setPoint));
    	setPointCommand.start();
    	hasStarted = true;
    }
    
    @Override
    protected void execute() {
    	Debug.getInstance().log(this, Robot.driveTrain.getError() + "");
    	if(hasStarted && setPointCommand.isFinished()) {
			if(!isContinues || Robot.driveTrain.isVisionOnTarget(setPoint)) { //vision calc is not accurate, doing calculation until the vision is on target 
				isFinished = true;
				System.out.println("Act finished");
			} else {
				System.out.println("Processing image...");
				setPointCommand.setSetPoint(-Robot.driveTrain.getVisionErrorBySetPoint(setPoint));
				setPointCommand.start();
			}
    	}
    }

    @Override
	protected boolean isFinished() {
		return isFinished;
	}
}
