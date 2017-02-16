package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import Configuration.GripConfiguration;
import Configuration.VisionConfiguration;
import OnyxTronix.Debug;
import OnyxTronix.OnyxPipeline;
import vision.PIDVisionSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CenterByVision extends Command {
	private double m_setPoint;
	private GripConfiguration<OnyxPipeline> config;
	private RotateByAngle rotateByAngle;
    public CenterByVision(double setPoint, GripConfiguration<OnyxPipeline> config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.config = config;
    	m_setPoint = setPoint;
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setConfig(config);
    	rotateByAngle = new RotateByAngle(Robot.driveTrain.getAngleFromVision(m_setPoint));
    	rotateByAngle.start();
    }
    
    @Override
    protected void execute() {
    	Debug.getInstance().log(this, Robot.driveTrain.getAngleError() + "");
    }

	protected boolean isFinished() {
		if(!rotateByAngle.isRunning()) {
			if(Robot.driveTrain.isVisionOnTarget(m_setPoint)) { //vision calc is not accurate, 
																//doing calculation until the vision is on target 
				return true;
			}
			rotateByAngle.setSetPoint(Robot.driveTrain.getAngleFromVision(m_setPoint));
			rotateByAngle.start();
		}
		return false;
	}
}
