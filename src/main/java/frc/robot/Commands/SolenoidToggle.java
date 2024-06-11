// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Controls;
import frc.robot.Subsystems.Solly;

public class SolenoidToggle extends Command {
  /** Creates a new Toggle. */
  Solly solenoid;
  public SolenoidToggle(Solly m_solenoid) {
    solenoid = m_solenoid;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(solenoid);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (solenoid.getState().equals(Value.kForward)){
      solenoid.retract();
    }
    else if (solenoid.getState().equals(Value.kReverse)){
      solenoid.extend();
    }
    else {
      solenoid.retract();
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
