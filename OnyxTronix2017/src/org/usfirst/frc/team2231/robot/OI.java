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
import org.usfirst.frc.team2231.robot.commands.AutonomousCommand;
import org.usfirst.frc.team2231.robot.commands.CloseGearBlockerPiston;
import org.usfirst.frc.team2231.robot.commands.CloseGearHolderPiston;
import org.usfirst.frc.team2231.robot.commands.CloseShifters;
import org.usfirst.frc.team2231.robot.commands.CollectBalls;
import org.usfirst.frc.team2231.robot.commands.DriveByJoystick;
import org.usfirst.frc.team2231.robot.commands.StartTrigger;
import org.usfirst.frc.team2231.robot.commands.OpenGearBlockerPiston;
import org.usfirst.frc.team2231.robot.commands.OpenGearHolderPiston;
import org.usfirst.frc.team2231.robot.commands.OpenShifters;
import org.usfirst.frc.team2231.robot.commands.ToggleGearHold;
import org.usfirst.frc.team2231.robot.commands.ToggleShoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    public JoystickButton collectBalls;
    public JoystickButton toggleGearHold;
    public JoystickButton shoot;
    public JoystickButton load;
    public JoystickButton test;
    public Joystick buttonStick;
    public JoystickButton openShifters;
    public JoystickButton closeShifters;
    public Joystick driveStick;

    public OI() {
        driveStick = new Joystick(1);
        
        closeShifters = new JoystickButton(driveStick, Button.Start.value());
        closeShifters.whenPressed(new CloseShifters());
        openShifters = new JoystickButton(driveStick, Button.Back.value());
        openShifters.whenPressed(new OpenShifters());
        
        buttonStick = new Joystick(0);
        
        collectBalls = new JoystickButton(buttonStick, Button.A.value());
        collectBalls.whileHeld(new CollectBalls(1));
        toggleGearHold = new JoystickButton(buttonStick, Button.X.value());
        toggleGearHold.whenPressed(new ToggleGearHold());
        load = new JoystickButton(buttonStick, Button.RB.value());
        load.whileHeld(new StartTrigger(1));
        shoot = new JoystickButton(buttonStick, Button.LB.value());
        shoot.whenPressed(new ToggleShoot());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveByJoystick", new DriveByJoystick());
        SmartDashboard.putData("OpenShifters", new OpenShifters());
        SmartDashboard.putData("CloseShifters", new CloseShifters());
        SmartDashboard.putData("OpenGearHolderPiston", new OpenGearHolderPiston());
        SmartDashboard.putData("CloseGearHolderPiston", new CloseGearHolderPiston());
        SmartDashboard.putData("OpenGearBlockerPiston", new OpenGearBlockerPiston());
        SmartDashboard.putData("CloseGearBlockerPiston", new CloseGearBlockerPiston());
    }

    public Joystick getButtonStick() {
        return buttonStick;
    }

    public Joystick getDriveStick() {
        return driveStick;
    }
}

