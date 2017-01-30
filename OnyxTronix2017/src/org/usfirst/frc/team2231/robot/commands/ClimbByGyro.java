package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.StaticFields;
import org.usfirst.frc.team2231.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbByGyro extends Command {
	
    public ClimbByGyro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.gyro.reset();
    	Robot.climber.initPID(Robot.climber.getSetPointByRobotAngle());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.PIDClimberContoller.setSetpoint(Robot.climber.getSetPointByRobotAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.climber.isOnAngle(StaticFields.SETPOINT_ANGLE);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.disablePID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
