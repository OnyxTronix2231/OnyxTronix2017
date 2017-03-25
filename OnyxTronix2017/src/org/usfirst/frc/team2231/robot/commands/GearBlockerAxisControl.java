package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearBlockerAxisControl extends Command {

    public GearBlockerAxisControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearBlocker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    private double potPosition = 0;
    private double potMaxDistance = 0.112 - 0.108;
    protected void execute() {
    	double speed = Robot.oi.getButtonStick().getRawAxis(5);
    	if(Math.abs(speed) > 0.15){
    		if(speed < 0) {
    			if(!RobotMap.gearBlockerMicroSwitch.get()) {
    				RobotMap.gearBlockerMotor.set(0.4 * speed);
    			} else {
    				potPosition = RobotMap.gearBlockerPotentiometer.get();
    				RobotMap.gearBlockerMotor.set(0);
    			}
    		}
    		else {
    			if(Math.abs(potPosition) + Math.abs(potMaxDistance) > Math.abs(RobotMap.gearBlockerPotentiometer.get())){
    				RobotMap.gearBlockerMotor.set(0.65 * speed);
    			} else {
    				RobotMap.gearBlockerMotor.set(0);
    			}
    		}
    	} else {
    		RobotMap.gearBlockerMotor.set(0);
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
