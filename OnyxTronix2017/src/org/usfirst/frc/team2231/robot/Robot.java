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

import org.usfirst.frc.team2231.robot.Buttons.Button;
import org.usfirst.frc.team2231.robot.commands.AutonomousCenterGearDeliver;
import org.usfirst.frc.team2231.robot.commands.AutonomousDriveByTimeOut;
import org.usfirst.frc.team2231.robot.commands.AutonomousLeftGearDeliver;
import org.usfirst.frc.team2231.robot.commands.AutonomousLine;
import org.usfirst.frc.team2231.robot.commands.AutonomousRightGearDeliver;
import org.usfirst.frc.team2231.robot.subsystems.Climber;
import org.usfirst.frc.team2231.robot.subsystems.Collector;
import org.usfirst.frc.team2231.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2231.robot.subsystems.GearBlocker;
import org.usfirst.frc.team2231.robot.subsystems.GearHolder;
import org.usfirst.frc.team2231.robot.subsystems.Shooter;
import org.usfirst.frc.team2231.robot.subsystems.Trigger;

import OnyxTronix.Debug;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser<Command> autonomousChooser;
    SendableChooser<Boolean> testModeChooser;

    public static OI oi;
    public static GearBlocker gearBlocker;
    public static DriveTrain driveTrain;
    public static Collector collector;
    public static Climber climber;
    public static GearHolder gearHolder;
    public static Shooter shooter;
    public static Trigger trigger;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotMap.init();
    	
        gearBlocker = new GearBlocker();
        driveTrain = new DriveTrain();
        collector = new Collector();
        climber = new Climber();
        gearHolder = new GearHolder();
        shooter = new Shooter();
        trigger = new Trigger();

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period

        SmartDashboard.putNumber("Drive PID P", DriveTrain.DRIVE_PID_P);
        SmartDashboard.putNumber("Drive PID I", DriveTrain.DRIVE_PID_I);
        SmartDashboard.putNumber("Drive PID D", DriveTrain.DRIVE_PID_D);
        SmartDashboard.putNumber("Drive PID F", DriveTrain.DRIVE_PID_F);
        SmartDashboard.putBoolean("Reverse climber direction", false);

        SmartDashboard.putNumber("Rotation PID P", DriveTrain.ROTATION_PID_P);
        SmartDashboard.putNumber("Rotation PID I", DriveTrain.ROTATION_PID_I);
        SmartDashboard.putNumber("Rotation PID D", DriveTrain.ROTATION_PID_D);
        SmartDashboard.putNumber("Rotation PID F", DriveTrain.ROTATION_PID_F);
        
        autonomousChooser = new SendableChooser<>();
        autonomousChooser.addDefault("Center autonomous", new AutonomousCenterGearDeliver());
        autonomousChooser.addObject("Right autonomous", new AutonomousRightGearDeliver());
        autonomousChooser.addObject("Left autonomous", new AutonomousLeftGearDeliver());
        autonomousChooser.addObject("Line autonomous", new AutonomousLine());
        autonomousChooser.addObject("Drive by time out autonomous", new AutonomousDriveByTimeOut());
        autonomousChooser.addObject("None", null);
        SmartDashboard.putData("Autonomous mode chooser", autonomousChooser);
        
        testModeChooser = new SendableChooser<>();
        testModeChooser.addDefault("False", false);
        testModeChooser.addObject("True", true);
        SmartDashboard.putData("Test mode", testModeChooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
    	Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
    	if(autonomousChooser != null && autonomousChooser.getSelected() != null) autonomousChooser.getSelected().start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    boolean isTestMode = false;
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
    	if(autonomousChooser != null && autonomousChooser.getSelected() != null) autonomousChooser.getSelected().cancel();
        
    	if(testModeChooser != null && testModeChooser.getSelected() != null) 
    		isTestMode = testModeChooser.getSelected();

        SmartDashboard.putBoolean("Reverse climber direction", false);
    }

    /**
     * This function is called periodically during operator control
     */
    double p, i,d, f;
    boolean isReversed;
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(isTestMode) { 
	        p = SmartDashboard.getNumber("Drive PID P", 0);
	        i = SmartDashboard.getNumber("Drive PID I", 0);
	        d = SmartDashboard.getNumber("Drive PID D", 0);
	        f = SmartDashboard.getNumber("Drive PID F", 0);
	        
	        RobotMap.driveTrainDriveLeftPIDController.setPID(p, i, d, f);
	        RobotMap.driveTrainDriveRightPIDController.setPID(p, i, d, f);   
	        
	        isReversed = SmartDashboard.getBoolean("Reverse climber direction", false);
	        Robot.climber.climbDirection = isReversed ? -Climber.DEFAULT_DIRECTION : Climber.DEFAULT_DIRECTION;        
	        	        
	        p = SmartDashboard.getNumber("Rotation PID P", 0);
	        i = SmartDashboard.getNumber("Rotation PID I", 0);
	        d = SmartDashboard.getNumber("Rotation PID D", 0);
	        f = SmartDashboard.getNumber("Rotation PID F", 0);
	        
	        RobotMap.driveTrainRotationLeftPIDController.setPID(p, i, d, f);
	        RobotMap.driveTrainRotationRightPIDController.setPID(p, i, d, f);
	
	        
	        Debug.getInstance().log(this, RobotMap.driveTrainFirstLeft.getPosition());
	        Debug.getInstance().log(this, RobotMap.driveTrainFirstRight.getPosition());
	        //Debug.getInstance().log(this, RobotMap.driveTrainGyro.getAngle());
	    	if(Robot.oi.driveStick.getRawButton(Button.B.value())) {
	    		RobotMap.driveTrainFirstLeft.setPosition(0);
	    		RobotMap.driveTrainFirstRight.setPosition(0);
	    	}
		   // System.out.println("Potentiometer: " + RobotMap.gearBlockerPotentiometer.get());
	    }
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
