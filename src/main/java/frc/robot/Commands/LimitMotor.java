// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Limiter;
import frc.robot.Subsystems.Motor;

public class LimitMotor extends Command {
  /** Creates a new LimitStop. */
  Limiter limiter;
  Motor motor;

  public LimitMotor(Limiter m_limiter, Motor m_motor) {
    limiter = m_limiter;
    motor = m_motor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_limiter, m_motor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean state = limiter.getState();
    if (state){
      motor.stop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
