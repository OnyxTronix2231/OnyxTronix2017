package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class ToggleLoad extends ConditionalCommand {

    public ToggleLoad(Command onTrue, Command onFalse) {
    	super(onTrue, onFalse);
    }

	@Override
	protected boolean condition() {
		return Robot.trigger.getCurrentCommand() instanceof ToggleLoad;
	}
}
