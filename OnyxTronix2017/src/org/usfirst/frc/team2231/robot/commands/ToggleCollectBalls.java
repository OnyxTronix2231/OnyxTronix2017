package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class ToggleCollectBalls extends ConditionalCommand {

    public ToggleCollectBalls() {
    	super(new StartCollectingBalls(), new StopCollectingBalls());
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
	@Override
	protected boolean condition() {
		return Robot.collector.isCollecting();
	}
}
