// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SqueezeSubsystem;

/**
 * A command that uses an sets the motor speeds of the squeezer. A speed will
 * either open or close
 * both squeeze arms at the same time.
 */
public class SqueezeMotorCommand extends CommandBase {

    private SqueezeSubsystem subsystem;
    private double speed;

    /**
     * Creates a new SqueezeMotorCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public SqueezeMotorCommand(SqueezeSubsystem subsystem, double speed) {
        this.subsystem = subsystem;
        this.speed = speed;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        subsystem.setLeftMotorSpeed(speed);
        subsystem.setRightMotorSpeed(speed);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }
}
