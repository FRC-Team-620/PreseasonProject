// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax rightRearMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax rightFrontMotor = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax leftRearMotor = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax leftFrontMotor = new CANSparkMax(4, MotorType.kBrushless);
  
  private DifferentialDrive differentialDrive;

  public Drivetrain() {
    setupMotors();
    setupFollowerMotors();

/*     leftFrontMotor.setInverted(true);
 */
    //creates differential drive
    differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  private void setupMotors() {
    rightRearMotor = setupMotor(rightRearMotor);
    rightFrontMotor = setupMotor(rightFrontMotor);
    leftRearMotor = setupMotor(leftRearMotor);
    leftFrontMotor = setupMotor(leftFrontMotor);
  }

  public void setupFollowerMotors() {
    leftRearMotor.follow(leftFrontMotor);
    rightRearMotor.follow(rightFrontMotor);

    rightFrontMotor.setInverted(false);
    leftFrontMotor.setInverted(true);

    //rightRearMotor.follow(rightFrontMotor);
    // leftRearMotor.follow(leftFrontMotor);
  }



  public CANSparkMax setupMotor(CANSparkMax motor) {
    //Double passed into this method sets the max speed the motor can accelrate in a second 
    motor.setOpenLoopRampRate(0.2);

    //Int passed into the method sets the current limit for the motor
    motor.setSmartCurrentLimit(60);

    //Can set the mode to either brake or coast
    motor.setIdleMode(IdleMode.kBrake);//This method passes an enum that represents brake 

    System.out.println("Motor created: " + motor.toString());
    return motor;
  }

  //Used as a method to pass through the infomation from the drive command (Like the speed, rotation, and if we want quick turn (Tank drive) or not)
  //into the differentialDrive in this subsystem
  public void setCurvatureDrive(double speed, double rotation, boolean quickTurn) {
    differentialDrive.curvatureDrive(speed, rotation, quickTurn);
  }

  public void setRightMotors(double speed) {
    this.rightFrontMotor.set(speed);
  }

  public void setLeftMotors(double speed) {
    this.leftFrontMotor.set(speed);
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
