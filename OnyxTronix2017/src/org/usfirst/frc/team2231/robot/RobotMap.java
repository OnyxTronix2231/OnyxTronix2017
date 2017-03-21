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

import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;

import com.ctre.CANTalon;

import Configuration.CameraConfiguration;
import Configuration.GripConfiguration;
import Configuration.TargetConfiguration;
import GripVision.DistanceCalculation;
import GripVision.LiftAngleCalculation;
import GripVision.VisionSensorGrip;
import OnyxTronix.OnyxPipeline;
import OnyxTronix.OnyxTronixPIDController;
import OnyxTronix.PIDBalancer;
import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static CANTalon gearBlockerMotor;
    public static AnalogPotentiometer gearBlockerPotentiometer;
    public static CANTalon driveTrainFirstLeft;
    public static CANTalon driveTrainSecondLeft;
    public static CANTalon driveTrainFirstRight;
    public static CANTalon driveTrainSecondRight;
    public static RobotDrive driveTrainRobotDrive;
    public static Talon collectorWheel;
    public static CANTalon climberFirstMotor;
    public static CANTalon climberSecondMotor;
    public static ADXRS450_Gyro driveTrainGyroSPI;
    public static AnalogGyro driveTrainGyro;
    public static OnyxTronixPIDController driveTrainRotationRightPIDController;
	public static OnyxTronixPIDController driveTrainRotationLeftPIDController;
    public static CANTalon climberMotor;
    public static DoubleSolenoid driveTrainShifter;
    public static DoubleSolenoid gearHolderUpperPiston;
    public static DoubleSolenoid gearHolderLowerPiston;
    public static CANTalon shooterUpperWheel;
    public static CANTalon shooterLowerWheel;
    public static CANTalon triggerWheel;
    public static DigitalInput gearHolderMicroSwitch;
    public static GripConfiguration<OnyxPipeline> gripBoilerConfig;
    public static GripConfiguration<OnyxPipeline> gripLiftConfig;
    public static LiftAngleCalculation angleCalculation;
    public static OnyxTronixPIDController driveTrainDriveLeftPIDController;
    public static OnyxTronixPIDController driveTrainDriveRightPIDController;
    public static VisionSensorGrip visionSensor;
    public static AxisCamera liftAxisCamera;
