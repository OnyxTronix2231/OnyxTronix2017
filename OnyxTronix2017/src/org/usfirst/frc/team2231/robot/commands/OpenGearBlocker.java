package org.usfirst.frc.team2231.robot.commands;
import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.subsystems.GearBlocker;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenGearBlocker extends Command {

    public OpenGearBlocker() {
        requires(Robot.gearBlocker); 
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.gearBlocker.openGearBlocker();
    }

	@Override
	protected boolean isFinished() {
		return Robot.gearBlocker.isOnTarget(GearBlocker.BLOCKER_OPEN_POSIION);
	}
	
	@Override
	protected void end() {
		Robot.gearBlocker.stopMotor();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
