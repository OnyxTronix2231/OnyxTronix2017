package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByDistance extends Command {
	private double m_setPoint;
	
    public DriveByDistance(double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	m_setPoint = setPoint;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.changePIDType();
    	Robot.driveTrain.setSlaveTalons();
    	Robot.driveTrain.initPID(m_setPoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.isOnTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stopPID();
    	Robot.driveTrain.resetSlaveTalons();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
