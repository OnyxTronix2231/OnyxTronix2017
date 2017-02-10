package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.subsystems.Collector;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StartCollectingBalls extends InstantCommand {
	private CollectBalls collectBalls;
	
    public StartCollectingBalls() {
    	collectBalls = new CollectBalls(Collector.SPEED);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	collectBalls.start();
    }

}
