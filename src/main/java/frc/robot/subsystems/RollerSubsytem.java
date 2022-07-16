// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.base.MotorEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Class controlling the roller subsystem.
 */
public class RollerSubsytem extends SubsystemBase 
{
  /** Creates a new roller motor with the CAN ID in Constants and a brushless type */
  private WPI_TalonFX rollerMotor = new WPI_TalonFX(Constants.ROLLER_MOTOR);

  private final MotorEncoder rollerEncoder = new MotorEncoder(rollerMotor, Constants.ROLLER_DISTANCE_PER_PULSE, false);

  public static final PIDController rollerController = new PIDController(Constants.ROLLER_KP, Constants.ROLLER_KI, Constants.ROLLER_KD);

  /** Creates a new RollerSubsystem. */
  public RollerSubsytem() 
  {
    rollerMotor.setNeutralMode(NeutralMode.Brake);
    rollerMotor.setInverted(true);

    SmartDashboard.putNumber("P Value", Constants.ROLLER_KP);
    SmartDashboard.putNumber("I Value", Constants.ROLLER_KI);
    SmartDashboard.putNumber("D Value", Constants.ROLLER_KD);
  }

  /** Sets the roller motor to a certain speed */
  public void setRollerMotorSpeed(double speed)
  {
      rollerMotor.set(rollerController.calculate(rollerEncoder.getVelocityMeters(), Constants.ROLLER_SPEED));
  }

  /** Stops the roller motor */
  public void stop()
  {
    rollerMotor.set(0);
  }

  public void setPID(double p, double i, double d)
  {
      rollerController.setP(p);
      rollerController.setI(i);
      rollerController.setD(d);
  }

  public void setP(double p)
  {
    Constants.ROLLER_KP = p;
  }

  public void setI(double i)
  {
    Constants.ROLLER_KI = i;
  }

  public void setD(double d)
  {
    Constants.ROLLER_KD = d;
  }
  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
    if(SmartDashboard.getNumber("P Value", 0) != Constants.ROLLER_KP)
    {
        Constants.ROLLER_KP = SmartDashboard.getNumber("P Value", 0);

    }

    if(SmartDashboard.getNumber("I Value", 0) != Constants.ROLLER_KI)
    {
        Constants.ROLLER_KI= SmartDashboard.getNumber("I Value", 0);

    }

    if(SmartDashboard.getNumber("D Value", 0) != Constants.ROLLER_KD)
    {
        Constants.ROLLER_KD = SmartDashboard.getNumber("D Value", 0);

    }
  }

  @Override
  public void simulationPeriodic() 
  {
    // This method will be called once per scheduler run during simulation
  }
}
