// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.LEDSubsystem;

public class LEDRainbow extends Command {
  LEDSubsystem ledSubsystem;
  String color;

  /** Creates a new RainbowLED. */
  public LEDRainbow(LEDSubsystem m_ledSubsystem) {
    ledSubsystem = m_ledSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Commands.waitSeconds(10);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      ledSubsystem.setRainbowChanging();
      Commands.waitSeconds(10);
      ledSubsystem.setData();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    Commands.waitSeconds(10);
    return false;
  }
}
