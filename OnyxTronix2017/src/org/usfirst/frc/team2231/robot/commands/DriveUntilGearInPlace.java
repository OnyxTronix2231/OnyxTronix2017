package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import OnyxTronix.SetPointCommand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUntilGearInPlace extends Command {
	private SetPointCommand driveCommand;
    public DriveUntilGearInPlace() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearHolder);    	
    	driveCommand = new DriveByDistance(1);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.driveTrainDriveLeftPIDController.setOutputRange(-0.5, 0.5);
    	RobotMap.driveTrainDriveRightPIDController.setOutputRange(-0.5, 0.5);
    	driveCommand.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gearHolder.isGearInPlace();
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveCommand.cancel();
    	RobotMap.driveTrainDriveLeftPIDController.setOutputRange(-DriveTrain.DRIVE_PID_OUTPUTRANGE, DriveTrain.DRIVE_PID_OUTPUTRANGE);
    	RobotMap.driveTrainDriveRightPIDController.setOutputRange(-DriveTrain.DRIVE_PID_OUTPUTRANGE, DriveTrain.DRIVE_PID_OUTPUTRANGE);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
