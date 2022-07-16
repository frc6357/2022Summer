// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SqueezeSubsystem extends SubsystemBase {

    private final CANSparkMax leftMotor = new CANSparkMax(Constants.SQUEEZE_LEFT_MOTOR, MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(Constants.SQUEEZE_RIGHT_MOTOR, MotorType.kBrushless);

    /** Creates a new Squeezer subsystem. */
    public SqueezeSubsystem() {
        leftMotor.setIdleMode(IdleMode.kBrake);
        rightMotor.setIdleMode(IdleMode.kBrake);
        rightMotor.setInverted(true);
        // setMotorPID(Constants.P, Constants.I, Constants.D);
    }

    public void setMotorPID(double p, double i, double d) {
        setLeftPID(p, i, d);
        setRightPID(p, i, d);
    }

    /**
     * Sets the left motor speed
     * 
     * @param speed The desired speed from 0 to 1
     */
    public void setLeftMotorSpeed(double speed) {
        leftMotor.set(speed);
    }

    /**
     * Sets the right motor speed
     * 
     * @param speed The desired speed from 0 to 1
     */
    public void setRightMotorSpeed(double speed) {
        rightMotor.set(speed);
    }

    /**
     * Stops both motors
     */
    public void stop() {
        leftMotor.set(0.0);
        rightMotor.set(0.0);
    }

    /**
     * Sets the PID values for the left motor
     * 
     * @param p The desired P value
     * @param i The desired I value
     * @param d The desired D value
     */
    public void setLeftPID(double p, double i, double d) {
        setLeftP(p);
        setLeftI(i);
        setLeftD(d);
    }

    /**
     * Sets the PID values for the right motor
     * 
     * @param p The desired P value
     * @param i The desired I value
     * @param d The desired D value
     */
    public void setRightPID(double p, double i, double d) {
        setRightP(p);
        setRightI(i);
        setRightD(d);
    }

    /**
     * Sets the P value for the left motor's P value
     * 
     * @param p The P value to be set
     */
    public void setLeftP(double p) {
        leftMotor.getPIDController().setP(p);
    }

    /**
     * Sets the P value for the right motor's P value
     * 
     * @param p The P value to be set
     */
    public void setRightP(double p) {
        rightMotor.getPIDController().setP(p);
    }

    /**
     * Sets the I value for the left motor's I value
     * 
     * @param i The I value to be set
     */
    public void setLeftI(double i) {
        leftMotor.getPIDController().setI(i);
    }

    /**
     * Sets the I value for the right motor's I value
     * 
     * @param i The I value to be set
     */
    public void setRightI(double i) {
        rightMotor.getPIDController().setI(i);
    }

    /**
     * Sets the D value for the left motor's D value
     * 
     * @param d The D value to be set
     */
    public void setLeftD(double d) {
        leftMotor.getPIDController().setD(d);
    }

    /**
     * Sets the D value for the right motor's D value
     * 
     * @param d The D value to be set
     */
    public void setRightD(double d) {
        rightMotor.getPIDController().setD(d);
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
