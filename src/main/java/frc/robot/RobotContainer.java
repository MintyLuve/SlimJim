// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.LimitMotor;
import frc.robot.Commands.Toggle;
import frc.robot.Commands.XboxMove;
import frc.robot.Subsystems.Limiter;
import frc.robot.Subsystems.Motor;
import frc.robot.Subsystems.Solly;

public class RobotContainer {
  Motor motor = new Motor();
  Solly solenoid = new Solly();
  Limiter limiter = new Limiter();
  XboxMove xboxMove = new XboxMove(motor);
  LimitMotor limitMotor = new LimitMotor(limiter, motor);
  private CommandXboxController operator = Controls.operator;

  public RobotContainer() {
    motor.setDefaultCommand(xboxMove);
    //limiter.setDefaultCommand(limitMotor);
    configureBindings();
  }

  private void configureBindings() {
    operator.x().onTrue(new Toggle(solenoid));
    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
