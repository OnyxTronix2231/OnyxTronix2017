package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearPistonPosByAxis extends Command {
	private Command command;
	
    public GearPistonPosByAxis() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearHolder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getButtonStick().getRawAxis(2) >= 0.9) {
    		Robot.gearHolder.setPistonPosition(Value.kForward);
    	}
    	
    	if(Robot.oi.getButtonStick().getRawAxis(3) >= 0.9) {
    		Robot.gearHolder.setPistonPosition(Value.kReverse);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
