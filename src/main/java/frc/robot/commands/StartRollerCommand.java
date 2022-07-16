// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RollerSubsytem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Starts the roller motor to a specified speed */
public class StartRollerCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RollerSubsytem roller;
  private final double speed;

  /**
     * Constructor for the start roller command.
     * 
     * @param roller
     *            The roller subsystem on which the command operates.
     * @param speed
     *            The roller speed to be set.
     */
  public StartRollerCommand(RollerSubsytem roller, double speed) 
  {
    this.roller = roller;
    this.speed = speed;
    
    addRequirements(roller);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    roller.setRollerMotorSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return true;
  }
}
