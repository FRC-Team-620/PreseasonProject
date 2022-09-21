// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
  private CANSparkMax motor = new CANSparkMax(1, MotorType.kBrushless);
  public MotorSubsystem() {

      //Double passed into this method sets the max speed the motor can accelrate in a second 
      motor.setOpenLoopRampRate(0.2);

      //Int passed into the method sets the current limit for the motor
      motor.setSmartCurrentLimit(60);

      //Can set the mode to either brake or coast
      motor.setIdleMode(IdleMode.kBrake);//This method passes an enum that represents brake 

      System.out.println("Motor created: " + motor.toString());
  }

  public CANSparkMax getMotor() {
    return motor;
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
