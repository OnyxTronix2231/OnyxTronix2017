package org.usfirst.frc.team2231.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AtonomouseSimpleCenterGear extends CommandGroup {

    public AtonomouseSimpleCenterGear() {
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
//    	addSequential(new DriveByTimeOut(0.5, 1, 0));
    	addSequential(new TimeOut(0.5));
    	addSequential(new DriveByDistance(185, false));
//    	addSequential(new DriveByDistance(30, false));
    	addSequential(new OpenGearHolder());
    	addSequential(new AtonomouseGearDelivery());
    }
}
