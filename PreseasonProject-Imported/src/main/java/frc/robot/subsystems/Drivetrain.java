// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax rightRearMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax rightFrontMotor = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax leftRearMotor = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax leftFrontMotor = new CANSparkMax(4, MotorType.kBrushless);

  public Drivetrain() {
    //Double passed into this method sets the max speed the motor can accelrate in a second 
    rightRearMotor.setOpenLoopRampRate(0.2);
    //Int passed into the method sets the current limit for the motor
    rightRearMotor.setSmartCurrentLimit(60);
    //Can set the mode to either brake or coast
    rightRearMotor.setIdleMode(IdleMode.kBrake);//This method passes an enum that represents brake 
    
    //Double passed into this method sets the max speed the motor can accelrate in a second 
    rightFrontMotor.setOpenLoopRampRate(0.2);
    //Int passed into the method sets the current limit for the motor
    rightFrontMotor.setSmartCurrentLimit(60);
    //Can set the mode to either brake or coast
    rightFrontMotor.setIdleMode(IdleMode.kBrake);//This method passes an enum that represents brake 

    //Double passed into this method sets the max speed the motor can accelrate in a second 
    leftRearMotor.setOpenLoopRampRate(0.2);
    //Int passed into the method sets the current limit for the motor
    leftRearMotor.setSmartCurrentLimit(60);
    //Can set the mode to either brake or coast
    leftRearMotor.setIdleMode(IdleMode.kBrake);//This method passes an enum that represents brake 

    //Double passed into this method sets the max speed the motor can accelrate in a second 
    leftFrontMotor.setOpenLoopRampRate(0.2);
    //Int passed into the method sets the current limit for the motor
    leftFrontMotor.setSmartCurrentLimit(60);
    //Can set the mode to either brake or coast
    leftFrontMotor.setIdleMode(IdleMode.kBrake);//This method passes an enum that represents brake 
  }

  @Override
  public void periodic() {

  }
}
