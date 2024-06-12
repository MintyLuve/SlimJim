// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.LEDSubsystem;

public class LEDSolidColor extends Command {
  LEDSubsystem ledSubsystem;
  String color;

  /** Creates a new ChangeLEDColors. */
  public LEDSolidColor(LEDSubsystem m_ledSubsystem, String m_color) {
    ledSubsystem = m_ledSubsystem;
    color = m_color;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (color.equals("GREEN")){
      ledSubsystem.setGreen();
      ledSubsystem.setData();
    }
    else if (color.equals("RAINBOW")){
      ledSubsystem.setRainbowSolid();
      ledSubsystem.setData();
    }
    else {
      ledSubsystem.setBlank();
      ledSubsystem.setData();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
