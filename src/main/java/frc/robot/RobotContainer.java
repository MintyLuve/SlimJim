// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.FollowEncoder;
import frc.robot.Commands.MotorPID;
import frc.robot.Commands.XboxMove;
import frc.robot.Constants.DumbConstants;
import frc.robot.Commands.CompressorToggle;
import frc.robot.Commands.SolenoidToggle;
import frc.robot.Subsystems.Compressy;
import frc.robot.Subsystems.Motor;
import frc.robot.Subsystems.Solly;

public class RobotContainer {
  Motor motor = new Motor();
  Solly solenoid = new Solly();
  Compressy compressor = new Compressy();
  XboxMove xboxMove = new XboxMove(motor);
  private CommandXboxController operator = Controls.operator;

  public RobotContainer() {
    motor.setDefaultCommand(xboxMove);
    //limiter.setDefaultCommand(limitMotor);
    configureBindings();
  }

  private void configureBindings() {
    operator.y().whileTrue(new MotorPID(motor, DumbConstants.FULL_POSITION_FORWARD));
    operator.b().whileTrue(new MotorPID(motor, DumbConstants.HALF_POSITION_REVERSE));
    operator.a().toggleOnTrue(new FollowEncoder(motor));
    operator.povLeft().onTrue(new SolenoidToggle(solenoid));
    operator.povUp().onTrue(new CompressorToggle(compressor));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
