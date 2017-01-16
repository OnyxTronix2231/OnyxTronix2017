// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team2231.robot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainFirstLeft;
    public static CANTalon driveTrainSecondLeft;
    public static CANTalon driveTrainFirstRight;
    public static CANTalon driveTrainSecondRight;
    public static RobotDrive driveTrainRobotDrive;
    public static DoubleSolenoid driveTrainDoubleSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainFirstLeft = new CANTalon(0);
        LiveWindow.addActuator("DriveTrain", "FirstLeft", driveTrainFirstLeft);
        
        driveTrainSecondLeft = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "SecondLeft", driveTrainSecondLeft);
        
        driveTrainFirstRight = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "FirstRight", driveTrainFirstRight);
        
        driveTrainSecondRight = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "SecondRight", driveTrainSecondRight);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainFirstLeft, driveTrainSecondLeft,
              driveTrainFirstRight, driveTrainSecondRight);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        driveTrainDoubleSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("DriveTrain", "Double Solenoid", driveTrainDoubleSolenoid);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
