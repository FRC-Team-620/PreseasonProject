// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Drivetrain drivetrain;
  private XboxController controller;

  public DriveCommand(Drivetrain drivetrain, XboxController controller) {
    this.drivetrain = drivetrain;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Linear input: takes the numbers straight from their controller inputs with no modification
    //double rotationInput = controller.getLeftX();//used for turning the bot, uses the left stick on the x axis
    //double leftTriggerInput = controller.getLeftTriggerAxis();//used for backward movement
    //double rightTriggerInput = controller.getRightTriggerAxis();//used for forward movement
    
    //Squared input: allows you to have more control when moving slowly but be able to move fast quickly
    //This was the input scheme we went with last season in 2022
    double leftTriggerInput = Math.pow(controller.getLeftTriggerAxis(), 2);//used for backward movement
    double rightTriggerInput = Math.pow(controller.getRightTriggerAxis(), 2);//used for forward movement
    double rotationInput = Math.pow(controller.getLeftX(), 2);
    rotationInput *= Math.signum(controller.getLeftX());//This is either -1 if the input is a negative or 1 if the input is a positive 


    double speed = 0;
    boolean quickTurn = false;//Used for tank steering if true
    if (controller.getAButton()) {//if the A button is held then tank steering is enabled
      quickTurn = true;
    }


    //The if statement allows for the left and right inputs to be pressed down at the same time but the one pressed down more
    //controls the bot
    //Both of the following statements do the same thing
    //Expanded if else statement
    if (leftTriggerInput > rightTriggerInput) {
      speed = -leftTriggerInput;
    } else {
      speed = rightTriggerInput;
    }
    //Inline if else statement
    //speed = rightTriggerInput > leftTriggerInput ? rightTriggerInput : -leftTriggerInput;


    drivetrain.setCurvatureDrive(speed, rotationInput, quickTurn);

    //System.out.println("Current Speed: " + motorSubsystem.getMotor().get());
    //System.out.println("Current distance in encoder counts: " + motorSubsystem.getMotor().getEncoder().getPosition());
    //System.out.println("Current velocity in rpm: " + motorSubsystem.getMotor().getEncoder().getVelocity());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
