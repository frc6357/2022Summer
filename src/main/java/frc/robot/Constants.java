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
public final class Constants 
{
    public static final int ROLLER_MOTOR         = 10; // CAN ID

    public static final int ROLLER_SPEED         = 1; // Roller Speed

    public static final int ROLLER_START_BUTTON  = 5; // Left Bumper

    public static final int ROLLER_STOP_BUTTON   = 6; // Right Bumper

    public static final int OI_ROLLER_CONTROLLER = 2; // Joystick Port

    public static double ROLLER_KP            = 0.0;

    public static double ROLLER_KI            = 0.0;

    public static double ROLLER_KD            = 0.0;

    public static final double ROLLER_DIAMETER = 1.25;

    public static final int ROLLER_CPR = 2048;

    public static final double ROLLER_GEAR_RATIO = 3.0 / 1.0;

    public static final double ROLLER_DISTANCE_PER_PULSE = (ROLLER_DIAMETER * Math.PI) / ((double) ROLLER_CPR * ROLLER_GEAR_RATIO);
}