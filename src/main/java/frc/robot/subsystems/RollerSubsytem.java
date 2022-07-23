// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * Class controlling the roller subsystem.
 */
public class RollerSubsytem extends SubsystemBase 
{
  /** Creates a new roller motor with the CAN ID in Constants and a brushless type */
  private CANSparkMax rollerMotor = new CANSparkMax(Constants.ROLLER_MOTOR, MotorType.kBrushless);

  private double kP = Constants.ROLLER_KP;
  private double kI = Constants.ROLLER_KI;
  private double kD = Constants.ROLLER_KD;
  /** Creates a new RollerSubsystem. */
  public RollerSubsytem() 
  {
    rollerMotor.setIdleMode(IdleMode.kBrake);
    rollerMotor.setInverted(true);

    SmartDashboard.putNumber("P Value", Constants.ROLLER_KP);
    SmartDashboard.putNumber("I Value", Constants.ROLLER_KI);
    SmartDashboard.putNumber("D Value", Constants.ROLLER_KD);
  }

  /** Sets the roller motor to a certain speed */
  public void setRollerMotorSpeed(double speed)
  {
      // rollerMotor.set();
      rollerMotor.set(speed);
    }

  /** Stops the roller motor */
  public void stop()
  {
    rollerMotor.set(0);
  }

  public void setPID(double p, double i, double d)
  {
      rollerMotor.getPIDController().setP(p);
      rollerMotor.getPIDController().setI(i);      
      rollerMotor.getPIDController().setD(d);  
    }

  public void setP(double p)
  {
    rollerMotor.getPIDController().setP(p);  
  }

  public void setI(double i)
  {
    rollerMotor.getPIDController().setI(i);
  }

  public void setD(double d)
  {
    rollerMotor.getPIDController().setD(d);
  }
  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
    if(SmartDashboard.getNumber("P Value", 0) != kP)
    {
        kP = SmartDashboard.getNumber("P Value", 0);
        setP(kP);

    }

    if(SmartDashboard.getNumber("I Value", 0) != kI)
    {
        kI = SmartDashboard.getNumber("I Value", 0);
        setI(kI);
    }

    if(SmartDashboard.getNumber("D Value", 0) != kD)
    {
        kD = SmartDashboard.getNumber("D Value", 0);
        setD(kD);
    }
  }

  @Override
  public void simulationPeriodic() 
  {
    // This method will be called once per scheduler run during simulation
  }
}
