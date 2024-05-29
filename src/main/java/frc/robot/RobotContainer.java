// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.XboxMove;
import frc.robot.Subsystems.Motor;

public class RobotContainer {
  Motor motor = new Motor();
  XboxMove xboxMove = new XboxMove(motor);

  public RobotContainer() {
    motor.setDefaultCommand(xboxMove);
    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
