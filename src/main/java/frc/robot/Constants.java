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
    public static final int SQUEEZE_LEFT_MOTOR              = 10;   // CAN ID
    public static final int SQUEEZE_RIGHT_MOTOR             = 11;   // CAN ID

    public static final double SQUEEZE_SPEED                = 0.25;
    public static final double UNSQUEEZE_SPEED              = -0.25;

    public static final int OI_DRIVER                       = 0;

    public static final int OI_OPEN                         = 1;    // B Button
    public static final int OI_CLOSE                        = 0;    // A Button

    public static final double P                            = 0;
    public static final double I                            = 0;
    public static final double D                            = 0;
}