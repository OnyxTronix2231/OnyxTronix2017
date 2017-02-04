package org.usfirst.frc.team2231.robot.commands;
import org.usfirst.frc.team2231.robot.Robot;
import org.usfirst.frc.team2231.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenGearBlockerPiston extends InstantCommand {

    public OpenGearBlockerPiston() {
        requires(Robot.gearBlocker); 
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shooter.resetSlaveTalon();
    	Robot.shooter.disablePID();
    	RobotMap.gearBlockerPiston.set(Value.kForward);
    }

}
