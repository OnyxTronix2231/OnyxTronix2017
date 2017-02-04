package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootByEncoder extends Command {
	
    public ShootByEncoder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setSlaveTalon();
		Robot.shooter.setPIDSourceType(PIDSourceType.kRate);
    	Robot.shooter.initPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Error: " + RobotMap.shooterPIDController.getError());
    	System.out.println("OutPut: " + RobotMap.shooterPIDController.get());
    	System.out.println("PID get: " + RobotMap.shooterLowerWheel.pidGet());    	
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
    	Robot.shooter.disablePID();
    	Robot.shooter.resetSlaveTalon();
    }
}
