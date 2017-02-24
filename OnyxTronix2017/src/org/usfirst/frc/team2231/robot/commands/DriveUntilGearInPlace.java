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
	
	double output;
	
	public DriveUntilGearInPlace(double output) {
		this.output = output;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.driveTrain.setOutputRange(output);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(Robot.gearHolder.isPegInGear());
        return Robot.gearHolder.isPegInGear();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setOutputRange(DriveTrain.DRIVE_PID_DEFAULT_OUTPUT_RANGE);
    	Robot.driveTrain.stopDrivePID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
