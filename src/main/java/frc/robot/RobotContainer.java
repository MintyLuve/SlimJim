// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.FollowEncoder;
import frc.robot.Commands.MotorPID;
import frc.robot.Commands.XboxMove;
import frc.robot.Constants.DumbConstants;
import frc.robot.Constants.LEDConstants;
import frc.robot.Commands.LEDSolidColor;
import frc.robot.Commands.LEDRainbow;
import frc.robot.Commands.CompressorToggle;
import frc.robot.Commands.SolenoidToggle;
import frc.robot.Subsystems.Compressy;
import frc.robot.Subsystems.LEDSubsystem;
import frc.robot.Subsystems.Motor;
import frc.robot.Subsystems.Solly;

public class RobotContainer {
  Motor motor = new Motor();
  Solly solenoid = new Solly();
  Compressy compressor = new Compressy();
  XboxMove xboxMove = new XboxMove(motor);
  
  AddressableLED ledStrip = new AddressableLED(LEDConstants.LED_PORT);
  AddressableLEDBuffer stripBuffer = new AddressableLEDBuffer(LEDConstants.LED_COUNT);
  LEDSubsystem ledSubsystem = new LEDSubsystem(ledStrip, stripBuffer);
  
  private CommandXboxController operator = Controls.operator;

  public RobotContainer() {
    motor.setDefaultCommand(xboxMove);
    ledStrip.setLength(LEDConstants.LED_COUNT);
    Commands.waitSeconds(10);
    ledStrip.setData(stripBuffer);
    ledStrip.start();
    
    configureBindings();
  }

  private void configureBindings() {
    operator.y().whileTrue(new MotorPID(motor, DumbConstants.FULL_POSITION_FORWARD));
    operator.b().whileTrue(new MotorPID(motor, DumbConstants.HALF_POSITION_REVERSE));
    operator.a().toggleOnTrue(new FollowEncoder(motor));
    operator.povLeft().onTrue(new SolenoidToggle(solenoid));
    operator.povUp().onTrue(new CompressorToggle(compressor));
    operator.povRight().onTrue(new LEDSolidColor(ledSubsystem, "GREEN"));
    operator.povDown().toggleOnTrue(new LEDRainbow(ledSubsystem));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
