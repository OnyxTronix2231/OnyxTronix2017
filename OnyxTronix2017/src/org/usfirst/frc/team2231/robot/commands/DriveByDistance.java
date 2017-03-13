package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import OnyxTronix.Debug;
import OnyxTronix.SetPointCommand;

/**
 *
 */
public class DriveByDistance extends SetPointCommand {
	
    public DriveByDistance(double setPoint) {
    	super(setPoint);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setPoint = setPoint;
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    	Robot.driveTrain.changePIDType();
    	Robot.driveTrain.setSlaveTalons();
    	Robot.driveTrain.initDrivePID(setPoint / (6 * 2.54 * Math.PI));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Debug.getInstance().log(this, "Left Output: " + RobotMap.driveTrainDriveLeftPIDController.get());
    	Debug.getInstance().log(this, "Right Output: " + RobotMap.driveTrainDriveRightPIDController.get());
    	
    	Debug.getInstance().log(this, "Left Error: " + RobotMap.driveTrainDriveLeftPIDController.getError());
    	Debug.getInstance().log(this, "Right Error: " + RobotMap.driveTrainDriveRightPIDController.getError());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.isDriveOnTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stopDrivePID();
    	Robot.driveTrain.resetSlaveTalons();
    	System.out.println("Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