//    public static AxisCamera boilerAxisCamera;
    public static DistanceCalculation distanceCalculation;
    public static PIDBalancer pidBalancer;
    public static OnyxTronixPIDController balancerPIDController;
    
    public static void init() {
        gearBlockerMotor = new CANTalon(9);
        LiveWindow.addActuator("GearBlocker", "Motor", gearBlockerMotor);
        
        gearBlockerPotentiometer = new AnalogPotentiometer(1);
        LiveWindow.addActuator("GearBlocker", "Potentiometer", gearBlockerPotentiometer);
        
        driveTrainFirstLeft = new CANTalon(7);
        LiveWindow.addActuator("DriveTrain", "FirstLeft", driveTrainFirstLeft);
        driveTrainFirstLeft.configEncoderCodesPerRev(300);
        driveTrainFirstLeft.reverseSensor(true);
        
        driveTrainSecondLeft = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "SecondLeft", driveTrainSecondLeft);
        
        driveTrainFirstRight = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "FirstRight", driveTrainFirstRight);
        driveTrainFirstRight.configEncoderCodesPerRev(360);
                
        driveTrainSecondRight = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "SecondRight", driveTrainSecondRight);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainFirstLeft, driveTrainSecondLeft,
              driveTrainFirstRight, driveTrainSecondRight);
        driveTrainRobotDrive.setSafetyEnabled(false);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        
        driveTrainGyroSPI = new ADXRS450_Gyro();
        LiveWindow.addSensor("DriveTrain", "Gyro", driveTrainGyroSPI);
        
        driveTrainGyro = new AnalogGyro(0);
       // driveTrainGyro.setSensitivity(0.0001);
        
        driveTrainRotationRightPIDController = new OnyxTronixPIDController(DriveTrain.ROTATION_PID_P, DriveTrain.ROTATION_PID_I, DriveTrain.ROTATION_PID_D, DriveTrain.ROTATION_PID_F, driveTrainGyro, driveTrainFirstRight, DriveTrain.ROTATION_ABSOLUTE_TOLERANCE);
        driveTrainRotationRightPIDController.setOutputRange(-1, 1);
        
        driveTrainRotationLeftPIDController = new OnyxTronixPIDController(DriveTrain.ROTATION_PID_P, DriveTrain.ROTATION_PID_I, DriveTrain.ROTATION_PID_D, DriveTrain.ROTATION_PID_F, driveTrainGyro, driveTrainFirstLeft, DriveTrain.ROTATION_ABSOLUTE_TOLERANCE);
        driveTrainRotationLeftPIDController.setOutputRange(-1, 1);      
     
       driveTrainDriveLeftPIDController = new OnyxTronixPIDController(DriveTrain.DRIVE_PID_P, DriveTrain.DRIVE_PID_I, DriveTrain.DRIVE_PID_D, DriveTrain.DRIVE_PID_F, driveTrainFirstRight, driveTrainFirstRight, DriveTrain.DRIVE_PID_TOLEEANCE);
       driveTrainDriveLeftPIDController.setOutputRange(-1, 1);
        
       driveTrainDriveRightPIDController = new OnyxTronixPIDController(DriveTrain.DRIVE_PID_P, DriveTrain.DRIVE_PID_I, DriveTrain.DRIVE_PID_D, DriveTrain.DRIVE_PID_F, driveTrainFirstRight, driveTrainFirstRight, DriveTrain.DRIVE_PID_TOLEEANCE);
       driveTrainDriveRightPIDController.setOutputRange(-1, 1);
       
       pidBalancer = new PIDBalancer(driveTrainDriveLeftPIDController, driveTrainDriveRightPIDController);
       balancerPIDController = new OnyxTronixPIDController(DriveTrain.BALANCE_PID_P, DriveTrain.BALANCE_PID_I, DriveTrain.BALANCE_PID_D, DriveTrain.BALANCE_PID_F, pidBalancer, pidBalancer, DriveTrain.BALANCE_PID_TOLEEANCE);

        collectorWheel = new Talon(0);
        LiveWindow.addActuator("BallCollector", "wheel", collectorWheel);
        
        climberFirstMotor = new CANTalon(8);
        LiveWindow.addActuator("Climber", "Frist motor", climberFirstMotor);
        
        climberSecondMotor = new CANTalon(4);
        LiveWindow.addActuator("Climber", "Second motor", climberSecondMotor);

        driveTrainShifter = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("DriveTrain", "ShifterRight", driveTrainShifter);
       
        gearHolderLowerPiston = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Gear Holder", "Piston", gearHolderLowerPiston);
      
        gearHolderUpperPiston = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Gear Holder", "Piston", gearHolderLowerPiston);
        
        shooterUpperWheel = new CANTalon(7);
        LiveWindow.addActuator("Shooter", "UpperWheel", shooterUpperWheel);
        
        shooterLowerWheel = new CANTalon(6);
        LiveWindow.addActuator("Shooter", "LowerWheel", shooterLowerWheel);
        
        triggerWheel = new CANTalon(5);
        LiveWindow.addActuator("Loader", "Wheel", triggerWheel);        
        
        gearHolderMicroSwitch = new DigitalInput(0);
        LiveWindow.addSensor("Gear Holder", "MicroSwitch", gearHolderMicroSwitch);
        
//        boilerAxisCamera = CameraServer.getInstance().addAxisCamera("10.22.31.23");
        liftAxisCamera = CameraServer.getInstance().addAxisCamera("10.22.31.12");
        
        CameraServer.getInstance().startAutomaticCapture();
        CameraConfiguration camConfig;
        TargetConfiguration tarConfig;
        
        camConfig = new CameraConfiguration(DriveTrain.ANGLE_TO_FLOOR, DriveTrain.CAMERA_HEIGHT, 
        									DriveTrain.VERTICAL_APERTURE_ANGLE, DriveTrain.VERTICAL_APERTURE_ANGLE);
        tarConfig = new TargetConfiguration(DriveTrain.BOILER_HEIGHT);
        gripBoilerConfig = new GripConfiguration<OnyxPipeline>(camConfig, tarConfig, new BoilerPipeline());
        tarConfig = new TargetConfiguration(DriveTrain.LIFT_HEIGHT);
        gripLiftConfig = new GripConfiguration<OnyxPipeline>(camConfig, tarConfig, new LiftPipeline());
        
        angleCalculation = new LiftAngleCalculation();
        distanceCalculation = new DistanceCalculation();
        
        visionSensor = new VisionSensorGrip(liftAxisCamera, gripLiftConfig, angleCalculation);  
	} 
}
