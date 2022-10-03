// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // units the auto goes forward
    public static double autoDistance = -12500;
    //Low hub
    public static double shortShooterSpeed = -.32;
    //HIGH hub - Shooter motors that shoots the ball from the hood - grey wheels
    public static double normalShooterSpeed = -.925;
    // shooterIntakeSpeed set to -1 
    public static double shooterIntakeSpeed = -1;
    //Pulls the ball into the robot from the intake motor when down
    public static double frontIntakeSpeed = -.5;
    // speed the climber arms go up
    public static double climberSpeed = .8;
    // inner intake speed
    public static double intakeSpeed = .5; 
    // intake arm speed
    public static double intakeMoverSpeed = .17;
    // angle the robot turns to during auto
    public static double turnAngle = 160;
    // the speeds the shooter has to get to for the shooter intake motor to go
    public static double velocityThreshold = -14000;
    public static double shortVelocityThreshold = -10000;
    // Speed on how fast the ball intake raises 
    public static double stopUpSpeed = -0.3;

    // dont edit
    public static double frontIntakePosStop = 28600; // where the front intake wont go anywhere
    public static double ticks2feetDrive= 0.0022818;
    public static double distanceTocargoRing= 7.2; //distance from the hoops(beginning autonomus position) to the cargo ring(the ball position)
    
    
}
