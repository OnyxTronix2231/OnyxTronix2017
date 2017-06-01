package org.usfirst.frc.team2231.robot.commands;

import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousLeftGearDeliver extends CommandGroup {

    public AutonomousLeftGearDeliver() {
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
    	addSequential(new CloseGearHolder());
    	addSequential(new SwitchToStrengthGear());
    	addSequential(new UpperGearLift());
    	addSequential(new DriveByDistance(DriveTrain.AUTONOMOUS_LEFT_DRIVE, false));
    	addSequential(new RotateByAngle(-DriveTrain.AUTONOMOUS_ANGLE, false));
    	//addSequential(new CenterByVision(DriveTrain.VISION_LIFT_SETPOINT, RobotMap.gripLiftConfig));
    	addSequential(new DriveByDistance(DriveTrain.AUTONOMOUS_LEFT_DRIVE_TO_LIFT, false), 3);
    	addSequential(new OpenGearHolder());
    	addSequential(new AtonomouseGearDelivery());
    }
}
