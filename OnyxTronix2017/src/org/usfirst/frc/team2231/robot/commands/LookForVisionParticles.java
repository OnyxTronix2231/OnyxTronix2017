package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LookForVisionParticles extends Command {
	private int numberOfParticles;
	private double speed;
    public LookForVisionParticles(int numberOfParticles, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.numberOfParticles = numberOfParticles;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.arcadeDrive(0, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.getNumberOfVisionParticles() >= numberOfParticles;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
