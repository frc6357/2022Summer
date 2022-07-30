// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SqueezeSubsystem extends SubsystemBase {

    private final DoubleSolenoid squeezePiston = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.SQUEEZE,
            Constants.UNSQUEEZE);

    /** Creates a new Squeezer subsystem. */
    public SqueezeSubsystem() {
    }

    /**
     * Closes the hand mechanism to grab the ball
     */
    public void squeeze() {
        squeezePiston.set(Value.kForward);
    }

    /**
     * Opens up the hand to let go of ball
     */
    public void unsqueeze() {
        squeezePiston.set(Value.kReverse);
    }

    /**
     * Sets no pressure to the piston
     */
    public void off()
    {
        squeezePiston.set(Value.kOff);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
