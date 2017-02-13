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

import org.usfirst.frc.team2231.robot.subsystems.Climber;

import OnyxTronix.OnyxTronixPIDController;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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
    public static DoubleSolenoid gearBlockerPiston;
    public static CANTalon driveTrainFirstLeft;
    public static CANTalon driveTrainSecondLeft;
    public static CANTalon driveTrainFirstRight;
    public static CANTalon driveTrainSecondRight;
    public static RobotDrive driveTrainRobotDrive;
    public static CANTalon collectorWheel;
    public static CANTalon climberMotor;
    public static DoubleSolenoid driveTrainShifter;
    public static DoubleSolenoid gearHolderPiston;
    public static CANTalon shooterUpperWheel;
    public static CANTalon shooterLowerWheel;
    public static CANTalon triggerWheel;
    public static ADXRS450_Gyro gyro;
    public static OnyxTronixPIDController climberPIDContoller;
    
    public static void init() {
        gearBlockerPiston = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("GearBlocker", "Piston", gearBlockerPiston);
        
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

        collectorWheel = new CANTalon(4);
        LiveWindow.addActuator("BallCollector", "wheel", collectorWheel);
        
        climberMotor = new CANTalon(8);
        LiveWindow.addActuator("Climber", "Motor", climberMotor);

        driveTrainShifter = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("DriveTrain", "ShifterRight", driveTrainShifter);
       
        gearHolderPiston = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Gear Holder", "Piston", gearHolderPiston);
      
        shooterUpperWheel = new CANTalon(7);
        LiveWindow.addActuator("Shooter", "UpperWheel", shooterUpperWheel);
        
        shooterLowerWheel = new CANTalon(6);
        LiveWindow.addActuator("Shooter", "LowerWheel", shooterLowerWheel);
        
        triggerWheel = new CANTalon(5);
        LiveWindow.addActuator("Loader", "Wheel", triggerWheel);        
    
        climberPIDContoller = new OnyxTronixPIDController(Climber.PID_P, Climber.PID_I ,
        												  Climber.PID_D, Climber.PID_F, climberMotor,
        														climberMotor, Climber.PID_TOLERNCE );
        climberPIDContoller.setOutputRange(-Climber.OUTPUT_RANGE, Climber.OUTPUT_RANGE);
    }
}
