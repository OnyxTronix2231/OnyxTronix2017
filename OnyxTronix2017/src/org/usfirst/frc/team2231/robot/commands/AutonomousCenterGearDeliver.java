package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.RobotMap;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2231.robot.subsystems.GearHolder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCenterGearDeliver extends CommandGroup {

    public AutonomousCenterGearDeliver() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new SwitchToStrengthGear());
    	addSequential(new DriveByDistance(DriveTrain.AUTONOMOUS_CENTER_DRIVE_TO_LIFT, false));
    	addSequential(new CenterByVision(DriveTrain.VISION_LIFT_SETPOINT, RobotMap.gripLiftConfig));
    	addParallel(new DriveByDistance(DriveTrain.AUTONOMOUS_CENTERED_DRIVE_TO_LIFT, false));
    	addSequential(new DriveUntilGearInPlace(DriveTrain.DRIVE_PID_AUTONOMOUS_OUTPUT_RANGE));
    	addSequential(new AtonomouseGearDelivery());
    }
}
