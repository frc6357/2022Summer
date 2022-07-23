// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.StartRollerCommand;
import frc.robot.subsystems.RollerSubsytem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here...
  private final RollerSubsytem rollerSubsytem;

  private final Joystick rollerJoystick = new Joystick(Constants.OI_ROLLER_CONTROLLER);

  private final JoystickButton rollerStartBtn = new JoystickButton(rollerJoystick, Constants.ROLLER_START_BUTTON);

  private final JoystickButton rollerStopBtn = new JoystickButton(rollerJoystick, Constants.ROLLER_STOP_BUTTON);




  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    rollerSubsytem = new RollerSubsytem();

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    rollerStartBtn.whenPressed(new StartRollerCommand(rollerSubsytem, Constants.ROLLER_SPEED));
    rollerStopBtn.whenPressed(new StartRollerCommand(rollerSubsytem, 0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
