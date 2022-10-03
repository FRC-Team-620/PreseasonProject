// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class MotorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private MotorSubsystem motorSubsystem;
  private XboxController controller;

  public MotorCommand(MotorSubsystem motorSubsystem, XboxController controller) {
    this.motorSubsystem = motorSubsystem;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(motorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    motorSubsystem.getMotor().set(0.1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // double forwardBackLeftStick = controller.getLeftY();
    // //Hi
    // motorSubsystem.getMotor().set(forwardBackLeftStick * Constants.speedFactor);//Percentage speed
    //motorSubsystem.getMotor().setVoltage(forwardBackLeftStick * 12);//Speed using voltage control

    System.out.println("Current Speed: " + motorSubsystem.getMotor().get());
    System.out.println("Current distance in encoder counts: " + motorSubsystem.getMotor().getEncoder().getPosition());
    System.out.println("Current velocity in rpm: " + motorSubsystem.getMotor().getEncoder().getVelocity());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Stops the motor
    this.motorSubsystem.getMotor().set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Tells the commmand to stop
    return controller.getAButton();
  }
}
